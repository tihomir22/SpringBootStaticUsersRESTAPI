package com.abduscan.sa.restfulwebservicesdembow.Usuarios;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UsuarioResource {
    @Autowired
    private UsuarioService servicio;

    @GetMapping("/usuarios") public List<UsuarioDAO>recuperarTodosLosUsuarios(){
        return this.servicio.findAll();
    }

    @GetMapping("/usuarios/{id}") public UsuarioDAO recuperarUsuario(@PathVariable int id){
            UsuarioDAO usuario=this.servicio.findOne(id);
            if(usuario==null){
                throw new UsuarioNoEncontradoException("Usuario con id "+id+" no encontrado!");
            }
            return usuario;
    }

    @DeleteMapping("/usuarios/{id}") public UsuarioDAO eliminarUsuario(@PathVariable int id){
        UsuarioDAO usuario=this.servicio.eliminarUsuario(id);
        if(usuario==null){
            throw new UsuarioNoEncontradoException("Usuario con id "+id+" no encontrado!");
        }

        return usuario;
    }

    @PostMapping("/usuarios") public ResponseEntity<Object> guardarUsuario(@Valid @RequestBody UsuarioDAO usuario){
        UsuarioDAO usuarioDevuelto=this.servicio.save(usuario);
        URI localizacion=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioDevuelto.getId()).toUri();
        return ResponseEntity.created(localizacion).build();
    }
}
