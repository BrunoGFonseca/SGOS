package com.brunofonseca.SGOS.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.repositories.CategoriaServicoRepository;

@Service
public class CategoriaServicoService {
	
	@Autowired
	private CategoriaServicoRepository repoServProd;

	public CategoriaServico find(Integer id) {
		Optional<CategoriaServico> obj = repoServProd.findById(id);
		return obj.orElse(null);
	}
}