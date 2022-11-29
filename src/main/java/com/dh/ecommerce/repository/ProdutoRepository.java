package com.dh.ecommerce.repository;

import com.dh.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findBySku(String sku);

    Optional<Produto> findBySkuAndNome(String sku, String nome);

    @Query("SELECT p FROM Produto p WHERE p.sku = :sku and p.nome = :nome")
    Optional<Produto> buscaPorSkuAndNome(@Param("sku") String sku, @Param("nome") String nome);
    List<Produto> findBySkuOrNome(String sku, String nome);
}
