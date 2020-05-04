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
public class Item implements Serializable{
    /**
    *
    */
    private static final long serialVersionUID = 3489523316288854998L;

    private @Id @GeneratedValue Long id;
    private Integer sequencia;
    private Produto produto;
    private double quantidade;
}