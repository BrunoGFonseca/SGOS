package com.brunofonseca.SGOS.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.OrdemServico;
import com.brunofonseca.SGOS.repositories.OrdemServicoRepository;
import com.brunofonseca.SGOS.services.exceptions.ObjectNotFoundException;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	public OrdemServico find(Integer id) {
		Optional<OrdemServico> obj = ordemServicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + OrdemServico.class.getName()));
	}
}