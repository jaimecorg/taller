package com.jaimecorg.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimecorg.taller.model.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>{
    
}
