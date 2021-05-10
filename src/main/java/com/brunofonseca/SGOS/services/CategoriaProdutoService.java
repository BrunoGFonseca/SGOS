package com.brunofonseca.SGOS.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.CategoriaProduto;
import com.brunofonseca.SGOS.repositories.CategoriaProdutoRepository;

@Service
public class CategoriaProdutoService {

	@Autowired
	private CategoriaProdutoRepository repoCatProd;

	public CategoriaProduto find(Integer id) {
		Optional<CategoriaProduto> obj = repoCatProd.findById(id);
		return obj.orElse(null);
	}
}