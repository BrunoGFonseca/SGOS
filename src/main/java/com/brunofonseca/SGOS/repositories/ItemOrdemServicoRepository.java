package com.brunofonseca.SGOS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunofonseca.SGOS.domain.ItemOrdem;

@Repository
public interface ItemOrdemServicoRepository extends JpaRepository<ItemOrdem, Integer> {

}
