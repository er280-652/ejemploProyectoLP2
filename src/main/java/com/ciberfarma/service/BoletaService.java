package com.ciberfarma.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciberfarma.dto.ResultadoResponse;
import com.ciberfarma.model.Boleta;
import com.ciberfarma.repository.BoletaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoletaService {
	private final BoletaRepository boletaRepository;
	
	public List<Boleta> getAll() {
		return boletaRepository.findAll();
	}
	
	@Transactional
	public ResultadoResponse create(Boleta boleta) {
		try {
			var registro = boletaRepository.save(boleta);
			var mensaje = String.format("Boleta con Num %s registrado", registro.getNumBoleta());
			
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
}
