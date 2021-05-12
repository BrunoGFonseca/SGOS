package com.brunofonseca.SGOS.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ServicoOrdemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="ordemServico_id")
	private OrdemServico ordemServico;
	
	@ManyToOne
	@JoinColumn(name="servico_id")
	private Servico servico;
	
	public OrdemServico getOrdemServico() {
		return ordemServico;
	}
	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordemServico == null) ? 0 : ordemServico.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
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
		ServicoOrdemPK other = (ServicoOrdemPK) obj;
		if (ordemServico == null) {
			if (other.ordemServico != null)
				return false;
		} else if (!ordemServico.equals(other.ordemServico))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		return true;
	}
}