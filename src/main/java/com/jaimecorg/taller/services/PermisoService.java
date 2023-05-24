package com.jaimecorg.taller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.taller.model.Permiso;
import com.jaimecorg.taller.repository.PermisoRepository;

@Service
public class PermisoService {
    @Autowired
    private PermisoRepository permissionRepository;

    public Permiso createPermiso(Permiso permission) {
        return permissionRepository.save(permission);
    }

    public Permiso updatePermiso(Permiso permission) {
        return permissionRepository.save(permission);
    }

    public void deletePermiso(Integer permissionId) {
        permissionRepository.deleteById(permissionId);
    }

    public Permiso getPermiso(Integer permissionId) {
        return permissionRepository.findById(permissionId).orElse(null);
    }

    public List<Permiso> getAllPermisos() {
        return permissionRepository.findAll();
    }
}
