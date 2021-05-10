package com.brunofonseca.SGOS.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunofonseca.SGOS.domain.CategoriaProduto;
import com.brunofonseca.SGOS.services.CategoriaProdutoService;

@RestController
@RequestMapping(value = "/categoria_produtos")
public class CategoriaProdutoResource {

	@Autowired
	private CategoriaProdutoService catProdService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		CategoriaProduto obj = catProdService.find(id);
		return ResponseEntity.ok(obj);
	}
}