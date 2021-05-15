package com.brunofonseca.SGOS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.CategoriaProduto;
import com.brunofonseca.SGOS.domain.Produto;
import com.brunofonseca.SGOS.repositories.CategoriaProdutoRepository;
import com.brunofonseca.SGOS.repositories.ProdutoRepository;
import com.brunofonseca.SGOS.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaProdutoRepository catProdRepository;

	public Produto find(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageResquest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<CategoriaProduto> categorias = catProdRepository.findAllById(ids);
		return produtoRepository.search(nome, categorias, pageResquest);
	}
}















