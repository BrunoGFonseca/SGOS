package com.brunofonseca.SGOS.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunofonseca.SGOS.domain.CategoriaServico;

@RestController
@RequestMapping(value="/categoria_servicos")
public class CategoriaServicoResource {
		
	@RequestMapping(method = RequestMethod.GET)
	public List<CategoriaServico> listar() {

		CategoriaServico catServ1 = new CategoriaServico(1, "ServicoMotor");
		
		List<CategoriaServico> listaCatServicos = new ArrayList<>();
		listaCatServicos.add(catServ1);
		
		return listaCatServicos;
	}
}