package com.dh.ecommerce.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotBlank

    @Size(min = 5, max = 15,message = "Campo fora dos parametros")
    //Validações do banco
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
