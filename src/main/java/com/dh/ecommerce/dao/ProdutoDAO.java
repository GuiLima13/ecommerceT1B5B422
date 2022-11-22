package com.dh.ecommerce.dao;

import com.dh.ecommerce.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProdutoDAO {

    public static List<Produto> listProduto =  new ArrayList<>();

    public List<Produto> buscar(){
        return listProduto;
    }

    public Produto salvar(Produto produto){
        listProduto.add(produto);
        return produto;
    }
}
