package com.udea.proyectofinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // un producto puede tener muchas ventas
    @NotNull(message = "El producto no puede estar vacío")
    // relacion producto
    @ManyToOne(fetch = FetchType.EAGER)
    // apunta a la tabla producto (llave foranea)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @NotNull(message = "La cantidad no puede estar vacía")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @NotNull(message = "La fecha no puede estar vacía")
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    // un cliente puede tener muchas ventas
    @NotNull(message = "El cliente no puede estar vacío")
    // relacion cliente
    @ManyToOne(fetch = FetchType.EAGER)
    // apunta a la tabla cliente (llave foranea)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @NotNull(message = "El estado no puede estar vacío")
    @Column(name = "estado", nullable = false)
    private String estado;

    @NotNull(message = "El precio unitario no puede estar vacío")
    @Column(name = "precio_unitario", nullable = false)
    private int precioUnitario;

    @NotNull(message = "El total no puede estar vacío")
    @Column(name = "total", nullable = false)
    private int total;

    public Venta() {
        this.fecha = LocalDateTime.now();
        this.estado = "Pendiente";
    }

    public Venta(Long id, Producto producto, int cantidad, LocalDateTime fecha, Cliente cliente, String estado, int precioUnitario, int total) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.cliente = cliente;
        this.estado = estado;
        this.precioUnitario = precioUnitario;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
