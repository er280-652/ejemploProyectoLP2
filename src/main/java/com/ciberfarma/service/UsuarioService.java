package com.ciberfarma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciberfarma.dto.ResultadoResponse;
import com.ciberfarma.model.Usuario;
import com.ciberfarma.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuariorepository;
	
	public List<Usuario> getAll() {
		return usuariorepository.findAll();
	}
	
	public Usuario getOne(Integer id) {
		return usuariorepository.findById(id).orElseThrow();
	}
	
	public ResultadoResponse create(Usuario usuario) {
	    try {

	        usuario.setActivo(true); 

	        if (usuario.getClave() == null || usuario.getClave().isBlank()) {
	            return new ResultadoResponse(false, "La clave es obligatoria");
	        }

	        var registro = usuariorepository.save(usuario);

	        return new ResultadoResponse(true,
	                "Usuario con ID " + registro.getIdUsuario() + " registrado");

	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResultadoResponse(false, "Hubo un error en la transacción");
	    }
	}
	
	
	
	
	public ResultadoResponse update(Usuario usuario) {
	    try {
	        var original = usuariorepository.findById(usuario.getIdUsuario()) .orElseThrow();
	               
	        original.setNombres(usuario.getNombres());
	        original.setApellidos(usuario.getApellidos());
	        original.setCuenta(usuario.getCuenta());
	        original.setTipo(usuario.getTipo());
	        
	        
	        original.setActivo(original.getActivo());
	        original.setClave(original.getClave());
	        original.setFecha_nac(original.getFecha_nac());

	        var registro = usuariorepository.save(original);

	        var mensaje = String.format("Usuario con ID %s actualizado",registro.getIdUsuario()
	               
	        );

	        return new ResultadoResponse(true, mensaje);

	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResultadoResponse(false, "Hubo un error en la transacción");
	            
	    }
	}
	
	@Transactional
	public ResultadoResponse changeActive(Integer id) {
		try {
			var usuario = usuariorepository.findById(id).orElseThrow();
			
			usuario.setActivo(!usuario.getActivo());
			
			var estado = usuario.getActivo() ? "Activo" : "desactivado";
			var mensaje = String.format("Usuario con ID %s %s", usuario.getIdUsuario(), estado);
			
			return new ResultadoResponse(true, mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
	
	
}
