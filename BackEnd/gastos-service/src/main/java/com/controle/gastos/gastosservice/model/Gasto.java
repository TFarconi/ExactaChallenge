package com.controle.gastos.gastosservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TB_GASTO", schema = "GASTO")
public class Gasto implements Serializable {

	private static final long serialVersionUID = 5381487124588329936L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GASTO")
	private Long id;
	
	@Column(name = "NM_PESSOA")
	private String nomePessoa;
	
	@Column(name = "DS_GASTO")
	private String descricao;
	
	@Column(name = "DT_DATA_HORA")
	private LocalDateTime dataHora;
	
	@Column(name = "VR_GASTO")
	private BigDecimal valor;
	
	@Column(name = "DS_TAG")
	private String tag;

}
