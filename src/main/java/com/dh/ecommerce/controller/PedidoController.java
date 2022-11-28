package com.dh.ecommerce.controller;

import com.dh.ecommerce.entity.Pedido;
import com.dh.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService service;

    @PostMapping
    public ResponseEntity salvar(@RequestBody Pedido pedido){
        return service.salvar(pedido);
    }

    @GetMapping
    public ResponseEntity buscarTodos(){
        return service.buscarTodo();
    }
}
