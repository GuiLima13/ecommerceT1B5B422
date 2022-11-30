package com.dh.ecommerce.controller;

import com.dh.ecommerce.entity.Produto;
import com.dh.ecommerce.entity.dto.ProdutoDTO;
import com.dh.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
//    public String buscar(@RequestParam(value = "numPedido", required = false) int numPedido,
//                         @RequestParam("nomeUsuario") String nomeUsuario){
//        return "Numero pedido: "+numPedido+ " nome usuario: "+nomeUsuario;
//    }

//    @GetMapping("/buscar")
//    public String buscarPrimeiro(){
//        return "Entrou no primeiro get";
//    }

    @Autowired
    ProdutoService service;

    @GetMapping("/buscarSKU/{sku}/{nome}")
    public ResponseEntity buscarPorNome(@PathVariable String sku,@PathVariable String nome){
        return service.buscarPorSku(sku,nome);
    }
    @GetMapping()
    public List<ProdutoDTO> buscar(){
        return service.buscar();
    }
    @PostMapping()
    public ResponseEntity salvar( @RequestBody @Valid Produto produto){
        System.out.println();
        return service.salvar(produto);
    }
    @DeleteMapping()
    public ResponseEntity deletar(@RequestParam("id") Long id){
        return service.deletar(id);
    }
    @PatchMapping()
    public ResponseEntity alteracaoParcial(@RequestBody @Valid ProdutoDTO produtoDTO){
        return service.alteracaoParcial(produtoDTO);
    }
    @PutMapping()
    public String alteracaoTotal(){
        return "Entrou no  Put";
    }
}
