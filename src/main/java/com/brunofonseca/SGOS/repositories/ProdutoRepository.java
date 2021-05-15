package com.brunofonseca.SGOS.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brunofonseca.SGOS.domain.CategoriaProduto;
import com.brunofonseca.SGOS.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categoriaProdutos cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<CategoriaProduto> categorias, Pageable pageResquest);
}