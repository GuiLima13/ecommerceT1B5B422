package com.dh.ecommerce.service;

import com.dh.ecommerce.entity.Produto;
import com.dh.ecommerce.entity.dto.ProdutoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoServiceTest {

    @Autowired
    ProdutoService service;
    ObjectMapper mapper = new ObjectMapper();

    @Test
    void salvar(){
        Produto produto = new Produto();
        produto.setCategoria("Vestuario");
        produto.setNome("Meia");
        produto.setFornecedor("Brás");
        produto.setLote("988-DFFF");
        produto.setValor(30.90);
        produto.setSku(Math.ceil(Math.random()*10000)+"");
        Produto produtoSalvo = service.salvar(produto);

        Assertions.assertNotNull(produtoSalvo.getId());
    }

    @Test
    void alteracaoParcial(){

        //Criando produto
        Produto produto = new Produto();
        produto.setCategoria("Vestuario");
        produto.setNome("Meia");
        produto.setFornecedor("Brás");
        produto.setLote("988-DFFF");
        produto.setValor(30.90);

        produto.setSku(Math.ceil(Math.random()*10000)+"");
        //Salvando produto no banco

        service.salvar(produto);

        //Alterando nome do produto
        String nomeProduto = produto.getNome();
        produto.setNome("Bermuda");


        //Convertendo produto para produtoDTO
        ProdutoDTO produtoSalvoDTO = mapper.convertValue(produto,ProdutoDTO.class);

        //Salvando a alteração do produto
        ProdutoDTO produtoDTOAlterado = service.alteracaoParcial(produtoSalvoDTO);

        System.out.println();
        //Validando a alterção do produto
        Assertions.assertFalse(produtoDTOAlterado.getNome().equals(nomeProduto));

    }
}
