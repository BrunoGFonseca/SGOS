package com.brunofonseca.SGOS.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunofonseca.SGOS.domain.CategoriaServico;
import com.brunofonseca.SGOS.dto.CategoriaServicoDTO;
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
	
	//Buscando lista de categorias
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaServicoDTO>> findAll() {
		List<CategoriaServico> listaCatServ = catServService.findAll();
		List<CategoriaServicoDTO> listaCatServDTO = listaCatServ.stream().map(obj -> new CategoriaServicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listaCatServDTO);
	}
	
	//Busca paginada
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaServicoDTO>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC") String direction) {
		Page<CategoriaServico> listaServProd = catServService.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaServicoDTO> listaServProdDTO = listaServProd.map(obj -> new CategoriaServicoDTO(obj));
		return ResponseEntity.ok().body(listaServProdDTO);
	}
	
	//Criando uma categoria
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaServicoDTO objDTO){
		CategoriaServico obj = catServService.fromDTO(objDTO);
		obj = catServService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Atualizando uma categoria
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaServicoDTO objDTO, @PathVariable Integer id){
		CategoriaServico obj = catServService.fromDTO(objDTO);
		obj.setId(id);
		obj = catServService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	//Deletando uma categoria
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		catServService.delete(id);
		return ResponseEntity.noContent().build();
	}
}