package com.udea.proyectofinal.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "producto")


public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "El precio no puede estar vacio")
    @Min(value = 0, message = "El precio debe ser positivo")
    @Column(name = "precio", nullable = false)
    private int precio;

    // muchos productos pueden pertenecer a una categoria
    @NotNull(message = "La categoría no puede estar vacio")
    // relacion categoria
    @ManyToOne(fetch = FetchType.EAGER)
    // relacion categoria (llave foranea)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @NotNull(message = "El stock no puede estar vacio")
    @Min(value = 0, message = "El stock debe ser positivo")
    @Column(name = "Stock", nullable = false)
    private int stock;

    @NotBlank(message = "La referencia no puede estar vacio")
    @Column(name = "referencia", nullable = false)
    private String referencia;

    public Producto() {
    }

    public Producto(long id, int precio, Categoria categoria, int stock, String referencia) {
        this.id = id;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
        this.referencia = referencia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(@NotNull(message = "El precio no puede estar vacio") int precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotNull(message = "La categoría no puede estar vacio") Categoria categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(@NotNull(message = "El stock no puede estar vacio") int stock) {
        this.stock = stock;
    }

    public @NotBlank(message = "La referencia no puede estar vacio") String getReferencia() {
        return referencia;
    }

    public void setReferencia(@NotBlank(message = "La referencia no puede estar vacio") String referencia) {
        this.referencia = referencia;
    }
}
