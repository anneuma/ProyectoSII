package tarea3.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import tarea1.jpa.Matricula;
import tarea1.jpa.Expediente;
import tarea2.ejb.GestionMatricula;
import tarea2.ejb.GestionExpediente;
import tarea2.exception.MatriculaExisteException;
import tarea2.exception.MatriculaNoEncontradaException;
import tarea2.exception.ProyectoException;


@Named(value = "Matriculas")
@RequestScoped
public class matriculas {
    @Inject
    private GestionMatricula matriculaEJB;

    public static enum Modo {
    	ACTUALIZAR, 
        NOACCION
    };
    
    private Matricula matr;
    private Modo modo;
    
    private Long idexpediente;
    private Expediente expediente;
    
    public matriculas() {
        matr = new Matricula();
        modo = Modo.NOACCION;
    }

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public String getAccion() {
        switch (modo) {
            case ACTUALIZAR:
                return "Actualizar";
        }
        return null;
    }
    
    public Matricula getMatricula() {
        return matr;
    }

    public void setMatricula(Matricula matricula) {
        this.matr = matricula;
    }

	public Long getIDexpediente() {
		return idexpediente;
	}

	public void setIDexpediente(Long id) {
		this.idexpediente = id;
	}

	public String actualizar(Matricula m, Long x) {
        matr = m;
        idexpediente = x;
        setModo(Modo.ACTUALIZAR);
        return "edicionMatricula.xhtml";
    }

    public void eliminar(Matricula matricula) {
            try {
				matriculaEJB.eliminarMatricula(matricula);
			} catch (ProyectoException e) {
				e.printStackTrace();
			}
            // Refrescar el usuario
          //  sesion.refrescarUsuario();
        //} catch (AgendaException e) {
          //  return "login.xhtml";
        //}
        //return null;
    }

    
    public String ejecutarAccion(){
        try {
            switch (modo) {
                case ACTUALIZAR:
                	matriculaEJB.actualizarMatricula(matr);
                    break;
            }
            return "matriculas.xhtml";
        } catch (ProyectoException e) {
            return "index.xhtml";
        }
    }
    
    public Expediente getExpediente() {
    	try {
			return matriculaEJB.obtenerExpedientes(matr);
		} catch (ProyectoException e) {
			return null;
		}
    }
    
	public void setExpediente(Expediente ex) {
		this.expediente = ex;
	}

    
    //public String refrescar()
    //{
      //  sesion.refrescarUsuario();
       // return null;
    //}
}
