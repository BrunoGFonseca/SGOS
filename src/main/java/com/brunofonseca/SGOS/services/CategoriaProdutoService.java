package com.brunofonseca.SGOS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.CategoriaProduto;
import com.brunofonseca.SGOS.dto.CategoriaProdutoDTO;
import com.brunofonseca.SGOS.repositories.CategoriaProdutoRepository;
import com.brunofonseca.SGOS.services.exceptions.DataIntegrityException;
import com.brunofonseca.SGOS.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaProdutoService {

	@Autowired
	private CategoriaProdutoRepository repoCatProd;

	public CategoriaProduto find(Integer id) {
		Optional<CategoriaProduto> obj = repoCatProd.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + CategoriaProduto.class.getName()));
	}
	
	public List<CategoriaProduto> findAll(){
		return repoCatProd.findAll();
	}
	
	public Page<CategoriaProduto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageResquest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repoCatProd.findAll(pageResquest);
	}
	
	public CategoriaProduto insert(CategoriaProduto obj) {
		obj.setId(null);
		return repoCatProd.save(obj);
	}
	
	public CategoriaProduto update(CategoriaProduto obj) {
		CategoriaProduto newObj = find(obj.getId());
		updateData(newObj, obj);
		return repoCatProd.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repoCatProd.deleteById(id);
		}
		catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir uma categoria de produto que tenha produtos associados.");
		}
	}
	
	public CategoriaProduto fromDTO(CategoriaProdutoDTO objDTO) {
		return new CategoriaProduto(objDTO.getId(), objDTO.getNome());
	}
	
	private void updateData(CategoriaProduto newObj, CategoriaProduto obj) {
		newObj.setNome(obj.getNome());
	}
}