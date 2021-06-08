package tarea3.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import tarea1.jpa.Asignatura;
import tarea2.ejb.GestionAsignatura;
import tarea2.exception.ProyectoException;


@Named(value = "Asignaturas")
@RequestScoped
public class asignaturas {
    @Inject
    private GestionAsignatura asignaturaEJB;

    public static enum Modo {
    	ACTUALIZAR,
        NOACCION
    };
    
    private Asignatura asi;
    private Modo modo;
    
    public asignaturas () {
        asi = new Asignatura();
        modo = Modo.NOACCION;
    }

    public Modo getModo () {
        return modo;
    }

    public void setModo (Modo modo) {
        this.modo = modo;
    }

    public String getAccion () {
        switch (modo) {
            case ACTUALIZAR:
                return "Actualizar";
        }
        return null;
    }
    
    public Asignatura getAsignatura () {
        return asi;
    }

    public void setAsignatura (Asignatura asi) {
        this.asi = asi;
    }

	public String actualizar (Asignatura asi) {
        this.asi = asi;
        setModo(Modo.ACTUALIZAR);
        return "edicionAsignatura.xhtml";
    }

    public void eliminar (Asignatura asi) {
            try {
				asignaturaEJB.eliminarAsignatura(asi);
			} catch (ProyectoException e) {
				e.printStackTrace();
			}
    }
    
    public String ejecutarAccion () {
        try {
            switch (modo) {
                case ACTUALIZAR:
                	asignaturaEJB.actualizarAsignatura(asi);
                    break;
            }
            return "asignaturas.xhtml";
        } catch (ProyectoException e) {
            return "index.xhtml";
        }
    }
}
