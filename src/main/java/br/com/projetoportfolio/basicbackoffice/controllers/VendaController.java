package br.com.projetoportfolio.basicbackoffice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoportfolio.basicbackoffice.entities.Venda;
import br.com.projetoportfolio.basicbackoffice.repositories.VendaRepository;
import br.com.projetoportfolio.basicbackoffice.exceptions.VendaNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class VendaController {

    private final VendaRepository repository;

    VendaController(final VendaRepository repository) {
        this.repository = repository;
    }

    // raiz
    @GetMapping("/vendas")
    List<Venda> all() {
        return repository.findAll();
    }

    @PostMapping("/vendas")
    Venda newVenda(@RequestBody final Venda novoVenda) {
        return repository.save(novoVenda);
    }

    @GetMapping("/vendas/{id}")
    Venda one(@PathVariable final Long id) {
        final Venda Venda = repository.findById(id).orElseThrow(() -> new VendaNotFoundException(id));

        return Venda;
    }

    @PutMapping("/vendas/{id}")
    Venda replaceVenda(@RequestBody final Venda newVenda, @PathVariable final Long id) {
        return repository.findById(id).map(Venda -> {
            Venda.setCliente(newVenda.getCliente());
            Venda.setDataFaturamento(newVenda.getDataFaturamento());
            Venda.setDataPedido(newVenda.getDataPedido());
            Venda.setItens(newVenda.getItens());
            return repository.save(Venda);
        }).orElseGet(() -> {
            newVenda.setId(id);
            return repository.save(newVenda);
        });
    }

    @DeleteMapping("/vendas/{id}")
    void deleteVenda(@PathVariable final Long id) {
        repository.deleteById(id);
    }
    
    

    

}