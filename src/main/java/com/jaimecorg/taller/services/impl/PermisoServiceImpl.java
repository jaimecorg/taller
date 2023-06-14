package com.jaimecorg.taller.services.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jaimecorg.taller.model.Permiso;
import com.jaimecorg.taller.services.PermisoService;

@Service
public class PermisoServiceImpl implements PermisoService{

    @Value("${url.seguridad.rest.service}")
    String urlSeguridad;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Permiso> findAll() {
        Permiso[] pr = restTemplate.getForObject(urlSeguridad + "permisos", Permiso[].class);
        List<Permiso> permisos = Arrays.asList(pr);

        return permisos;
    }

    @Override
    public Permiso findByID(int codigo) {
        Permiso pr = restTemplate.getForObject(urlSeguridad + "permisos/" + codigo, Permiso.class);

        return pr;
    }

    @Override
    public Permiso insert(Permiso permiso) {
        Permiso pr = restTemplate.postForObject(urlSeguridad + "permisos", permiso, Permiso.class);

        return pr;
    }

    @Override
    public void update(Permiso permiso) {
        restTemplate.put(urlSeguridad + "permisos/" + permiso.getCodigo(), permiso);
    }

    @Override
    public void delete(int codigo) {
        restTemplate.delete(urlSeguridad + "permisos/" + codigo);
    }    
}
