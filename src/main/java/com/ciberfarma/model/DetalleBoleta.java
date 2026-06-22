package com.ciberfarma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_det_boleta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(DetalleBoletaId.class)
public class DetalleBoleta {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="num_boleta")
	private Boleta boleta;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_producto")
	private Movimiento producto;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="precio_venta")
	private Double precioVenta;
	
}
