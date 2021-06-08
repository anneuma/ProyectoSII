package tarea3.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import tarea1.jpa.Titulacion;
import tarea2.ejb.GestionTitulacion;
import tarea2.exception.ProyectoException;

@Named(value = "Titulaciones")
@RequestScoped
public class titulaciones {
    @Inject
    private GestionTitulacion titulacionEJB;
	
    public synchronized List<Titulacion> getTitulaciones(){
    	try {
			return titulacionEJB.obtenerListaTitulaciones();
		} catch (ProyectoException e) {
			return null;
		}
    }
}
