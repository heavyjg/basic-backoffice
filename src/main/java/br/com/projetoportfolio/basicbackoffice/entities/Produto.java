package br.com.projetoportfolio.basicbackoffice.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Produto implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = -5550824553722295672L;
    private @Id @GeneratedValue Long id;
    private String descricao;
    private Double preco;

    public Produto() {}

    public Produto (String descricao, Double preco){
        this.descricao = descricao;
        this.preco = preco;
    }
}