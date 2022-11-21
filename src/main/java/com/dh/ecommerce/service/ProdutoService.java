package com.dh.ecommerce.service;

import com.dh.ecommerce.dao.ProdutoDAO;
import com.dh.ecommerce.model.Produto;
import com.dh.ecommerce.model.dto.ProdutoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    ProdutoDAO produtoDAO = new ProdutoDAO();
    public List<ProdutoDTO> buscar(){
        List<Produto> listProduto = produtoDAO.buscar();
        List<ProdutoDTO> listProdutoDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Produto produto : listProduto) {
            ProdutoDTO produtoDTO = mapper.convertValue(produto, ProdutoDTO.class);
            System.out.println(produtoDTO.getCategoria());
            listProdutoDTO.add(produtoDTO);
        }
        return listProdutoDTO;
    }

    public ResponseEntity salvar(Produto produto){
        try{
            Produto produtoSalvo = produtoDAO.salvar(produto);
           return new ResponseEntity( "Produto "+produtoSalvo.getNome()+" criado com sucesso", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity("Erro ao cadastrar produto", HttpStatus.BAD_REQUEST);
        }
    }
}
