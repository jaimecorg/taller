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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jaimecorg.taller.model.Vehiculo;
import com.jaimecorg.taller.services.VehiculoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    VehiculoService vehiculoService;

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
            @PathVariable("directionSort") String directionSort
            // , @RequestParam String matricula
            ) {


        Pageable pageable = PageRequest.of(numPage - 1, sizePage,
            directionSort.equals("asc") ? Sort.by(fieldSort).ascending() : Sort.by(fieldSort).descending());

        Page<Vehiculo> page = vehiculoService.findAll(pageable);

        List<Vehiculo> vehiculos = page.getContent();

        ModelAndView modelAndView = new ModelAndView("vehiculos/list");
        modelAndView.addObject("vehiculos", vehiculos);


        modelAndView.addObject("numPage", numPage);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalElements", page.getTotalElements());

        modelAndView.addObject("fieldSort", fieldSort);
        modelAndView.addObject("directionSort", directionSort.equals("asc") ? "asc" : "desc");

        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView create(Vehiculo vehiculo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vehiculo", new Vehiculo());
        modelAndView.setViewName("vehiculos/create");

        return modelAndView;
    }

    @GetMapping(value = "/create/{codigo}")
    public ModelAndView createConPropietario(Vehiculo vehiculo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vehiculo", new Vehiculo());
        modelAndView.setViewName("vehiculos/create");

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Vehiculo vehiculo) throws IOException{

        vehiculoService.insert(vehiculo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + vehiculo.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Vehiculo vehiculo = vehiculoService.findByID(codigo);
                
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vehiculo", vehiculo);
        modelAndView.setViewName("vehiculos/edit");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Vehiculo vehiculo) {

        vehiculoService.update(vehiculo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../propietarios/edit/" + vehiculo.getPropietario().getCodigo());
        
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

                vehiculoService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/vehiculos/list");

        return modelAndView;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping(path = { "/listar/{codigo}" })
    public ModelAndView listByCode(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Vehiculo vehiculo = vehiculoService.findByID(codigo);
                
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vehiculo", vehiculo);
        modelAndView.setViewName("vehiculos/listOne");
        return modelAndView;
    }

    @GetMapping(path = { "/search" })
    public ModelAndView listByCode(
            @RequestParam String matricula) {

        Vehiculo vehiculo = vehiculoService.findByMatricula(matricula);
                
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vehiculo", vehiculo);
        modelAndView.setViewName("vehiculos/list");
        return modelAndView;
    }

    /*
    @GetMapping("/vehiculos/listar/{codigo}")
    public String mostrarVehiculo(@PathVariable("codigo") int codigo, Model model) {
    // Buscar el vehículo con el código especificado en la lista de vehículos del propietario
    Vehiculo vehiculoSeleccionado = null;
    
    for (Vehiculo vehiculo : propietario.getVehiculo()) {
        if (vehiculo.getCodigo() == codigo) {
            vehiculoSeleccionado = vehiculo;
            break;
        }
    }
    // Agregar el vehículo seleccionado al modelo para mostrarlo en la vista
    model.addAttribute("vehiculo", vehiculoSeleccionado);
    return "mostrar_vehiculo";
    } 

     */


}
