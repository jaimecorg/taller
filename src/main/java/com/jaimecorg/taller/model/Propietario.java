package com.jaimecorg.taller.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Propietario {

    @Id
    @GeneratedValue
    private int codigo;
    private String dni;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private int telefono;
    private String direccion;
    private String email;

    @OneToMany(mappedBy = "propietario")
    private Set<Vehiculo> vehiculo;

    
    public Propietario() {
    }

    public Propietario(int codigo) {
        this.codigo = codigo;
    }


    public Propietario(int codigo, String dni, String nombre, String apellidos, Date fechaNacimiento, int telefono,
            String direccion, String email, Set<Vehiculo> vehiculo) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.vehiculo = vehiculo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Set<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
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
        Propietario other = (Propietario) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    } 
}
