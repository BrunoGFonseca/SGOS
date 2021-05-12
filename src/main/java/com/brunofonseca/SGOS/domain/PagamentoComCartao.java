package com.brunofonseca.SGOS.domain;

import javax.persistence.Entity;

import com.brunofonseca.SGOS.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer nroParcelas;
	
	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, OrdemServico ordemServico, Integer nroParcelas) {
		super(id, estado, ordemServico);
		this.nroParcelas = nroParcelas;
	}

	public Integer getNroParcelas() {
		return nroParcelas;
	}

	public void setNroParcelas(Integer nroParcelas) {
		this.nroParcelas = nroParcelas;
	}
}