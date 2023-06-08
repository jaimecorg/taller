package com.jaimecorg.taller.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.taller.model.Permiso;
import com.jaimecorg.taller.model.Usuario;
import com.jaimecorg.taller.services.PermisoService;
import com.jaimecorg.taller.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @Autowired
    PermisoService permisoService;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        List<Usuario> usuarios = service.findAll();

        ModelAndView modelAndView = new ModelAndView("usuarios/list");
        modelAndView.addObject("usuarios", usuarios);

        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView create(Usuario usuario) {

        List<Permiso> permisos = permisoService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.addObject("permisos", permisos);
        modelAndView.setViewName("usuarios/create");

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Usuario usuario, @RequestParam(name="permisosSeleccionados") int[] permisosSeleccionados) throws IOException{

        List<Permiso> permisos = new ArrayList<Permiso>();
        //List<Permiso> allPermisos = permisoService.findAll();


        for(int codigo : permisosSeleccionados){
            // int index = allPermisos.indexOf(new Permiso(codigo));

            // if(index != -1){
            //     permisos.add(allPermisos.get(index));
            // }

            permisos.add(permisoService.findByID(codigo));

        }

        usuario.setPermisos(permisos);
        Usuario us = service.insert(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + us.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Usuario usuario = service.findByID(codigo);

        List<Permiso> permisos = permisoService.findAll();
        List<Permiso> permisosSeleccionados = usuario.getPermisos();

                
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("permisosSeleccionados", permisosSeleccionados);
        modelAndView.addObject("permisos", permisos);

        modelAndView.setViewName("usuarios/edit");

        return modelAndView;
    }

    /* @PostMapping(path = { "/update" })
    public ModelAndView update(Usuario usuario) {

        service.update(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());
        
        return modelAndView;
    } */

    @PostMapping(path = { "/update" })
    public ModelAndView update(@ModelAttribute("usuario") Usuario usuario,
                            @RequestParam(name = "permisosSeleccionados", required = false) int[] permisosSeleccionados) {

        List<Permiso> permisos = new ArrayList<>();

        if (permisosSeleccionados != null) {
            for (int codigoPermiso : permisosSeleccionados) {
                Permiso permiso = permisoService.findByID(codigoPermiso);
                permisos.add(permiso);
            }
        }

        usuario.setPermisos(permisos);
        service.update(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());

        return modelAndView;
    }


    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        service.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/usuarios/list");

        return modelAndView;
    }
}
