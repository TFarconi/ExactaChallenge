CREATE DATABASE DBGASTOS;

CREATE TABLE DBGASTOS.TB_GASTO
(
	ID_GASTO INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'Sequencial de identificação do registro.',
    NM_PESSOA VARCHAR(30) NOT NULL COMMENT 'Nome da pessoa referente ao gasto.',
    DS_GASTO VARCHAR(200) NOT NULL COMMENT 'Descrição do gasto',
    DT_DATA_HORA TIMESTAMP NOT NULL COMMENT 'Data/Hora em que o gasto foi realizado',
    VR_GASTO DECIMAL(15,2) NOT NULL COMMENT 'Valor do gasto',
    DS_TAG VARCHAR(20) NOT NULL COMMENT 'Tag de identificação do gasto'
);