package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

@Repository
public class UsuarioRepository {

  List<Usuario> usuarios;

  public UsuarioRepository() {

    Usuario usr1 = new Usuario("Julio", 20);
    Usuario usr2 = new Usuario("Pedro", 21);
    Usuario usr3 = new Usuario("Ernan", 22);
    Usuario usr4 = new Usuario("Mario", 23);
    Usuario usr5 = new Usuario("Andres", 24);

    usuarios = new ArrayList<Usuario>();

    usuarios.add(usr1);
    usuarios.add(usr2);
    usuarios.add(usr3);
    usuarios.add(usr4);
    usuarios.add(usr5);
  }

  public String crearUsuario(Usuario usuario) {
    usuarios.add(usuario);
    return "Se ha creado el usuario con exito";
  }
  
  public String actualizarUsuario(Usuario usuario,String nombreNuevo,int edad) {
    for(Usuario usu : usuarios) {
      if(usu.getNombre().equals(usuario.getNombre())) {
        usu.setEdad(edad);
        usu.setNombre(nombreNuevo);
        return "Se actualizo con exito";
      }else {
        return "No se pudo actualziar";
        
      }
    }
    return "No hay usuarios";
  }

  public String eliminarUsuario(Usuario usuario) {
    if (usuario != null) {
      usuarios.remove(usuario);
      return "Se elimino el usuario con extio";
    }
    return "no se encontro un usuario para eliminar";
  }

  public List<Usuario> listarUsuarios() {
    return this.usuarios;
  }

  public Usuario buscarUsuario(String nombre) {

    for (Usuario usuario : usuarios) {
      if (usuario.getNombre().equals(nombre))
      return usuario;
    }

    return null;
  }
}
