package tarea2.ejb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import tarea1.jpa.*;
import tarea2.exception.*;


public class TestGrupo {
	
	private static final Logger LOG = Logger.getLogger(TestGrupo.class.getCanonicalName());

	private static final String GRUPO_EJB = "java:global/classes/GrupoEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "ProyectoSII_Test";

	private GestionGrupo gestionGrupo;

	@Before
	public void setup() throws NamingException  {
		gestionGrupo = (GestionGrupo) SuiteTest.ctx.lookup(GRUPO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testGrupoExistente() {
		
			Grupo grupo1A = new Grupo((long) 1, "primero", "A", "mañana", false, true, true, (long) 42);
			try {
				gestionGrupo.insertarGrupo(grupo1A);
			} catch (GrupoExisteException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de grupo existente"); 
			}
	}
	
	@Test
	public void testActualizarGrupoTitulacion() {
				
			try {
				Grupo grupo1A = new Grupo((long) 1, "primero", "A", "mañana", false, true, true, (long) 42);
				Titulacion informatica = new Titulacion((long) 1, "Ingenieria Informática",240);
				gestionGrupo.actualizarGrupoTitulacion(grupo1A, informatica);
			} catch (GrupoNoEncontradoException|TitulacionNoEncontradaException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de titulacion no encontrada"); 
			}
	}

}
