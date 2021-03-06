package com.brunofonseca.SGOS.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ServicoOrdem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ServicoOrdemPK id = new ServicoOrdemPK();
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	public ServicoOrdem() {
	}

	public ServicoOrdem(OrdemServico ordemServico, Servico servico, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setOrdemServico(ordemServico);
		id.setServico(servico);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public double getSubTotal() {
		return ((preco - desconto) * quantidade);
	}
	
	@JsonIgnore
	public OrdemServico getOrdemServico() {
		return id.getOrdemServico();
	}
	
	public void setOrdemServico(OrdemServico ordemServico) {
		id.setOrdemServico(ordemServico);
	}
	
	public Servico getServico() {
		return id.getServico();
	}
	
	public void setServico(Servico servico) {
		id.setServico(servico);
	}
	
	public ServicoOrdemPK getId() {
		return id;
	}

	public void setId(ServicoOrdemPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicoOrdem other = (ServicoOrdem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

		StringBuilder builder = new StringBuilder();
		builder.append(getServico().getNome());
		builder.append(", Qte: ");
		builder.append(getQuantidade());
		builder.append(", Preco Unit??rio: ");
		builder.append(nf.format(getPreco()));
		builder.append(", Subtotal: ");
		builder.append(nf.format(getSubTotal()));
		builder.append("\n");
		return builder.toString();
	}	
	
	
	
}