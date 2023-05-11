package com.jaimecorg.taller.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int codigo;
    private String matricula;
    private String numBastidor;
    private Date fechaMatricuacion;
    private String marca;
    private String modelo;
    private String color;
    private String tipo;
    private int kilometros;

    @ManyToOne
    @JoinColumn(name="propietario", nullable = false)
    private Propietario propietario;
        
    
    @OneToMany(mappedBy = "vehiculo")
    private List<Reparacion> reparaciones;
    //private Set<Reparacion> reparaciones;
    

    public Vehiculo() {
        this.propietario = new Propietario();
    }

    public Vehiculo(int codigo) {
        this.codigo = codigo;
    }

    public Vehiculo(int codigo, String matricula, String numBastidor, Date fechaMatricuacion, String marca,
            String modelo, String color, String tipo, int kilometros, Propietario propietario,
            List<Reparacion> reparaciones) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.numBastidor = numBastidor;
        this.fechaMatricuacion = fechaMatricuacion;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.kilometros = kilometros;
        this.propietario = propietario;
        this.reparaciones = reparaciones;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNumBastidor() {
        return numBastidor;
    }

    public void setNumBastidor(String numBastidor) {
        this.numBastidor = numBastidor;
    }

    public Date getFechaMatricuacion() {
        return fechaMatricuacion;
    }

    public void setFechaMatricuacion(Date fechaMatricuacion) {
        this.fechaMatricuacion = fechaMatricuacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public List<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(List<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehiculo other = (Vehiculo) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    /*
     public Set<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(Set<Mecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }
     */
    
    
}
