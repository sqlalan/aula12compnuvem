package com.senai.aula12compnuvem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.aula12compnuvem.models.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final List<Produto> produtos = new ArrayList<>();

    public ProdutoController() {
        produtos.add(new Produto(1, "Notebook", 3500));
        produtos.add(new Produto(2, "Mouse", 100));
        produtos.add(new Produto(3, "Teclado", 250));
    }

    // GET /produtos -> lista todos
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtos);
    }

    // GET /produtos/{id} -> busca um produto
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // POST /produtos -> cadastra
    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
        produtos.add(produto);
        return ResponseEntity.ok(produto);
    }

    // PUT /produtos/{id} -> atualiza nome e preço
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable int id, @RequestBody Produto dados) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setNome(dados.getNome());
                p.setPreco(dados.getPreco());
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE /produtos/{id} -> remove
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerProduto(@PathVariable int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            return ResponseEntity.ok("Produto " + id + " removido com sucesso");
        }
        return ResponseEntity.notFound().build();
    }
}
