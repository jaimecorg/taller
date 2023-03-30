package com.jaimecorg.taller.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.taller.model.Vehiculo;

public interface VehiculoService {
    
    public Page<Vehiculo> findAll(Pageable page);
    public Vehiculo findByID(int codigo);
    public void insert(Vehiculo vehiculo);
    public void update(Vehiculo vehiculo);
    public void delete(int codigo);
}
