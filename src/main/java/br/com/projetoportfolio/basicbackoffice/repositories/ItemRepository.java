package br.com.projetoportfolio.basicbackoffice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoportfolio.basicbackoffice.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}