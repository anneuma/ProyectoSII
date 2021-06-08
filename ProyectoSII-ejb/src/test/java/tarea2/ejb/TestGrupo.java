package tarea2.ejb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.anotaciones.Requisitos;
import tarea1.jpa.*;
import tarea2.exception.*;


public class TestGrupo {
	
	private static final Logger LOG = Logger.getLogger(TestGrupo.class.getCanonicalName());

	private static final String GRUPO_EJB = "java:global/classes/GrupoEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "ProyectoSII_Test";

	private GestionGrupo gestionGrupo;

	@Before
	public void setup() throws NamingException, ParseException  {
		gestionGrupo = (GestionGrupo) SuiteTest.ctx.lookup(GRUPO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Requisitos({"RF8"})
	@Test
	public void testGrupoExistente() {
		
			Grupo grupo1A = new Grupo((long) 1, "primero", "A", "mañana", false, true, true, (long) 42);
			Titulacion informatica = new Titulacion((long) 1, "Ingenieria Informática",240);
			try {
				gestionGrupo.insertarGrupo(grupo1A, (long) 1);
			} catch (GrupoExisteException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de grupo existente"); 
			}
	}
	@Requisitos({"RF8"})
	@Test
	public void testActualizarGrupoTitulacionNoencontrada() {
				
			try {
				Grupo grupo1A = new Grupo((long) 1, "primero", "A", "mañana", false, true, true, (long) 42);
				Titulacion informatica = new Titulacion((long) 1, "Ingenieria Informática",240);
				gestionGrupo.actualizarGrupoTitulacion(grupo1A, (long) 1);
			} catch (GrupoNoEncontradoException|TitulacionNoEncontradaException e) {
				//OK
			} catch (ProyectoException e) {
				fail("Debe lanzar excepción de titulacion no encontrada"); 
			}
	}
	
	@Requisitos({"RF8"})
	@Test
	public void testEliminarGrupoNoEncontrado() {
		try {
			Grupo grupo3A = new Grupo((long) 3, "tercero", "A", "mañana", false, true, true, (long) 42);
			
			gestionGrupo.eliminarGrupo(grupo3A);

			fail("Debería lanzar la excepción de grupo no encontrado");
		} catch (GrupoNoEncontradoException e) {
			// OK
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de grupo no encontrado");
		}
	}
	
	@Requisitos({"RF8"})
	@Test
	public void testActualizarGrupoNoEncontrado() {
		try {
			Grupo grupo3A = new Grupo((long) 3, "tercero", "A", "mañana", false, true, true, (long) 42);

			gestionGrupo.actualizarGrupo(grupo3A);

		} catch (GrupoNoEncontradoException e){
			//OK
		} catch (ProyectoException e) {
			fail("Debería lanzar la excepción de grupo no encontrado");
		}
	}
	
	@Requisitos({"RF09"})
	@Test
	public void testAsignarMatriculaNoEncontrada() {
		try {
			Matricula matricula = new Matricula();
			gestionGrupo.asignarGrupo(matricula);
		} catch (MatriculaNoEncontradaException e) {
			//OK
		} catch (ProyectoException e) {
			fail("Debería lanzar la exceptión de matricula no encontrada");
		}
	}
	
	@Requisitos({"RF09"})
	@Test
	public void testAsignarGrupo() throws ParseException {
		try {
			SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = (Date) dateformat3.parse("22/09/2020");
			Matricula matr1 = new Matricula((long) 00001, "2020/2021", "Activa", (long) 306000001, "Mañana", date1, false, "101-,102-,105");
			List<Asignaturas_matricula> list_asig = new ArrayList<>();
			for(long i = 0; i< 10; i++) {
				Asignaturas_matricula asig = new Asignaturas_matricula(i, 0);
				list_asig.add(asig);
			}
			matr1.setAsignaturas_matricula(list_asig);
			gestionGrupo.asignarGrupo(matr1);
			Grupo grupo1A = new Grupo((long) 1, "primero", "A", "mañana", false, true, true, (long) 42);
			List<Asignaturas_matricula> list_asig_matr1 = matr1.getAsignaturas_matricula();
			for(Asignaturas_matricula lam :list_asig_matr1) {
				assertEquals(grupo1A, lam.getGrupo());
			}
		} catch (MatriculaNoEncontradaException e) {
			fail("No debería lanzar la excepción de matricula no encontrada");
		} catch (ProyectoException e) {
			fail("No debería lanzar excepción");
		}
	}
}
