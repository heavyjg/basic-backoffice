package br.com.projetoportfolio.basicbackoffice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoportfolio.basicbackoffice.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
    
}