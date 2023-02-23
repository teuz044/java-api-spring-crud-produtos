package br.com.crudUdemy.demo.controller;

import br.com.crudUdemy.demo.model.Produto;
import br.com.crudUdemy.demo.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController (ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos () {
        return ResponseEntity.status(200).body(produtoService.obterTodos());
    }

    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@PathVariable Produto produto) {
        return ResponseEntity.status(201).body(produtoService.adicionarProduto(produto));
    }

}
