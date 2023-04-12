package com.jaimecorg.taller.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.taller.model.Mecanico;
import com.jaimecorg.taller.repository.MecanicoRepository;
import com.jaimecorg.taller.services.MecanicoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class MecanicoServiceImpl implements MecanicoService{

    @Autowired
    MecanicoRepository repository;

    @Override
    public Page<Mecanico> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Mecanico findByID(int codigo) {
        Optional<Mecanico> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Mecanico mecanico) {
        repository.save(mecanico);   
    }

    @Override
    public void update(Mecanico mecanico) {
        repository.save(mecanico);   
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);   
    }
}
