package com.example.cadastro_pessoas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "itensCompra")

@Getter
@Setter

@NoArgsConstructor
public class ItensCompraModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "compra_id", foreignKey = @ForeignKey(name = "fk_itensCompra_compra"))
    private ComprasModel compra;

    @ManyToOne
    @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name = "fk_itensCompra_produto"))
    private ProdutosModel produto;

    @Column
    private int quantidade;

    @Column
    private double precoUnitario;

}
