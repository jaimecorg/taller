package com.jaimecorg.taller.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.taller.model.Propietario;

public interface PropietarioService {
    
    public Page<Propietario> findAll(Pageable page);
    public Propietario findByID(int codigo);
    public void insert(Propietario propietario);
    public void update(Propietario propietario);
    public void delete(int codigo);
}
