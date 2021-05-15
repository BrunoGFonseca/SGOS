package com.brunofonseca.SGOS.dto;

import java.io.Serializable;

import com.brunofonseca.SGOS.domain.CategoriaServico;

public class CategoriaServicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public CategoriaServicoDTO() {
	}
	
	public CategoriaServicoDTO(CategoriaServico obj) {
		id = obj.getId();
		nome = obj.getNome();
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
	
	

}
