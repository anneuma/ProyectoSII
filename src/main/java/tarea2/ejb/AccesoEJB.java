package tarea2.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tarea1.jpa.*;
import tarea2.exception.*;

@Stateless
public class AccesoEJB implements GestionAcceso {
	@PersistenceContext(name = "ProyectoSII")
    private EntityManager em;
	
	public void validarCuenta(Alumno alumno, String contrasenya) throws CorreoNoEncontradoException, ContrasenyaIncorrectaException {
        Alumno alumnoEntity = em.find(Alumno.class, alumno.getEmail_i());
        if (alumnoEntity == null) {
            throw new CorreoNoEncontradoException();
        }

        if (alumnoEntity.getEmail_i() == null) {
            // la cuenta ya está activa
            return;
        }

        if (!alumnoEntity.getEmail_i().equals(contrasenya)) {
            throw new ContrasenyaIncorrectaException();
        }
    }
}
