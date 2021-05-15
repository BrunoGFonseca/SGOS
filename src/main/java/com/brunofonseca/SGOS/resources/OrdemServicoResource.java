package com.brunofonseca.SGOS.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	//Inserindo uma ordem de servico
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody OrdemServico obj){
		obj = ordemServicoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
}