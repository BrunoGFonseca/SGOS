package com.brunofonseca.SGOS.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunofonseca.SGOS.domain.CategoriaProduto;

@RestController
@RequestMapping(value="/categoria_produtos")
public class CategoriaProdutoResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CategoriaProduto> listar() {
		
		CategoriaProduto catProd1 = new CategoriaProduto(1, "ProdutoMotor");
		
		List<CategoriaProduto> listaCatProdutos = new ArrayList<>();
		listaCatProdutos.add(catProd1);
		
		return listaCatProdutos;
	}
}