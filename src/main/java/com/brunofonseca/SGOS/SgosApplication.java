package com.brunofonseca.SGOS;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brunofonseca.SGOS.domain.CategoriaProduto;
import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.domain.Produto;
import com.brunofonseca.SGOS.domain.Servico;
import com.brunofonseca.SGOS.repositories.CategoriaProdutoRepository;
import com.brunofonseca.SGOS.repositories.CategoriaServicoRepository;
import com.brunofonseca.SGOS.repositories.ProdutoRepository;
import com.brunofonseca.SGOS.repositories.ServicoRepository;

@SpringBootApplication
public class SgosApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	@Autowired
	private CategoriaServicoRepository categoriaServicoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SgosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Instanciando a categoriaProduto e CategoriaServiço
		CategoriaProduto catProd1 = new CategoriaProduto(null, "ProdutoMotor");
		CategoriaProduto catProd2 = new CategoriaProduto(null, "ProdutoSuspensao");
		
		CategoriaServico catServ1 = new CategoriaServico(null, "ServicoMotor");
		CategoriaServico catServ2 = new CategoriaServico(null, "ServicoSuspensao");
		
		//Instanciando produtos e servicos
		Produto p1 = new Produto(null, "FiltroOleo", 15.00);
		Produto p2 = new Produto(null, "CorreaDentada", 9.99);
		Produto p3 = new Produto(null, "FiltroAr", 20.00);
		Produto p4 = new Produto(null, "MolaSuspensao", 12.00);
		
		Servico s1 = new Servico(null, "trocaFiltroOleo", 5.00);
		Servico s2 = new Servico(null, "trocaCorreaDentada", 7.00);
		Servico s3 = new Servico(null, "TrocaFiltroAr", 7.50);
		Servico s4 = new Servico(null, "TrocaMolaSuspensao", 5.00);
		
		//Vinculando produtos e serviços dentro das categorias
		
		catProd1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		catProd2.getProdutos().addAll(Arrays.asList(p4));
		catServ1.getServicos().addAll(Arrays.asList(s1, s2, s3));
		catServ2.getServicos().addAll(Arrays.asList(s4));
		
		//Vinculado categorias para os produtos e serviços
		p1.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		p2.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		p3.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		p4.getCategoriaProdutos().addAll(Arrays.asList(catProd2));
		
		s1.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		s2.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		s3.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		s4.getCategoriaServicos().addAll(Arrays.asList(catServ2));
		
		//Salvando categorias
		categoriaProdutoRepository.saveAll(Arrays.asList(catProd1, catProd2));
		categoriaServicoRepository.saveAll(Arrays.asList(catServ1, catServ2));
		
		//Salando produtos e servicos
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		servicoRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
	}
}