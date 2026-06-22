package com.ciberfarma.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.ciberfarma.dto.ResultadoResponse;
import com.ciberfarma.model.Movimiento;
import com.ciberfarma.repository.MovimientoRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientoService {
	
	private final MovimientoRepository productoRepository;
	
	public List<Movimiento> getAll() {
		return productoRepository.findAllByOrderByIdMovimientoDesc();
	}
	
/*	public List<Movimiento> search(ProductoFilter filter) {
		return productoRepository.findAllByFilters(filter.getIdCategoria(), filter.getIdProveedor());
	}*/
	
	public ResultadoResponse create(Movimiento producto) {
		try {
			var registro = productoRepository.save(producto);
			var mensaje = String.format(
				    "Movimiento con Id %s registrado",
				    registro.getIdMovimiento()
				);
			
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
	
	
	public Movimiento getOne(Integer idProducto) {
		return productoRepository.findById(idProducto).orElseThrow();
	}
	
	public ResultadoResponse update(Movimiento producto) {
		try {
			var registro = productoRepository.save(producto);
			var mensaje = String.format("Movimiento con Id %s actualizado",registro.getIdMovimiento());
			
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
	
	}	
	
	
	
	
	
	
	
	
	
	

