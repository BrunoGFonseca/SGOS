package com.brunofonseca.SGOS;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brunofonseca.SGOS.domain.CategoriaProduto;
import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.domain.Cidade;
import com.brunofonseca.SGOS.domain.Cliente;
import com.brunofonseca.SGOS.domain.Endereco;
import com.brunofonseca.SGOS.domain.Estado;
import com.brunofonseca.SGOS.domain.Produto;
import com.brunofonseca.SGOS.domain.Servico;
import com.brunofonseca.SGOS.domain.Veiculo;
import com.brunofonseca.SGOS.domain.enums.TipoCliente;
import com.brunofonseca.SGOS.repositories.CategoriaProdutoRepository;
import com.brunofonseca.SGOS.repositories.CategoriaServicoRepository;
import com.brunofonseca.SGOS.repositories.CidadeRepository;
import com.brunofonseca.SGOS.repositories.ClienteRepository;
import com.brunofonseca.SGOS.repositories.EnderecoRepository;
import com.brunofonseca.SGOS.repositories.EstadoRepository;
import com.brunofonseca.SGOS.repositories.ProdutoRepository;
import com.brunofonseca.SGOS.repositories.ServicoRepository;
import com.brunofonseca.SGOS.repositories.VeiculoRepository;

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
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;

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
		
		//Salvando produtos e servicos
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		servicoRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
		
		//------------------------------------------------------------------------------------------------
		
		//Instanciando Estados e cidades
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberaba", est1);
		Cidade c2 = new Cidade(null, "Uberlandia", est1);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		Cidade c4 = new Cidade(null, "Ribeirao Preto", est2);
		
		//Vinculado cidades nos estados
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3, c4));
		
		//Salvando Estados e Cidades
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		//Instanciando Cliente 01, telefone e endereços
		
		Cliente cli1 = new Cliente(null, 
				"Bruno Gabriel Fonseca", 
				"brunogabrielfonseca@hotmail.com", 
				"39053854819",
				TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("992954181", "992451800"));
		
		Endereco e1 = new Endereco(null, 
				"Rua Angelo Guido de Gaitani", 
				"221", 
				null, 
				"Manoel Penna", 
				"14098327", 
				cli1, 
				c4);
		
		Endereco e2 = new Endereco(null, 
				"Rua do Carmo", 
				"377", 
				"Ap 107", 
				"Abadia", 
				"38025000 ", 
				cli1, 
				c1);
		
		//Associando endereços aos clientes
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		//Salvando clientes e enderecos.
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		//Instaciando veiculo
		Veiculo v1 = new Veiculo(null, "Uno", "BHK8177", "1997", cli1);
		
		//Associando veiculos ao cliente
		cli1.getVeiculos().addAll(Arrays.asList(v1));
		
		//Salvando veiculo
		veiculoRepository.saveAll(Arrays.asList(v1));
	}
}