package com.ciberfarma.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ciberfarma.dto.ProductoSeleccionado;
import com.ciberfarma.service.BoletaService;
import com.ciberfarma.service.ProductoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("boleta")
@RequiredArgsConstructor
@SessionAttributes("seleccionados")
public class BoletaController {
	private final BoletaService boletaService;
	private final ProductoService productoService;
	
	@ModelAttribute("seleccionados")
	public List<ProductoSeleccionado> inicio(){
		return new ArrayList<ProductoSeleccionado>();
	}
	
	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute(boletaService.getAll());
		return "boleta/listado";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("productos", productoService.getAll());
		model.addAttribute("productoSeleccionado", new ProductoSeleccionado());
		return "boleta/nuevo";
	}
	
	@PostMapping("agregar")
	public String agregar(
			@ModelAttribute ProductoSeleccionado productoSeleccionado, 
			@ModelAttribute("seleccionados") List<ProductoSeleccionado> seleccionados,
			Model model
			) {
		model.addAttribute("productos", productoService.getAll());
		model.addAttribute("productoSeleccionado", new ProductoSeleccionado());
		
		seleccionados.add(productoSeleccionado);
		return "boleta/nuevo";
	}
}
