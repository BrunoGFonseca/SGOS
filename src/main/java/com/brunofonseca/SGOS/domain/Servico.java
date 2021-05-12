package com.brunofonseca.SGOS.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "SERVIO_CATEGORIASERVICO", 
		joinColumns = @JoinColumn(name = "servico_id"), 
		inverseJoinColumns = @JoinColumn(name = "categoriaServico_id")
	)
	private List<CategoriaServico> categoriaServicos = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "id.servico")
	private Set<ServicoOrdem> servicos = new HashSet<>();

	public Servico() {
	}

	public Servico(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	@JsonIgnore
	public List<OrdemServico> getOrdensServicos(){
		List<OrdemServico> listaOrdemS = new ArrayList<>();
		for(ServicoOrdem x : servicos) {
			listaOrdemS.add(x.getOrdemServico());
		}
		return listaOrdemS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<CategoriaServico> getCategoriaServicos() {
		return categoriaServicos;
	}

	public void setCategoriaServicos(List<CategoriaServico> categoriaServicos) {
		this.categoriaServicos = categoriaServicos;
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
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
