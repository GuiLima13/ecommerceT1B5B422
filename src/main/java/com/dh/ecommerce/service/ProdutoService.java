package com.dh.ecommerce.service;

import com.dh.ecommerce.entity.Pedido;
import com.dh.ecommerce.entity.Produto;
import com.dh.ecommerce.entity.dto.ProdutoDTO;
import com.dh.ecommerce.exception.ResourceNotFoundException;
import com.dh.ecommerce.repository.ProdutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;


    public List<ProdutoDTO> buscar(){
        List<Produto> listProduto = repository.findAll();
        List<ProdutoDTO> listProdutoDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Produto produto : listProduto) {
            ProdutoDTO produtoDTO = mapper.convertValue(produto, ProdutoDTO.class);
            listProdutoDTO.add(produtoDTO);
        }
        return listProdutoDTO;
    }

    public Produto salvar(Produto produto){

            produto.setDataHoraCadastro(Timestamp.from(Instant.now()));
            Produto produtoSalvo = repository.save(produto);
            return produtoSalvo;
    }

    public  ResponseEntity deletar(Long id){
        Optional<Produto> produto =repository.findById(id);

        if(produto.isEmpty()){
            return new ResponseEntity("Id do produto não existe", HttpStatus.BAD_REQUEST);
        }
//        repository.findById(id).orElseThrow(() -> new RuntimeException());
        repository.deleteById(id);
        return new ResponseEntity("Excluido com sucesso", HttpStatus.OK);
    }

    public ResponseEntity buscarPorSku(String sku,String nome) throws ResourceNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Produto> produto = repository.buscaPorSkuAndNome(sku,nome);
       // Optional<Produto> produto = repository.buscaPorSkuAndNome(sku,nome).orElseThrow(() -> { new ResourceNotFoundException("Produto não encontrado");});


        if(produto.isEmpty()){
           throw new ResourceNotFoundException("Produto não encontrado");
        }
        ProdutoDTO produtoDTO = mapper.convertValue(produto.get(), ProdutoDTO.class);
        return new ResponseEntity(produtoDTO,HttpStatus.CREATED);
    }

    public ProdutoDTO alteracaoParcial(ProdutoDTO produtoDTO){
        ObjectMapper mapper = new ObjectMapper();
        Optional<Produto> produtoOptional = repository.findBySku(produtoDTO.getSku());
        ProdutoDTO produtoAlterado = null;
        if(produtoOptional.isEmpty()){
            return produtoAlterado;
        }
        Produto produto = produtoOptional.get();
        if(produtoDTO.getNome() != null){
            produto.setNome(produtoDTO.getNome());
        }
        if(produtoDTO.getCategoria() != null){
            produto.setCategoria(produtoDTO.getCategoria());
        }
        if(produtoDTO.getLote() != null){
            produto.setLote(produtoDTO.getLote());
        }
        if(produtoDTO.getFornecedor() != null){
            produto.setFornecedor(produtoDTO.getFornecedor());
        }
        if(produtoDTO.getValor() != null){
            produto.setValor(produtoDTO.getValor());
        }

         produtoAlterado = mapper.convertValue(repository.save(produto), ProdutoDTO.class);

        return produtoAlterado;
    }
}
