package com.jaimecorg.taller.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.taller.model.Vehiculo;
import com.jaimecorg.taller.repository.VehiculoRepository;
import com.jaimecorg.taller.services.VehiculoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class VehiculoServiceImpl implements VehiculoService{

    @Autowired
    VehiculoRepository repository;

    @Override
    public Page<Vehiculo> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Vehiculo findByID(int codigo) {
        Optional<Vehiculo> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Vehiculo vehiculo) {
        repository.save(vehiculo);   
    }

    @Override
    public void update(Vehiculo vehiculo) {
        repository.save(vehiculo);   
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);   
    }

    @Override
    public Vehiculo findByMatricula(String matricula) {
        Vehiculo findByMatricula = repository.findByMatricula(matricula);
        if(findByMatricula != null){
            return findByMatricula;
        }
        return null;
    }
}
