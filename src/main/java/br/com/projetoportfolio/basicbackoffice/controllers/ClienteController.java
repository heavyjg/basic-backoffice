package br.com.projetoportfolio.basicbackoffice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoportfolio.basicbackoffice.entities.Cliente;
import br.com.projetoportfolio.basicbackoffice.repositories.ClienteRepository;
import br.com.projetoportfolio.basicbackoffice.exceptions.ClienteNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ClienteController {

    private final ClienteRepository repository;

    ClienteController(final ClienteRepository repository) {
        this.repository = repository;
    }

    // raiz
    @GetMapping("/clientes")
    List<Cliente> all() {
        return repository.findAll();
    }

    @PostMapping("/clientes")
    Cliente newCliente(@RequestBody final Cliente novoCliente) {
        return repository.save(novoCliente);
    }

    @GetMapping("/clientes/{id}")
    Cliente one(@PathVariable final Long id) {
        final Cliente cliente = repository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));

        return cliente;
    }

    @PutMapping("/clientes/{id}")
    Cliente replaceCliente(@RequestBody final Cliente newCliente, @PathVariable final Long id) {
        return repository.findById(id).map(cliente -> {
            cliente.setNome(newCliente.getNome());
            cliente.setEmail(newCliente.getEmail());
            cliente.setTelefone(newCliente.getTelefone());
            return repository.save(cliente);
        }).orElseGet(() -> {
            newCliente.setId(id);
            return repository.save(newCliente);
        });
    }

    @DeleteMapping("/clientes/{id}")
    void deleteCliente(@PathVariable final Long id) {
        repository.deleteById(id);
    }
    
    

    

}