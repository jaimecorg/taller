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
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.taller.model.Mecanico;
import com.jaimecorg.taller.model.Reparacion;
import com.jaimecorg.taller.model.Vehiculo;
import com.jaimecorg.taller.services.MecanicoService;
//import com.jaimecorg.taller.model.Vehiculo;
import com.jaimecorg.taller.services.ReparacionService;
import com.jaimecorg.taller.services.VehiculoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Controller
@RequestMapping("/reparaciones")
public class ReparacionController {
    @Autowired
    ReparacionService reparacionService;

    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    MecanicoService mecanicoService;

    @Value("${pagination.size}")
    int sizePage;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list/1/codigo/asc");
        return modelAndView;
    }

    @GetMapping(value = "/list/{numPage}/{fieldSort}/{directionSort}")
    public ModelAndView listPage(Model model,
            @PathVariable("numPage") Integer numPage,
            @PathVariable("fieldSort") String fieldSort,
            @PathVariable("directionSort") String directionSort) {


        Pageable pageable = PageRequest.of(numPage - 1, sizePage,
            directionSort.equals("asc") ? Sort.by(fieldSort).ascending() : Sort.by(fieldSort).descending());

        Page<Reparacion> page = reparacionService.findAll(pageable);

        List<Reparacion> reparaciones = page.getContent();

        ModelAndView modelAndView = new ModelAndView("reparaciones/list");
        modelAndView.addObject("reparaciones", reparaciones);


        modelAndView.addObject("numPage", numPage);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalElements", page.getTotalElements());

        modelAndView.addObject("fieldSort", fieldSort);
        modelAndView.addObject("directionSort", directionSort.equals("asc") ? "asc" : "desc");

        return modelAndView;
    }

    // @GetMapping(value = "/create")
    // public ModelAndView create(Reparacion reparacion) {

    //     List<Mecanico> mecanicos = mecanicoService.findAll();
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.addObject("reparacion", new Reparacion());
    //     modelAndView.addObject("mecanicos", mecanicos);
    //     modelAndView.setViewName("reparaciones/create");

    //     return modelAndView;
    // }

    @GetMapping(value = "/create/{codigo}")
    public ModelAndView createConVehiculo(
        @PathVariable(name = "codigo", required = true) int codigo) {

        List<Mecanico> mecanicos = mecanicoService.findAll();

        Vehiculo vehiculo = vehiculoService.findByID(codigo);

        Reparacion reparacion = new Reparacion();
        reparacion.setVehiculo(vehiculo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reparacion", reparacion);
        modelAndView.addObject("mecanicos", mecanicos);

        modelAndView.setViewName("reparaciones/create");

        return modelAndView;
    }

    /*
     @PostMapping(path = "/save")
    public ModelAndView save(Reparacion reparacion) throws IOException{

        reparacionService.insert(reparacion);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + reparacion.getCodigo());

        return modelAndView;
    }
     */
    

    @PostMapping(path = "/save")
    public ModelAndView save(Reparacion reparacion, 
                            @RequestParam("vehiculoCodigo") int vehiculoCodigo) throws IOException {

        Vehiculo vehiculo = vehiculoService.findByID(vehiculoCodigo);
        reparacion.setVehiculo(vehiculo);

        reparacionService.insert(reparacion);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + reparacion.getCodigo());

        return modelAndView;
    }  

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Reparacion reparacion = reparacionService.findByID(codigo);
                
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reparacion", reparacion);
        modelAndView.setViewName("reparaciones/edit");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Reparacion reparacion) {

        int vehiculoIdExistente = reparacionService.findByID(reparacion.getCodigo()).getVehiculo().getCodigo();
        
        Vehiculo vehiculoExistente = vehiculoService.findByID(vehiculoIdExistente);
        reparacion.setVehiculo(vehiculoExistente);

        reparacionService.update(reparacion);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + reparacion.getCodigo());
        
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Reparacion reparacion = reparacionService.findByID(codigo);
        Vehiculo vehiculo = reparacion.getVehiculo();

        reparacionService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/vehiculos/edit/" + vehiculo.getCodigo());

        return modelAndView;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
