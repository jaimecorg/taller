package com.jaimecorg.taller.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.taller.model.Mecanico;
import com.jaimecorg.taller.model.Usuario;
import com.jaimecorg.taller.services.MecanicoService;
import com.jaimecorg.taller.services.UsuarioService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @Value("${pagination.size}")
    int sizePage;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list/1/codigo/asc");
        return modelAndView;
    }

    /* @GetMapping(value = "/list/{numPage}/{fieldSort}/{directionSort}")
    public ModelAndView listPage(Model model,
            @PathVariable("numPage") Integer numPage,
            @PathVariable("fieldSort") String fieldSort,
            @PathVariable("directionSort") String directionSort) {


        Pageable pageable = PageRequest.of(numPage - 1, sizePage,
            directionSort.equals("asc") ? Sort.by(fieldSort).ascending() : Sort.by(fieldSort).descending());

        Page<Mecanico> page = service.getAllUsers(pageable);

        List<Mecanico> mecanicos = page.getContent();

        ModelAndView modelAndView = new ModelAndView("mecanicos/list");
        modelAndView.addObject("mecanicos", mecanicos);


        modelAndView.addObject("numPage", numPage);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalElements", page.getTotalElements());

        modelAndView.addObject("fieldSort", fieldSort);
        modelAndView.addObject("directionSort", directionSort.equals("asc") ? "asc" : "desc");

        return modelAndView;
    } */

    @GetMapping(value = "/create")
    public ModelAndView create(Usuario usuario) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.setViewName("usuarios/create");

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Usuario usuario) throws IOException{

        service.createUser(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Usuario usuario = service.getUser(codigo);
                
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", usuario);
        modelAndView.setViewName("usuarios/edit");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Usuario usuario) {

        service.updateUser(usuario);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + usuario.getCodigo());
        
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        service.deleteUser(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/usuarios/list");

        return modelAndView;
    }
}
