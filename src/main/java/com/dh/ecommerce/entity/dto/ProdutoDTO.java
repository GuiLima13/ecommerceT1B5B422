package com.dh.ecommerce.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoDTO {
    private String nome;
    private Double valor;
    private Timestamp dataHoraCadastro;
    private LocalDate dataCadastro;
    private LocalTime horaCadastro;
    private String lote;

    private String categoria;
    private String fornecedor;

    public LocalDate getDataCadastro() {
        return dataHoraCadastro.toLocalDateTime().toLocalDate();
    }

    public LocalTime getHoraCadastro() {
        return dataHoraCadastro.toLocalDateTime().toLocalTime();
    }
}
