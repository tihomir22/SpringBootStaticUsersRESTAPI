package com.abduscan.sa.restfulwebservicesdembow.Usuarios;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "Todos los usuarios registrados en la plataforma")
public class UsuarioDAO {
        private Integer id;


        @Size(min=2,message = "Minimo el nombre debe tener 2 caracteres!")
        private String name;


        private String descripcion;
        @Past
        @ApiModelProperty(notes = "La fecha de inicio no puede ser en el pasado!")
        private Date fechaInicio;

    public UsuarioDAO() {

    }

    public UsuarioDAO(int id, String name, String descripcion, Date fechaInicio) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "UsuarioDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
