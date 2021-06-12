package com.brunofonseca.SGOS.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.CategoriaProduto;
import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.domain.Cidade;
import com.brunofonseca.SGOS.domain.Cliente;
import com.brunofonseca.SGOS.domain.Endereco;
import com.brunofonseca.SGOS.domain.Estado;
import com.brunofonseca.SGOS.domain.Produto;
import com.brunofonseca.SGOS.domain.Servico;
import com.brunofonseca.SGOS.domain.Veiculo;
import com.brunofonseca.SGOS.domain.enums.Perfil;
import com.brunofonseca.SGOS.domain.enums.TipoCliente;
import com.brunofonseca.SGOS.repositories.CategoriaProdutoRepository;
import com.brunofonseca.SGOS.repositories.CategoriaServicoRepository;
import com.brunofonseca.SGOS.repositories.CidadeRepository;
import com.brunofonseca.SGOS.repositories.ClienteRepository;
import com.brunofonseca.SGOS.repositories.EnderecoRepository;
import com.brunofonseca.SGOS.repositories.EstadoRepository;
import com.brunofonseca.SGOS.repositories.ItemOrdemServicoRepository;
import com.brunofonseca.SGOS.repositories.OrdemServicoRepository;
import com.brunofonseca.SGOS.repositories.PagamentoRepository;
import com.brunofonseca.SGOS.repositories.ProdutoRepository;
import com.brunofonseca.SGOS.repositories.ServicoOrdemServicoRepository;
import com.brunofonseca.SGOS.repositories.ServicoRepository;
import com.brunofonseca.SGOS.repositories.VeiculoRepository;

@Service
public class DBService {

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

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemOrdemServicoRepository itemOrdemServicoRepository;

