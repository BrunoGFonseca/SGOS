package com.brunofonseca.SGOS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunofonseca.SGOS.domain.CategoriaServico;

@Repository
public interface CategoriaServicoRepository extends JpaRepository<CategoriaServico, Integer> {

}
