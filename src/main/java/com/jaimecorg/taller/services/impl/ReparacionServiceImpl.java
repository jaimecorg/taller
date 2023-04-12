package com.jaimecorg.taller.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.taller.model.Reparacion;
import com.jaimecorg.taller.repository.ReparacionRepository;
import com.jaimecorg.taller.services.ReparacionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ReparacionServiceImpl implements ReparacionService{

    @Autowired
    ReparacionRepository repository;

    @Override
    public Page<Reparacion> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Reparacion findByID(int codigo) {
        Optional<Reparacion> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Reparacion reparacion) {
        repository.save(reparacion);   
    }

    @Override
    public void update(Reparacion reparacion) {
        repository.save(reparacion);   
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);   
    }
}
