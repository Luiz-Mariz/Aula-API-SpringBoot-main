package com.example.cadastro_pessoas.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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

@Table(name = "compras")

@Getter
@Setter

@NoArgsConstructor
public class ComprasModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @CreationTimestamp
    private LocalDateTime dataCompra;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", foreignKey = @ForeignKey(name = "fk_compras_pessoa"))
    private PessoasModel pessoa ;
}
