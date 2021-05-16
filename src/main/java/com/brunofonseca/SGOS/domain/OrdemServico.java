package com.brunofonseca.SGOS.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class OrdemServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "ordemServico")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="veiculo_id")
	private Veiculo veiculo;
	
	@OneToMany(mappedBy = "id.ordemServico")
	private Set<ItemOrdem> itens = new HashSet<>();
	
	@OneToMany(mappedBy = "id.ordemServico")
	private Set<ServicoOrdem> servicos = new HashSet<>();
	
	public OrdemServico() {
	}

	public OrdemServico(Integer id, Date data, Cliente cliente, Veiculo veiculo) {
		super();
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.veiculo = veiculo;
	}
	
	public double getValorTotal() {
		double soma = 0.0;
		
		for(ItemOrdem io : itens) {
			soma = soma + io.getSubTotal();
		}
		
		for(ServicoOrdem so : servicos) {
			soma = soma + so.getSubTotal();
		}
		
		return soma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Set<ItemOrdem> getItens() {
		return itens;
	}

	public void setItens(Set<ItemOrdem> itens) {
		this.itens = itens;
	}
	
	public Set<ServicoOrdem> getServicos() {
		return servicos;
	}

	public void setServicos(Set<ServicoOrdem> servicos) {
		this.servicos = servicos;
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
		OrdemServico other = (OrdemServico) obj;
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		
		StringBuilder builder = new StringBuilder();
		builder.append("Ordem de Servico: ");
		builder.append(getId());
		builder.append(", Data: ");
		builder.append(sdf.format(getData()));
		builder.append(", Cliente: ");
		builder.append(getCliente().getNome());
		builder.append(", Situacao do pagamento: ");
		builder.append(getPagamento().getEstado().getDescricao());
		//builder.append(", Veiculo: ");
		//builder.append(getVeiculo().getModelo());
		builder.append("\nDetalhes:\n");
		
		for(ItemOrdem io : getItens()) {
			builder.append(io.toString());
		}
		
		for(ServicoOrdem so : getServicos()) {
			builder.append(so.toString());
		}
		
		builder.append("Valor Total: ");
		builder.append(nf.format(getValorTotal()));

		return builder.toString();
	}
	
	
}