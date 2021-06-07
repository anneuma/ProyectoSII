package tarea3.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import tarea1.jpa.Grupo;
import tarea2.ejb.GestionGrupo;
import tarea2.exception.GrupoExisteException;
import tarea2.exception.GrupoNoEncontradoException;
import tarea2.exception.ProyectoException;


@Named(value = "Grupos")
@RequestScoped
public class grupos {
    @Inject
    private GestionGrupo grupoEJB;

    public static enum Modo {
    	ACTUALIZAR, 
        INSERTAR,
        NOACCION
    };
    
    private Grupo grupo;
    private Modo modo;
    
    public grupos() {
    	System.out.println("here");
        grupo = new Grupo();
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
            case INSERTAR:
                return "Insertar";

        }
        return null;
    }
    
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String actulizar(Grupo g) {
        grupo = g;
        setModo(Modo.ACTUALIZAR);
        return "edicionGrupo.xhtml";
    }

    public void eliminar(Grupo g) {
            try {
				grupoEJB.eliminarGrupo(g);
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

    public String insertarGrupo() {
        setModo(Modo.INSERTAR);
        return "edicionGrupo.xhtml";
    }
    
    public String ejecutarAccion(){
        try {
            switch (modo) {
                case ACTUALIZAR:
                	grupoEJB.actualizarGrupo(grupo);
                    break;
                case INSERTAR:
                    grupoEJB.insertarGrupo(grupo);
                    break;
            }
            return "grupos.xhtml";
        } catch (ProyectoException e) {
            return "index.xhtml";
        }
    }
    
    public synchronized List<Grupo> getGrupos(){
    	try {
			return grupoEJB.obtenerListaGrupos();
		} catch (ProyectoException e) {
			e.printStackTrace();
		}
		return null;
    }
    //public String refrescar()
    //{
      //  sesion.refrescarUsuario();
       // return null;
    //}
}
