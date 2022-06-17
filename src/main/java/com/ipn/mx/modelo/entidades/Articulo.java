package com.ipn.mx.modelo.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name="Articulo")
public class Articulo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticulo;
    
    @Column(name = "nombreArticulo", length = 50, nullable = false)
    private String nombreArticulo;
    
    @Column(name = "descripcionArticulo", length = 150, nullable = false)
    private String descripcionArticulo;
    
    @Column(name = "precioUnitarioArticulo", nullable = false)
    private double precioUnitarioArticulo;
    
    @Column(name = "existenciarticulo", nullable = false)
    private int exitenciasArticulo;
    
    @Column(name = "stockMinimoArticulo", nullable = false)
    private int stockMinimoArticulo;
    
    @Column(name = "stockMaximoArticulo", nullable = false)
    private int stockMaximoArticulo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    
}
