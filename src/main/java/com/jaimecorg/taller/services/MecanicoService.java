package com.jaimecorg.taller.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.taller.model.Mecanico;

public interface MecanicoService {
    
    public Page<Mecanico> findAll(Pageable page);
    public List<Mecanico> findAll();
    public Mecanico findByID(int codigo);
    public void insert(Mecanico mecanico);
    public void update(Mecanico mecanico);
    public void delete(int codigo);
}
