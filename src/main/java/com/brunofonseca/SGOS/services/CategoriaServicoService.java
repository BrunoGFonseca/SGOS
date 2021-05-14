package com.brunofonseca.SGOS.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.repositories.CategoriaServicoRepository;
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
	
	public CategoriaServico insert(CategoriaServico obj) {
		obj.setId(null);
		return repoServProd.save(obj);
	}
}