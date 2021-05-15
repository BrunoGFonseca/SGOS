package com.brunofonseca.SGOS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.domain.Servico;
import com.brunofonseca.SGOS.repositories.CategoriaServicoRepository;
import com.brunofonseca.SGOS.repositories.ServicoRepository;
import com.brunofonseca.SGOS.services.exceptions.ObjectNotFoundException;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private CategoriaServicoRepository catServRepository;

	public Servico find(Integer id) {
		Optional<Servico> obj = servicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));
	}
	
	public Page<Servico> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageResquest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<CategoriaServico> categorias = catServRepository.findAllById(ids);
		return servicoRepository.search(nome, categorias, pageResquest);
		

	}
}

















