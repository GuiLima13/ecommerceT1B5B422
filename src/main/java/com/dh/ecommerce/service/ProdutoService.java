package com.dh.ecommerce.service;

import com.dh.ecommerce.dao.ProdutoDAO;
import com.dh.ecommerce.model.Produto;
import com.dh.ecommerce.model.dto.ProdutoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
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
            listProdutoDTO.add(produtoDTO);
        }
        return listProdutoDTO;
    }

    public ResponseEntity salvar(Produto produto){
        try{
            produto.setDataHoraCadastro(Timestamp.from(Instant.now()));
            Produto produtoSalvo = produtoDAO.salvar(produto);
           return new ResponseEntity( "Produto "+produtoSalvo.getNome()+" criado com sucesso", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity("Erro ao cadastrar produto", HttpStatus.BAD_REQUEST);
        }
    }
}
