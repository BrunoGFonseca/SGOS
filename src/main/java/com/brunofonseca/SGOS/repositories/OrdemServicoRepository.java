package com.brunofonseca.SGOS.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brunofonseca.SGOS.domain.Cliente;
import com.brunofonseca.SGOS.domain.OrdemServico;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {
	
	@Transactional(readOnly=true)
	Page<OrdemServico> findByCliente(Cliente cliente, Pageable pageRequest);
}