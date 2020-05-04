package br.com.projetoportfolio.basicbackoffice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoportfolio.basicbackoffice.entities.Produto;
import br.com.projetoportfolio.basicbackoffice.repositories.ProdutoRepository;
import br.com.projetoportfolio.basicbackoffice.exceptions.ProdutoNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProdutoController {

    private final ProdutoRepository repository;

    ProdutoController(final ProdutoRepository repository) {
        this.repository = repository;
    }

    // raiz
    @GetMapping("/produtos")
    List<Produto> all() {
        return repository.findAll();
    }

    @PostMapping("/produtos")
    Produto newProduto(@RequestBody final Produto novoProduto) {
        return repository.save(novoProduto);
    }

    @GetMapping("/produtos/{id}")
    Produto one(@PathVariable final Long id) {
        final Produto Produto = repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id));

        return Produto;
    }

    @PutMapping("/produtos/{id}")
    Produto replaceProduto(@RequestBody final Produto newProduto, @PathVariable final Long id) {
        return repository.findById(id).map(Produto -> {
            Produto.setDescricao(newProduto.getDescricao());
            Produto.setPreco(newProduto.getPreco());
            return repository.save(Produto);
        }).orElseGet(() -> {
            newProduto.setId(id);
            return repository.save(newProduto);
        });
    }

    @DeleteMapping("/produtos/{id}")
    void deleteProduto(@PathVariable final Long id) {
        repository.deleteById(id);
    }
    
    

    

}