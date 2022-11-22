package com.dh.ecommerce.controller;

import com.dh.ecommerce.model.Produto;
import com.dh.ecommerce.model.dto.ProdutoDTO;
import com.dh.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    //@RequestMapping(value = "/buscar", method = RequestMethod.GET)
//    @GetMapping("/buscar/{numPedido}/{nomeUsuario}")
//    public String buscar(@PathVariable String numPedido, @PathVariable String nomeUsuario){
//        return "Numero pedido: "+numPedido+ " nome usuario: "+nomeUsuario;
//    }
//    @GetMapping()
//    public String buscar(@RequestParam("numPedido") int numPedido,
//                         @RequestParam("nomeUsuario") String nomeUsuario){
//        return "Numero pedido: "+numPedido+ " nome usuario: "+nomeUsuario;
//    }

//    @GetMapping("/buscar")
//    public String buscarPrimeiro(){
//        return "Entrou no primeiro get";
//    }

    @Autowired
    ProdutoService service;


    @GetMapping()
    public List<ProdutoDTO> buscarSegundo(){
        return service.buscar();
    }
    @PostMapping()
    public ResponseEntity salvar(@RequestBody Produto produto){
        System.out.println();
        return service.salvar(produto);
    }
    @DeleteMapping()
    public String deletar(){
        return "Entrou no delete";
    }
    @PatchMapping()
    public String alteracaoParcial(){
        return "Entrou no  Patch";
    }
    @PutMapping()
    public String alteracaoTotal(){
        return "Entrou no  Put";
    }
}
