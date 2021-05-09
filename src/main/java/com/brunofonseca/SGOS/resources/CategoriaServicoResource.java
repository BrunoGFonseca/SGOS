package com.brunofonseca.SGOS.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categoria_servicos")
public class CategoriaServicoResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "REST está ok para categoria de serviços";
	}

}
