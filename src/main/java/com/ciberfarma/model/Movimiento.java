package com.ciberfarma.model;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_movimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_movimiento")
    private Integer idMovimiento;

    @Column(name="fecha") 
    private LocalDate fecha;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="monto")
    private Double monto;

    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
}