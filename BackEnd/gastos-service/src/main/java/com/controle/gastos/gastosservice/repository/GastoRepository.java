package com.controle.gastos.gastosservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.controle.gastos.gastosservice.model.Gasto;

public interface GastoRepository extends CrudRepository<Gasto, Long> {
	// Camada Repository, responsável pela comunicação com o banco de dados.
}
