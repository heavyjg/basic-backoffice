package br.com.projetoportfolio.basicbackoffice.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Venda implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private @Id @GeneratedValue Long id;
    private Cliente cliente;
    private Date dataPedido;
    private Date dataFaturamento;
    private List<Item> itens;
    
    public Double Total(){
        Double total = 0.0;
        for(Item item: itens){
            total += item.getProduto().getPreco() * item.getQuantidade();
        }

        return total;
    }
}