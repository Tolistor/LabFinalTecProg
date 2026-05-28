package com.udea.proyectofinal.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El Documento no puede estar vacio")
    @Column(name = "documento", nullable = false)
    private String documento;

    @NotBlank(message = "El Nombre no puede estar vacio")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "La direccion no puede estar vacio")
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @NotBlank(message = "La direccion no puede estar vacio")
    @Column(name = "correo", nullable = false)
    private String correo;


    public Cliente() {
    }

    public Cliente(long id, String documento, String nombre, String direccion, String correo) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;  }

    public String getCorreo() {return correo;}

    public void setCorreo(String correo) {this.correo = correo;}
}
