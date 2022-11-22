package com.dh.ecommerce.model;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private Long id;
    private String nome;
    private Timestamp dataHoraCadastro;
    private Double valor;
    private String lote;
    private String categoria;
    private String fornecedor;
}
