package com.jaimecorg.taller.services.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jaimecorg.taller.model.Usuario;
import com.jaimecorg.taller.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Value("${url.seguridad.rest.service}")
    String urlSeguridad;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Usuario> findAll() {
        Usuario[] us = restTemplate.getForObject(urlSeguridad + "usuarios", Usuario[].class);
        List<Usuario> usuarios = Arrays.asList(us);

        return usuarios;
    }

    @Override
    public Usuario findByID(int codigo) {
        Usuario us = restTemplate.getForObject(urlSeguridad + "usuarios/" + codigo, Usuario.class);

        return us;
    }

    @Override
    public Usuario insert(Usuario usuario) {
        Usuario us = restTemplate.postForObject(urlSeguridad + "usuarios", usuario, Usuario.class);

        return us;
    }

    @Override
    public void update(Usuario usuario) {
        restTemplate.put(urlSeguridad + "usuarios/" + usuario.getCodigo(), usuario);
    }

    @Override
    public void delete(int codigo) {
        restTemplate.delete(urlSeguridad + "usuarios/" + codigo);
    }

    
}
