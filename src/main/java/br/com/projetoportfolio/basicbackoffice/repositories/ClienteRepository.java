package br.com.projetoportfolio.basicbackoffice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoportfolio.basicbackoffice.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}