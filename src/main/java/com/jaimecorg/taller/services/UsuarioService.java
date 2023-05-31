package com.jaimecorg.taller.services;

import java.util.List;

import com.jaimecorg.taller.model.Usuario;

public interface UsuarioService{

    public List<Usuario> findAll();

    public Usuario findByID(int codigo);

    public Usuario insert(Usuario usuario);

    public void update(Usuario usuario);

    public void delete(int codigo); 
    
}
