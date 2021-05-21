package com.brunofonseca.SGOS.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.brunofonseca.SGOS.domain.Cidade;
import com.brunofonseca.SGOS.domain.Cliente;
import com.brunofonseca.SGOS.domain.Endereco;
import com.brunofonseca.SGOS.domain.Veiculo;
import com.brunofonseca.SGOS.domain.enums.Perfil;
import com.brunofonseca.SGOS.domain.enums.TipoCliente;
import com.brunofonseca.SGOS.dto.ClienteDTO;
import com.brunofonseca.SGOS.dto.ClienteNewDTO;
import com.brunofonseca.SGOS.repositories.ClienteRepository;
import com.brunofonseca.SGOS.repositories.EnderecoRepository;
import com.brunofonseca.SGOS.repositories.VeiculoRepository;
import com.brunofonseca.SGOS.security.UserSS;
import com.brunofonseca.SGOS.services.exceptions.AuthorizationException;
import com.brunofonseca.SGOS.services.exceptions.DataIntegrityException;
import com.brunofonseca.SGOS.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private S3Service s3Service;
	
	
	public Cliente find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if(user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageResquest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageResquest);
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = clienteRepository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		veiculoRepository.saveAll(obj.getVeiculos());
		
		return clienteRepository.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return clienteRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			clienteRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir pois existem pedidos relacionados.");
		}
	}
	
	public Cliente fromDTO(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null, null);
	}	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		//Dados do cliente
		Cliente cli = new Cliente(
				null, 
				objDto.getNome(),
				objDto.getEmail(),
				objDto.getCpfOuCnpj(),
				TipoCliente.toEnum(objDto.getTipo()),
				bCryptPasswordEncoder.encode(objDto.getSenha()));
				
		
		//Dados do endereço
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(
				null, 
				objDto.getLogradouro(), 
				objDto.getNumero(), 
				objDto.getComplemento(), 
				objDto.getBairro(),
				objDto.getCep(), 
				cli, 
				cid);
		cli.getEnderecos().add(end);
		
		//Telefones
		cli.getTelefones().add(objDto.getTelefone1());
		if(objDto.getTelefone2()!= null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if(objDto.getTelefone3()!= null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		
		//Dados do Veiculo
		Veiculo veic = new Veiculo(
				null, 
				objDto.getModelo(), 
				objDto.getPlaca(), 
				objDto.getAno(), 
				cli);
		cli.getVeiculos().add(veic);	
		
		return cli;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile) {
		UserSS user = UserService.authenticated();

		if(user == null) {
			throw new AuthorizationException("Acesso Negado");
		}
		
		URI uri = s3Service.uploadFile(multipartFile);
		
		Cliente cli = clienteRepository.findById(user.getId());
		cli.setImageUrl(uri.toString());
		clienteRepository.save(cli);
		return uri;
	}
}