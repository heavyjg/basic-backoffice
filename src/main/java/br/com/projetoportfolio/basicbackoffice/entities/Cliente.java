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
public class Cliente implements Serializable{

    
    private static final long serialVersionUID = -4665895778538863890L;

    private @Id @GeneratedValue Long id;
    private String nome;
    private String telefone;
    private String email;

    public Cliente () {}

    public Cliente(String nome, String telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
}