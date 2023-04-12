package com.jaimecorg.taller.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.taller.model.Mecanico;

public interface MecanicoService {
    
    public Page<Mecanico> findAll(Pageable page);
    public Mecanico findByID(int codigo);
    public void insert(Mecanico mecanico);
    public void update(Mecanico mecanico);
    public void delete(int codigo);
}
