package com.dh.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String sku;
    @Column(nullable = false,length = 100)
    private String nome;
    private Timestamp dataHoraCadastro;
    private Double valor;
    private String lote;
    private String categoria;
    private String fornecedor;
}
