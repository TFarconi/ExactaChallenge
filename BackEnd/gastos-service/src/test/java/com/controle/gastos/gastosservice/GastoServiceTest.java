package com.controle.gastos.gastosservice;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.controle.gastos.gastosservice.model.Gasto;
import com.controle.gastos.gastosservice.repository.GastoRepository;
import com.controle.gastos.gastosservice.service.GastoService;

@RunWith(value = MockitoJUnitRunner.class)
public class GastoServiceTest extends GastoService {
	// Classe de testes, focada em validar a parte lógica do projeto, centralizada na camada de Service
	
	@Mock
	private GastoRepository gastoRepository;
	
	@Before
	public void init() {
		setGastoRepository(gastoRepository);
	}
	
	@Test
	public void validarRecuperarTodosGastos() {
		Gasto gastoMock = Mockito.mock(Gasto.class);
		
		Mockito.when(gastoRepository.findAll()).thenReturn(Collections.singletonList(gastoMock));
		
		List<Gasto> gastos = (List<Gasto>) recuperaGastos();
		Assert.assertFalse(gastos.isEmpty());
	}
	
	@Test
	public void validarSalvarGastos() {
		Gasto gastoMock = Mockito.mock(Gasto.class);
		
		Mockito.when(gastoRepository.save(gastoMock)).thenReturn(gastoMock);
		
		Gasto gastoReturn = salvar(gastoMock);
		Assert.assertEquals(gastoMock, gastoReturn);
	}
	
	@Test
	public void validarRecuperarGastoPorId() {
		Gasto gastoMock = Mockito.mock(Gasto.class);
		
		Mockito.when(gastoMock.getId()).thenReturn(1L);
		Mockito.when(gastoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(gastoMock));
		
		Gasto gastoReturn = buscarPorId(1L);
		Assert.assertTrue(Objects.nonNull(gastoReturn.getId()));
	}
	
	@Test
	public void validarExcluirGastoPorId() {
		Mockito.doNothing().when(gastoRepository).deleteById(Mockito.anyLong());
		
		excluirPorId(1L);
	}

}
