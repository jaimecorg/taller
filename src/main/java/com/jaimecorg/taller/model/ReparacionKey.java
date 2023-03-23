package com.jaimecorg.taller.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ReparacionKey implements Serializable{
    int vehiculo_codigo;
    int mecanico_codigo;
    
    public ReparacionKey() {
    }

    public ReparacionKey(int vehiculo_codigo, int mecanico_codigo) {
        this.vehiculo_codigo = vehiculo_codigo;
        this.mecanico_codigo = mecanico_codigo;
    }

    public int getVehiculo_codigo() {
        return vehiculo_codigo;
    }

    public void setVehiculo_codigo(int vehiculo_codigo) {
        this.vehiculo_codigo = vehiculo_codigo;
    }

    public int getMecanico_codigo() {
        return mecanico_codigo;
    }

    public void setMecanico_codigo(int mecanico_codigo) {
        this.mecanico_codigo = mecanico_codigo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + vehiculo_codigo;
        result = prime * result + mecanico_codigo;
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
        ReparacionKey other = (ReparacionKey) obj;
        if (vehiculo_codigo != other.vehiculo_codigo)
            return false;
        if (mecanico_codigo != other.mecanico_codigo)
            return false;
        return true;
    }
}
