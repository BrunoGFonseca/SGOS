package com.brunofonseca.SGOS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunofonseca.SGOS.domain.ServicoOrdem;

@Repository
public interface ServicoOrdemServicoRepository extends JpaRepository<ServicoOrdem, Integer> {

}
