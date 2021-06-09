package proyctosii.uma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import proyctosii.uma.daos.AlumnosDao;
import proyctosii.uma.models.Alumno;
import proyctosii.uma.models.Titulacion;

import java.util.List;
import java.util.Optional;

@Controller
public class AlumnoController {
    @Autowired
    AlumnosDao alumnosDao;
    @RequestMapping(value="/alumnos")
    public String index(Model model){
        List<Alumno> alumnos=alumnosDao.findAll();
        model.addAttribute("alumnos",alumnos);
        return "alumnos";
    }

    @RequestMapping(value="/alumnos/modificar",method = RequestMethod.GET)
    private String modificar(@RequestParam int id, Model model){
        Optional<Alumno> alumno= alumnosDao.findById(id);
        alumno.ifPresent(value -> model.addAttribute("alumno", value));
        return "alumninoModificar";
    }

    @RequestMapping(value="/alumnos/modificar",method = RequestMethod.POST)
    private RedirectView modificarPost(@ModelAttribute("alumno") Alumno alumno){
        alumnosDao.save(alumno);
        return new RedirectView("/alumnos");
    }

    @RequestMapping(value="/alumnos/borrar")
    public RedirectView borrar(@RequestParam long id){
        Optional<Alumno> alumno=alumnosDao.findById((int)id);
        alumno.ifPresent(alumno1 -> alumnosDao.delete(alumno1));
        return new RedirectView("/alumnos");
    }

}
