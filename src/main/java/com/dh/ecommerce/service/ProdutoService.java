package com.dh.ecommerce.service;

import com.dh.ecommerce.dao.ProdutoDAO;
import com.dh.ecommerce.model.Produto;

import java.util.List;

public class ProdutoService {

    ProdutoDAO produtoDAO = new ProdutoDAO();
    public List<Produto> buscar(){
        return produtoDAO.buscar();
    }

    public Produto salvar(Produto produto){
        return produtoDAO.salvar(produto);
    }
}
