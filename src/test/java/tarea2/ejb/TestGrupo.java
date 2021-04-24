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
				
		try {
			try {
			} catch (GrupoExisteException e) {
				fail("Lanzó excepción al insertar");
			}
		} catch (TrazabilidadException e) {
			throw new RuntimeException(e);
		}
				
		try {
			List<Lote> lotes = gestionLotes.obtenerLotesDeProducto(productoSalchicha);
			assertEquals(1, lotes.size());
			assertEquals(4,lotes.get(0).getLoteIngredientes().size());
			assertEquals("ST1", lotes.get(0).getCodigo());
			assertTrue(BigDecimal.valueOf(10L).compareTo(lotes.get(0).getCantidad())==0);
			assertEquals(Date.valueOf("2021-04-11"), lotes.get(0).getFechaFabricacion());
		} catch (TrazabilidadException e) {
			fail("No debería lanzar excepción");
		}
	}

}
