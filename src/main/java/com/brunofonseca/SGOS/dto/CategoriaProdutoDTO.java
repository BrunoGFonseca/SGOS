package com.brunofonseca.SGOS.dto;

import java.io.Serializable;

import com.brunofonseca.SGOS.domain.CategoriaProduto;

public class CategoriaProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public CategoriaProdutoDTO() {
	}
	
	public CategoriaProdutoDTO(CategoriaProduto obj) {
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
