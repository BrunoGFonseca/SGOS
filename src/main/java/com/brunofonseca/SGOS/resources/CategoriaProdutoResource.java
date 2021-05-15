package com.brunofonseca.SGOS.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunofonseca.SGOS.domain.CategoriaProduto;
import com.brunofonseca.SGOS.dto.CategoriaProdutoDTO;
import com.brunofonseca.SGOS.services.CategoriaProdutoService;

@RestController
@RequestMapping(value = "/categoria_produtos")
public class CategoriaProdutoResource {

	@Autowired
	private CategoriaProdutoService catProdService;

	//Buscando uma categoria
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoriaProduto> find(@PathVariable Integer id) {

		CategoriaProduto obj = catProdService.find(id);
		return ResponseEntity.ok(obj);
	}
	
	//Buscando lista de categorias
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaProdutoDTO>> findAll() {
		List<CategoriaProduto> listaCatProd = catProdService.findAll();
		List<CategoriaProdutoDTO> listaCatProdDTO = listaCatProd.stream().map(obj -> new CategoriaProdutoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listaCatProdDTO);
	}
	
	//Busca paginada
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaProdutoDTO>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24")  Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "nome")  String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")  String direction) {
		Page<CategoriaProduto> listaCatProd = catProdService.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaProdutoDTO> listaCatProdDTO = listaCatProd.map(obj -> new CategoriaProdutoDTO(obj));
		return ResponseEntity.ok().body(listaCatProdDTO);
	}
	
	//Criando uma categoria
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CategoriaProduto obj){
		obj = catProdService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Atualizando uma categoria
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody CategoriaProduto obj, @PathVariable Integer id){
		obj.setId(id);
		obj = catProdService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	//Deletando uma categoria
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		catProdService.delete(id);
		return ResponseEntity.noContent().build();
	}
}