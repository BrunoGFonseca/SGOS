package com.brunofonseca.SGOS.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.services.CategoriaServicoService;

@RestController
@RequestMapping(value="/categoria_servicos")
public class CategoriaServicoResource {
	
	@Autowired
	private CategoriaServicoService catServService;
	
	//Buscando uma categoria
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoriaServico> find(@PathVariable Integer id) {
		
		CategoriaServico obj = catServService.find(id);
		return ResponseEntity.ok(obj);
	}
	
	//Criando uma categoria
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CategoriaServico obj){
		obj = catServService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Atualizando uma categoria
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody CategoriaServico obj, @PathVariable Integer id){
		obj.setId(id);
		obj = catServService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	//Deletando uma categoria
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		catServService.delete(id);
		return ResponseEntity.noContent().build();
	}
}