package tarea3.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import tarea1.jpa.Expediente;
import tarea2.ejb.GestionExpediente;
import tarea2.exception.ProyectoException;


@Named(value = "Expedientes")
@RequestScoped
public class expedientes {
    @Inject
    private GestionExpediente expedienteEJB;

    public static enum Modo {
    	ACTUALIZAR,
        NOACCION
    };
    
    private Expediente e;
    private Modo modo;
    
    public expedientes () {
        e = new Expediente();
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
    
    public Expediente getExpediente () {
        return e;
    }

    public void setExpediente (Expediente e) {
        this.e = e;
    }

	public String actualizar (Expediente e) {
        this.e = e;
        setModo(Modo.ACTUALIZAR);
        return "edicionExpediente.xhtml";
    }

    public void eliminar (Expediente ex) {
            try {
				expedienteEJB.eliminarExpediente(ex);
			} catch (ProyectoException e) {
				e.printStackTrace();
			}
    }
    
    public String ejecutarAccion () {
        try {
            switch (modo) {
                case ACTUALIZAR:
                	expedienteEJB.actualizarExpediente(e);
                    break;
            }
            return "expedientes.xhtml";
        } catch (ProyectoException e) {
            return "index.xhtml";
        }
    }
}
