package com.brunofonseca.SGOS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunofonseca.SGOS.domain.CategoriaProduto;

@Repository
public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Integer> {

}
