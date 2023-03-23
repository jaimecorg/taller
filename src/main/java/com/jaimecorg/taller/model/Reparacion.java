package com.jaimecorg.taller.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
//Muchos a uno al reves, crear id independiente y buscar asociación con propiedades
@Entity
public class Reparacion {

    @Id
    @GeneratedValue
    private int codigo;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId("vehiculo_codigo")
    private Vehiculo vehiculo;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId("mecanico_codigo")
    private Mecanico mecanico;

    private Date fechaEntrada;
    private Date fechaSalida;
    private Float kilometrosSalida;
    private String descripcion;
    private String estado;
    private String observaciones;
    private Float precio;
    
    public Reparacion() {
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Float getKilometrosSalida() {
        return kilometrosSalida;
    }

    public void setKilometrosSalida(Float kilometrosSalida) {
        this.kilometrosSalida = kilometrosSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
