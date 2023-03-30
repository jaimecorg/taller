package com.jaimecorg.taller.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.taller.model.Propietario;
import com.jaimecorg.taller.repository.PropietarioRepository;
import com.jaimecorg.taller.services.PropietarioService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class PropietarioServiceImpl implements PropietarioService{

    @Autowired
    PropietarioRepository repository;

    @Override
    public Page<Propietario> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Propietario findByID(int codigo) {
        Optional<Propietario> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Propietario propietario) {
        repository.save(propietario);   
    }

    @Override
    public void update(Propietario propietario) {
        repository.save(propietario);   
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);   
    }
}
