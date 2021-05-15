package com.brunofonseca.SGOS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.dto.CategoriaServicoDTO;
import com.brunofonseca.SGOS.repositories.CategoriaServicoRepository;
import com.brunofonseca.SGOS.services.exceptions.DataIntegrityException;
import com.brunofonseca.SGOS.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServicoService {
	
	@Autowired
	private CategoriaServicoRepository repoServProd;

	public CategoriaServico find(Integer id) {
		Optional<CategoriaServico> obj = repoServProd.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaServico.class.getName()));
	}
	
	public List<CategoriaServico> findAll(){
		return repoServProd.findAll();
	}
	
	public Page<CategoriaServico> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageResquest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repoServProd.findAll(pageResquest);
	}
	
	public CategoriaServico insert(CategoriaServico obj) {
		obj.setId(null);
		return repoServProd.save(obj);
	}
	
	public CategoriaServico update(CategoriaServico obj) {
		find(obj.getId());
		return repoServProd.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repoServProd.deleteById(id);
		}
		catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir uma categoria de serviço que tenha serviços associados.");
		}
	}
	public CategoriaServico fromDTO(CategoriaServicoDTO objDTO) {
		return new CategoriaServico(objDTO.getId(), objDTO.getNome());
	}
}