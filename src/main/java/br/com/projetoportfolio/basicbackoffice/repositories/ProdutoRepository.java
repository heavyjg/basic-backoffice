package br.com.projetoportfolio.basicbackoffice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoportfolio.basicbackoffice.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}