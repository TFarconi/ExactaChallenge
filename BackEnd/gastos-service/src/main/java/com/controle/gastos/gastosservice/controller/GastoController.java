package com.controle.gastos.gastosservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.gastos.gastosservice.model.Gasto;
import com.controle.gastos.gastosservice.service.GastoService;

@RestController
@RequestMapping("/gastos")
public class GastoController {
	// Controller responsável pela comunicação com a aplicação que irá consumir os dados da aplicação.
	
	@Autowired
	private GastoService gastoService;
	
	@GetMapping(path = "/buscarTodos")
	public Iterable<Gasto> buscarTodos() {
		return gastoService.recuperaGastos();
	}
	
	@PostMapping(path = "/salvar")
	public Gasto save(@RequestBody Gasto gasto) {
		return gastoService.salvar(gasto);
	}
	
	@GetMapping(path = "/buscarPorId/{id}")
	public Gasto buscarPorId(@PathVariable("id") Long id) {
		return gastoService.buscarPorId(id);
	}
	
	@DeleteMapping(path = "/excluirPorId/{id}")
	public void excluirPorId(@PathVariable("id") Long id) {
		gastoService.excluirPorId(id);
	}
	

}
