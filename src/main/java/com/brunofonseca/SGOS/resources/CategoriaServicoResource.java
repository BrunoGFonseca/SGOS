package com.brunofonseca.SGOS.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.services.CategoriaServicoService;

@RestController
@RequestMapping(value="/categoria_servicos")
public class CategoriaServicoResource {
	
	@Autowired
	private CategoriaServicoService catServService;
		
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		CategoriaServico obj = catServService.find(id);
		return ResponseEntity.ok(obj);
	}
}