package com.dh.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;
    private Timestamp dataEntrega;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id_teste")
    private Endereco endereco;

    @ManyToMany
    private List<Produto> produto;
}
