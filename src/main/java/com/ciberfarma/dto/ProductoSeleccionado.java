package com.ciberfarma.dto;

import lombok.Data;

@Data
public class ProductoSeleccionado {
	private Integer idProducto;
	private String descripcion;
	private double precio;
	private int cantidad;

	public Double getSubtotal() {
		return precio * cantidad;
	}
}