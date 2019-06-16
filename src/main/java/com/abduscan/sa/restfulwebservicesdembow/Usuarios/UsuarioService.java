package com.abduscan.sa.restfulwebservicesdembow.Usuarios;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UsuarioService {

    private static List<UsuarioDAO> usuarios=new ArrayList<>();

    private static int cuentaUsuarios=3;

    static{
        usuarios.add(new UsuarioDAO(1,"Dembow","Fill de puta",new Date()));
        usuarios.add(new UsuarioDAO(2,"Dembow2","Fill de puta2",new Date()));
        usuarios.add(new UsuarioDAO(3,"Dembow3","Fill de puta3",new Date()));

    }

    public List<UsuarioDAO>findAll(){
        return usuarios;
    }

    public UsuarioDAO save(UsuarioDAO usuario){
        if(usuario.getId()==null){
            usuario.setId(cuentaUsuarios++);
        }
        usuarios.add(usuario);
        return usuario;
    }

    public UsuarioDAO findOne(int id){
        for (UsuarioDAO usuario:usuarios) {
            if(usuario.getId()==id){
                return usuario;
            }
        }
        return null;
    }

    public UsuarioDAO eliminarUsuario(int id){
        UsuarioDAO usuario=findOne(id);
       if(usuario!=null){
           usuarios.remove(usuario);
           return usuario;
       }else{
           return null;
       }
    }



}
