package com.brunofonseca.SGOS.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Servico obj INNER JOIN obj.categoriaServicos cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Servico> search(@Param("nome") String nome, @Param("categorias") List<CategoriaServico> categorias, Pageable pageResquest);
}