package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public String crearUsuario(String nombre, String edad) {
		Usuario usuario = new Usuario(nombre, Integer.parseInt(edad));
		return usuarioRepository.crearUsuario(usuario);
	}
	
	public String actualizarUsuario(String nombre,String nombreNuevo, String edad) {
	  Usuario usuario = usuarioRepository.buscarUsuario(nombre);
    return usuarioRepository.actualizarUsuario(usuario,nombreNuevo , Integer.parseInt(edad));
  }
	
	public String eliminarUsuario(String nombreUsuario) {
		Usuario usuario = usuarioRepository.buscarUsuario(nombreUsuario);
		return usuarioRepository.eliminarUsuario(usuario);
	}
	
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.listarUsuarios();
	}
}
