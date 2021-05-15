package com.brunofonseca.SGOS;

import java.text.SimpleDateFormat;
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
import com.brunofonseca.SGOS.domain.ItemOrdem;
import com.brunofonseca.SGOS.domain.OrdemServico;
import com.brunofonseca.SGOS.domain.Pagamento;
import com.brunofonseca.SGOS.domain.PagamentoComBoleto;
import com.brunofonseca.SGOS.domain.PagamentoComCartao;
import com.brunofonseca.SGOS.domain.Produto;
import com.brunofonseca.SGOS.domain.Servico;
import com.brunofonseca.SGOS.domain.ServicoOrdem;
import com.brunofonseca.SGOS.domain.Veiculo;
import com.brunofonseca.SGOS.domain.enums.EstadoPagamento;
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

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemOrdemServicoRepository itemOrdemServicoRepository;

	@Autowired
	private ServicoOrdemServicoRepository servicoOrdemServicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SgosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Instanciando a categoriaProduto e CategoriaServiço
		CategoriaProduto catProd1 = new CategoriaProduto(null, "ProdutoMotor");
		CategoriaProduto catProd2 = new CategoriaProduto(null, "ProdutoSuspensao");

		CategoriaServico catServ1 = new CategoriaServico(null, "ServicoMotor");
		CategoriaServico catServ2 = new CategoriaServico(null, "ServicoSuspensao");

		// Instanciando produtos e servicos
		Produto p1 = new Produto(null, "FiltroOleo", 15.00);
		Produto p2 = new Produto(null, "CorreaDentada", 9.99);
		Produto p3 = new Produto(null, "FiltroAr", 20.00);
		Produto p4 = new Produto(null, "MolaSuspensao", 12.00);
		Produto p5 = new Produto(null, "prod5", 300.00);
		Produto p6 = new Produto(null, "prod6", 50.00);
		Produto p7 = new Produto(null, "prod7", 200.00);
		Produto p8 = new Produto(null, "prod8", 1200.00);
		Produto p9 = new Produto(null, "prod9", 800.00);
		Produto p10 = new Produto(null, "prod10", 100.00);
		Produto p11 = new Produto(null, "prod11", 180.00);
		Produto p12 = new Produto(null, "prod12", 90.00);

		Servico s1 = new Servico(null, "trocaFiltroOleo", 5.00);
		Servico s2 = new Servico(null, "trocaCorreaDentada", 7.00);
		Servico s3 = new Servico(null, "TrocaFiltroAr", 7.50);
		Servico s4 = new Servico(null, "TrocaMolaSuspensao", 5.00);
		Servico s5 = new Servico(null, "serv5", 5.00);
		Servico s6 = new Servico(null, "serv6", 7.00);
		Servico s7 = new Servico(null, "serv7", 7.50);
		Servico s8 = new Servico(null, "serv8", 5.00);
		Servico s9 = new Servico(null, "serv9", 5.00);
		Servico s10 = new Servico(null, "serv10", 7.00);
		Servico s11 = new Servico(null, "serv11", 7.50);
		Servico s12 = new Servico(null, "serv12", 5.00);

		// Vinculando produtos e serviços dentro das categorias

		catProd1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p9, p10, p11));
		catProd2.getProdutos().addAll(Arrays.asList(p4, p5, p6, p7, p8, p12));

		catServ1.getServicos().addAll(Arrays.asList(s1, s2, s3, s9, s10, s11));
		catServ2.getServicos().addAll(Arrays.asList(s4, s5, s6, s7, s8, s12));

		// Vinculado categorias para os produtos e serviços
		p1.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		p2.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		p3.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		p9.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		p10.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		p11.getCategoriaProdutos().addAll(Arrays.asList(catProd1));
		
		p4.getCategoriaProdutos().addAll(Arrays.asList(catProd2));
		p5.getCategoriaProdutos().addAll(Arrays.asList(catProd2));
		p6.getCategoriaProdutos().addAll(Arrays.asList(catProd2));
		p7.getCategoriaProdutos().addAll(Arrays.asList(catProd2));
		p8.getCategoriaProdutos().addAll(Arrays.asList(catProd2));
		p12.getCategoriaProdutos().addAll(Arrays.asList(catProd2));

		s1.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		s2.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		s3.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		s9.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		s10.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		s11.getCategoriaServicos().addAll(Arrays.asList(catServ1));
		
		s4.getCategoriaServicos().addAll(Arrays.asList(catServ2));
		s5.getCategoriaServicos().addAll(Arrays.asList(catServ2));
		s6.getCategoriaServicos().addAll(Arrays.asList(catServ2));
		s7.getCategoriaServicos().addAll(Arrays.asList(catServ2));
		s8.getCategoriaServicos().addAll(Arrays.asList(catServ2));
		s12.getCategoriaServicos().addAll(Arrays.asList(catServ2));

		// Salvando categorias
		categoriaProdutoRepository.saveAll(Arrays.asList(catProd1, catProd2));
		categoriaServicoRepository.saveAll(Arrays.asList(catServ1, catServ2));

		// Salvando produtos e servicos
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));
		servicoRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12));

		// ------------------------------------------------------------------------------------------------

		// Instanciando Estados e cidades
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberaba", est1);
		Cidade c2 = new Cidade(null, "Uberlandia", est1);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		Cidade c4 = new Cidade(null, "Ribeirao Preto", est2);

		// Vinculado cidades nos estados
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3, c4));

		// Salvando Estados e Cidades
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

		// Instanciando Cliente 01, telefone e endereços

		Cliente cli1 = new Cliente(null, "Bruno Gabriel Fonseca", "brunogabrielfonseca@hotmail.com", "39053854819",
				TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("992954181", "992451800"));

		Endereco e1 = new Endereco(null, "Rua Angelo Guido de Gaitani", "221", null, "Manoel Penna", "14098327", cli1,
				c4);

		Endereco e2 = new Endereco(null, "Rua do Carmo", "377", "Ap 107", "Abadia", "38025000 ", cli1, c1);

		// Associando endereços aos clientes
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		// Salvando clientes e enderecos.
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		// Instaciando veiculo
		Veiculo v1 = new Veiculo(null, "Uno", "BHK8177", "1997", cli1);
		Veiculo v2 = new Veiculo(null, "Celta", "DNK2292", "2002", cli1);

		// Associando veiculos ao cliente
		cli1.getVeiculos().addAll(Arrays.asList(v1, v2));

		// Salvando veiculo
		veiculoRepository.saveAll(Arrays.asList(v1, v2));

		// Instanciando ordens de serviço e pagamentos

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		OrdemServico os1 = new OrdemServico(null, sdf.parse("09/05/2021 12:35"), cli1, v1);
		OrdemServico os2 = new OrdemServico(null, sdf.parse("07/05/2021 10:15"), cli1, v2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, os1, 6);
		os1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, os2, sdf.parse("20/05/2021 00:00"),
				null);
		os2.setPagamento(pagto2);

		cli1.getOrdensServicos().addAll(Arrays.asList(os1, os2));

		ordemServicoRepository.saveAll(Arrays.asList(os1, os2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		// Instanciando itensOrdens e serviçosOrdens

		ItemOrdem io1 = new ItemOrdem(os1, p1, 0.00, 1, 15.00);
		ItemOrdem io2 = new ItemOrdem(os2, p2, 0.00, 1, 9.99);
		ItemOrdem io3 = new ItemOrdem(os2, p3, 0.00, 1, 20.00);
		ItemOrdem io4 = new ItemOrdem(os2, p4, 0.00, 1, 12.00);

		ServicoOrdem so1 = new ServicoOrdem(os1, s1, 0.00, 1, 5.00);
		ServicoOrdem so2 = new ServicoOrdem(os2, s2, 0.00, 1, 7.00);
		ServicoOrdem so3 = new ServicoOrdem(os2, s3, 0.00, 1, 7.50);
		ServicoOrdem so4 = new ServicoOrdem(os2, s4, 0.00, 1, 5.00);

		os1.getItens().addAll(Arrays.asList(io1));
		os1.getServicos().addAll(Arrays.asList(so1));

		os2.getItens().addAll(Arrays.asList(io2, io3, io4));
		os2.getServicos().addAll(Arrays.asList(so2, so3, so4));

		p1.getItens().addAll(Arrays.asList(io1));
		p2.getItens().addAll(Arrays.asList(io2));
		p3.getItens().addAll(Arrays.asList(io3));
		p4.getItens().addAll(Arrays.asList(io4));

		s1.getServicos().addAll(Arrays.asList(so1));
		s2.getServicos().addAll(Arrays.asList(so2));
		s3.getServicos().addAll(Arrays.asList(so3));
		s4.getServicos().addAll(Arrays.asList(so4));

		itemOrdemServicoRepository.saveAll(Arrays.asList(io1, io2, io3, io4));
		servicoOrdemServicoRepository.saveAll(Arrays.asList(so1, so2, so3, so4));

	}
}