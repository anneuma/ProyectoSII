package proyctosii.uma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import proyctosii.uma.daos.TitulacionDao;
import proyctosii.uma.models.Titulacion;

import java.util.List;
import java.util.Optional;

@Controller
public class TitulacionController {

    @Autowired
    TitulacionDao titulacionDao;
    @RequestMapping(value="/titulacion")
    public String home(Model model){
        List<Titulacion> list=titulacionDao.findAll();
        model.addAttribute("titulaciones",list);
        return "titulacion";
    }
    @RequestMapping(value="/titulacion/modificar",method = RequestMethod.GET)
    public String modificar(@RequestParam long id, Model model){
        Optional<Titulacion> titulacion=titulacionDao.findById((int)id);
        titulacion.ifPresent(titulacion1 -> model.addAttribute("titulacion",titulacion1));
        return "titulacionModificar";
    }
    @RequestMapping(value="/titulacion/modificar",method = RequestMethod.POST)
    public RedirectView modificarPost(@ModelAttribute Titulacion titulacion){
        titulacionDao.save(titulacion);
        return new RedirectView("/titulacion");
    }
    @RequestMapping(value="/titulacion/borrar")
    public RedirectView borrar(@RequestParam long id){
        Optional<Titulacion> titulacion=titulacionDao.findById((int)id);
        titulacion.ifPresent(titulacion1 -> titulacionDao.delete(titulacion1));
        return new RedirectView("/titulacion");
    }

}

