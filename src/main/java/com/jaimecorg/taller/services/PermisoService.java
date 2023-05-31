package com.jaimecorg.taller.services;

import java.util.List;

import com.jaimecorg.taller.model.Permiso;

public interface PermisoService {

    public List<Permiso> findAll();

    public Permiso findByID(int codigo);

    public Permiso insert(Permiso permiso);

    public void update(Permiso permiso);

    public void delete(int codigo);

    
}
