package com.controle.gastos.gastosservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.gastos.gastosservice.model.Gasto;
import com.controle.gastos.gastosservice.repository.GastoRepository;

import lombok.Setter;

@Service
@Setter
public class GastoService {
	// Camada service, responsável pelo tratamento de regras negociais do projeto.

	@Autowired
	private GastoRepository gastoRepository;

	public Iterable<Gasto> recuperaGastos() {
		return gastoRepository.findAll();
	}

	public Gasto salvar(Gasto gasto) {
		return gastoRepository.save(gasto);
	}

	public Gasto buscarPorId(Long id) {
		return gastoRepository.findById(id).orElse(new Gasto());
	}
	
	public void excluirPorId(Long id) {
		gastoRepository.deleteById(id);
	}

}
