package tarea2.ejb;

import javax.ejb.Local;
import tarea1.jpa.*;
import tarea2.exception.ProyectoException;

@Local
public interface GestionAcceso {
	
	public void validarCuenta(Alumno alumno, String contrasenya) throws ProyectoException;
}
