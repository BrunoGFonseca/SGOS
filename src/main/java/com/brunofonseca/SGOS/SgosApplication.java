package com.brunofonseca.SGOS;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brunofonseca.SGOS.domain.CategoriaProduto;
import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.repositories.CategoriaProdutoRepository;
import com.brunofonseca.SGOS.repositories.CategoriaServicoRepository;

@SpringBootApplication
public class SgosApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	@Autowired
	private CategoriaServicoRepository categoriaServicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SgosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CategoriaProduto catProd1 = new CategoriaProduto(null, "ProdutoMotor");
		CategoriaProduto catProd2 = new CategoriaProduto(null, "ProdutoSuspensao");
		
		CategoriaServico catServ1 = new CategoriaServico(null, "ServicoMotor");
		CategoriaServico catServ2 = new CategoriaServico(null, "ServicoSuspensao");

		categoriaProdutoRepository.saveAll(Arrays.asList(catProd1, catProd2));
		categoriaServicoRepository.saveAll(Arrays.asList(catServ1, catServ2));
	}
}