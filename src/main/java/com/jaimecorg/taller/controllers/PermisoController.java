package com.jaimecorg.taller.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.taller.model.Permiso;
import com.jaimecorg.taller.services.PermisoService;

@Controller
@RequestMapping("/permisos")
public class PermisoController {

    @Autowired
    PermisoService service;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        List<Permiso> permisos = service.findAll();

        ModelAndView modelAndView = new ModelAndView("permisos/list");
        modelAndView.addObject("permisos", permisos);

        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView create(Permiso permiso) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permiso", new Permiso());
        modelAndView.setViewName("permisos/create");

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Permiso permiso) throws IOException{

        Permiso pr = service.insert(permiso);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + pr.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Permiso permiso = service.findByID(codigo);
                
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permiso", permiso);
        modelAndView.setViewName("permisos/edit");

        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Permiso usuario) {

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
        modelAndView.setViewName("redirect:/permisos/list");

        return modelAndView;
    }
}
