package com.itacademy.ticder.web.application;

import com.itacademy.ticder.business.service.AlumneService;
import com.itacademy.ticder.data.entity.Alumne;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlumneController {
    
    @Autowired
    private AlumneService alumneService;
    
    @RequestMapping(value="/mostrarAlumnes", method=RequestMethod.GET)
    public String getAlumnes(Model model) {
        List<Alumne> alumneList = this.alumneService.getAlumnes();
        model.addAttribute("alumneList", alumneList);
        return "alumnes";
    }
    
    @GetMapping(value="/afegirAlumne")
    public String addAlumneForm(Model model) {
        model.addAttribute( "alumne", new Alumne());
        return "afegirAlumneForm";
    }
    
    @PostMapping(value="/afegirAlumne")
    public String addAlumneSubmit(@ModelAttribute Alumne alumne, Model model) {
        this.alumneService.addAlumne(alumne);
        List<Alumne> alumneList = this.alumneService.getAlumnes();
        model.addAttribute("alumneList", alumneList);
        return "alumnes";
    }
    
    @RequestMapping(value="/esborrarAlumne/{id}", method=RequestMethod.GET)
    public String deleteAlumne(@PathVariable long id, Model model) {
        if (this.alumneService.findById(id) != null) {
            this.alumneService.deleteAlumne(id);
            model.addAttribute("id", id);
            model.addAttribute("error", "");
        }
        else {
            model.addAttribute("error", "No s'ha trobat l'alumne amb id " + id);
        }
        
        return "esborrarAlumne";
    }
    
    @RequestMapping(value="/aparellar", method=RequestMethod.GET)
    public String agrupaAlumnes(Model model) {
        List<List> grups = this.alumneService.agrupaAlumnes();
        model.addAttribute("grups", grups);
        return "grups";
    }
}
