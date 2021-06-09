package tarea3.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import tarea1.jpa.Alumno;

import tarea2.ejb.GestionAlumno;

import tarea2.exception.AlumnoExisteException;
import tarea2.exception.AlumnoNoEncontradoException;
import tarea2.exception.ProyectoException;


@Named(value = "Alumnos")
@RequestScoped
public class alumnos {
    @Inject
    private GestionAlumno alumnoEJB;

    public static enum Modo {
    	ACTUALIZAR,
        NOACCION
    };
    
    private Alumno alumno;
    private Modo modo;

    public alumnos() {
        alumno = new Alumno();
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
    
    public Alumno getAlumno() {
        return alumno;
    }

    public void setGrupo(Alumno alumno) {
        this.alumno = alumno;
    }


	public String actualizar(Alumno al) {
        alumno = al;
        setModo(Modo.ACTUALIZAR);
        return "edicionAlumno.xhtml";
    }

    public void eliminar(Alumno al) {
            try {
				alumnoEJB.eliminarAlumno(al);
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
                	alumnoEJB.actualizarAlumno(alumno);
                    break;
            }
            return "alumnos.xhtml";
        } catch (ProyectoException e) {
            return "index.xhtml";
        }
    }
    
    
    //public String refrescar()
    //{
      //  sesion.refrescarUsuario();
       // return null;
    //}
}
