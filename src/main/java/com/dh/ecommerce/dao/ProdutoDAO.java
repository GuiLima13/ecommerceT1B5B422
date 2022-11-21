package com.dh.ecommerce.dao;

import com.dh.ecommerce.model.Produto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
