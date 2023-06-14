package com.jaimecorg.taller.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.jaimecorg.taller.model.Permiso;
import com.jaimecorg.taller.model.Usuario;

@Service
public class UsuarioService implements UserDetailsService{

    @Value("${url.seguridad.rest.service}")
    String urlSeguridad;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
	PasswordEncoder encoder;

    public List<Usuario> findAll() {
        Usuario[] usu = restTemplate.getForObject(urlSeguridad + "usuarios", Usuario[].class);
        List<Usuario> usuarios = Arrays.asList(usu);

        return usuarios;
    }

    public Usuario findByID(int codigo) {
        Usuario usu = restTemplate.getForObject(urlSeguridad + "usuarios/" + codigo, Usuario.class);

        return usu;
    }

    public Usuario insert(Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));

        Usuario usu = restTemplate.postForObject(urlSeguridad + "usuarios", usuario, Usuario.class);

        return usu;
    }

    public void update(Usuario usuario) {
        //usuario.setPassword(encoder.encode(usuario.getPassword()));
        
        restTemplate.put(urlSeguridad + "usuarios/" + usuario.getCodigo(), usuario, Usuario.class);
    }

    public void delete(int codigo) {
        restTemplate.delete(urlSeguridad + "usuarios/" + codigo);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = restTemplate.getForObject(urlSeguridad + "usuarios/buscar/" + username, Usuario.class);
        List<GrantedAuthority> permisos = new ArrayList<GrantedAuthority>();

        if (usuario.getPermisos() != null) {
            List<Permiso> permisosUsuario = usuario.getPermisos();
            
            for (Permiso permiso : permisosUsuario) {
                permisos.add(new SimpleGrantedAuthority(permiso.getDescripcion()));
            }
        }

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(usuario.getNombre())
                .password(usuario.getPassword())
                .authorities(permisos)
                .build();

        return userDetails;
    }
    
}