	@Autowired
	private ServicoOrdemServicoRepository servicoOrdemServicoRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void instantiateTestDatabase() throws ParseException {

		// Instanciando a categoriaProduto e CategoriaServiço
		CategoriaProduto catProd1 = new CategoriaProduto(null, "Produtos de Motor");
		CategoriaProduto catProd2 = new CategoriaProduto(null, "Produtos de Suspensao");

		CategoriaServico catServ1 = new CategoriaServico(null, "Servicos de Motor");
		CategoriaServico catServ2 = new CategoriaServico(null, "Servicos de Suspensao");

		// Instanciando produtos e servicos
		Produto p1 = new Produto(null, "Filtro de Oleo", 15.00);
		Produto p2 = new Produto(null, "Correa Dentada", 9.99);
		Produto p3 = new Produto(null, "Filtro de Ar", 20.00);
		Produto p4 = new Produto(null, "Mola de Suspensao", 12.00);

		Servico s1 = new Servico(null, "troca Filtro de Oleo", 5.00);
		Servico s2 = new Servico(null, "troca Correa Dentada", 7.00);
		Servico s3 = new Servico(null, "Troca Filtro de Ar", 7.50);
		Servico s4 = new Servico(null, "Troca Mola Suspensao", 5.00);

		// Vinculando produtos e serviços dentro das categorias

		catProd1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		catProd2.getProdutos().addAll(Arrays.asList(p4));

		catServ1.getServicos().addAll(Arrays.asList(s1, s2, s3));
		catServ2.getServicos().addAll(Arrays.asList(s4));

		// Vinculado categorias para os produtos e serviços
		p1.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		p2.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		p3.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		p4.getCategoriaProdutos().addAll(Arrays.asList(catProd2));
		
		s1.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		s2.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		s3.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		s4.getCategoriaServicos().addAll(Arrays.asList(catServ2));

		// Salvando categorias
		categoriaProdutoRepository.saveAll(Arrays.asList(catProd1, catProd2));
		categoriaServicoRepository.saveAll(Arrays.asList(catServ1, catServ2));

		// Salvando produtos e servicos
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		servicoRepository.saveAll(Arrays.asList(s1, s2, s3, s4));

		// ------------------------------------------------------------------------------------------------

		// Instanciando Estados e cidades
		Estado est1 = new Estado(null, "Acre");
		Estado est2 = new Estado(null, "Alagoas");
		Estado est3 = new Estado(null, "Amapá");
		Estado est4 = new Estado(null, "Amazonas");
		Estado est5 = new Estado(null, "Bahia");
		Estado est6 = new Estado(null, "Brasília");
		Estado est7 = new Estado(null, "Ceará");
		Estado est8 = new Estado(null, "Espírito Santo");
		Estado est9 = new Estado(null, "Goiás");
		Estado est10 = new Estado(null, "Maranhão");
		Estado est11 = new Estado(null, "Mato Grosso");
		Estado est12 = new Estado(null, "Mato Grosso do Sul");
		Estado est13 = new Estado(null, "Minas Gerais");
		Estado est14 = new Estado(null, "Pará");
		Estado est15 = new Estado(null, "Paraíba");
		Estado est16 = new Estado(null, "Paraná");
		Estado est17 = new Estado(null, "Pernambuco");
		Estado est18 = new Estado(null, "Piauí");
		Estado est19 = new Estado(null, "Rio de Janeiro");
		Estado est20 = new Estado(null, "Rio Grande do Norte");
		Estado est21 = new Estado(null, "Rio Grande do Sul");
		Estado est22 = new Estado(null, "Rondônia");
		Estado est23 = new Estado(null, "Roraima");
		Estado est24 = new Estado(null, "Santa Catarina");
		Estado est25 = new Estado(null, "São Paulo");
		Estado est26 = new Estado(null, "Sergipe");
		Estado est27 = new Estado(null, "Tocantins");
		
		Cidade c1 = new Cidade(null, "Uberaba", est13);
		Cidade c2 = new Cidade(null, "Uberlandia", est13);
		Cidade c3 = new Cidade(null, "São Paulo", est25);
		Cidade c4 = new Cidade(null, "Ribeirao Preto", est25);

		// Vinculado cidades nos estados
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3, c4));

		// Salvando Estados e Cidades
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7, est8, est9, est10, est11, est12, est13, est14, est15, est16, est17, est18, est19, est20, est21, est22, est23, est24, est25, est26, est27));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		// Instanciando Cliente 01, telefone e endereços

		Cliente cli1 = new Cliente(null, // Id
				"Administrador", // Nome
				"adm@hotmail.com", // E-mail
				"39053854819", // CPF
				TipoCliente.PESSOAFISICA, // Tipo
				bCryptPasswordEncoder.encode("123")); // Senha
		cli1.getTelefones().addAll(Arrays.asList("992954181", "992451800"));
		cli1.addPerfil(Perfil.ADMIN);

		Endereco e1 = new Endereco(null, // Id
				"Rua Angelo Guido de Gaitani", // Rua
				"221", // Numero
				null, // Complemento
				"Manoel Penna", // Bairro
				"14098327", // CEP
				cli1, // Cliente
				c4);// Cidade

		Endereco e2 = new Endereco(null, // Id
				"Rua do Carmo", // Rua
				"377", // Numero
				"Ap 107", // Complemento
				"Abadia", // Bairro
				"38025000 ", // CEP
				cli1, // Cliente
				c1);// Cidade

		// Associando endereços aos clientes
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli1.getEnderecos().addAll(Arrays.asList(e2));

		// Salvando clientes e enderecos.
		clienteRepository.saveAll(Arrays.asList(cli1, cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		// Instaciando veiculo
		Veiculo v1 = new Veiculo(null, "Uno", "BHK8177", "1997", cli1);
		Veiculo v2 = new Veiculo(null, "Celta", "DNK2292", "2002", cli1);

		// Associando veiculos ao cliente
		cli1.getVeiculos().addAll(Arrays.asList(v1));
		cli1.getVeiculos().addAll(Arrays.asList(v2));

		// Salvando veiculo
		veiculoRepository.saveAll(Arrays.asList(v1, v2));
		
	}
}