package com.brunofonseca.SGOS.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.ItemOrdem;
import com.brunofonseca.SGOS.domain.OrdemServico;
import com.brunofonseca.SGOS.domain.PagamentoComBoleto;
import com.brunofonseca.SGOS.domain.ServicoOrdem;
import com.brunofonseca.SGOS.domain.enums.EstadoPagamento;
import com.brunofonseca.SGOS.repositories.ItemOrdemServicoRepository;
import com.brunofonseca.SGOS.repositories.OrdemServicoRepository;
import com.brunofonseca.SGOS.repositories.PagamentoRepository;
import com.brunofonseca.SGOS.repositories.ServicoOrdemServicoRepository;
import com.brunofonseca.SGOS.services.exceptions.ObjectNotFoundException;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private ItemOrdemServicoRepository itemOrdemServicoRepository;
	
	@Autowired
	private ServicoOrdemServicoRepository servicoOrdemServicoRepository;

	public OrdemServico find(Integer id) {
		Optional<OrdemServico> obj = ordemServicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + OrdemServico.class.getName()));
	}
	
	public OrdemServico insert(OrdemServico obj) {
		//Fazer validação se o usuário é ADM
		
		obj.setId(null);
		obj.setData(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setOrdemServico(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getData());
		}
		obj = ordemServicoRepository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for(ItemOrdem io : obj.getItens()) {
			io.setDesconto(0.0);
			io.setPreco(produtoService.find(io.getProduto().getId()).getPreco());
			io.setOrdemServico(obj);
		}
		
		for(ServicoOrdem so : obj.getServicos()) {
			so.setDesconto(0.0);
			so.setPreco(servicoService.find(so.getServico().getId()).getPreco());
			so.setOrdemServico(obj);
		}
		
		itemOrdemServicoRepository.saveAll(obj.getItens());
		servicoOrdemServicoRepository.saveAll(obj.getServicos());
		
		return obj;
	}
}