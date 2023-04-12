package com.jaimecorg.taller.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.taller.model.Reparacion;

public interface ReparacionService {
    
    public Page<Reparacion> findAll(Pageable page);
    public Reparacion findByID(int codigo);
    public void insert(Reparacion reparacion);
    public void update(Reparacion reparacion);
    public void delete(int codigo);
}
