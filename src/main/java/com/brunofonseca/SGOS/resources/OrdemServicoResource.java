package com.brunofonseca.SGOS.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunofonseca.SGOS.domain.OrdemServico;
import com.brunofonseca.SGOS.services.OrdemServicoService;

@RestController
@RequestMapping(value = "/ordens")

public class OrdemServicoResource {

	@Autowired
	private OrdemServicoService ordemServicoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<OrdemServico> find(@PathVariable Integer id) {

		OrdemServico obj = ordemServicoService.find(id);
		return ResponseEntity.ok(obj);
	}
}