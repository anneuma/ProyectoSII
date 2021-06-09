package tarea3.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import org.junit.runners.MethodSorters;
import es.uma.informatica.sii.anotaciones.Requisitos;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AsignaturaTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	@Before
	public void setUp () {
		driver = new FirefoxDriver();
    	js = (JavascriptExecutor) driver;
    	vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown () {
		driver.quit();
	}
	
	@Requisitos({"RF-004"})
	@Test
	public void ActualizarAsignatura () {
		driver.get("http://0.0.0.0:8080/ProyectoSII-war/faces/asignatura.xhtml");
		driver.manage().window().setSize(new Dimension(908, 760));
		driver.findElement(By.name("asignatura:j_idt20:0:j_idt42")).click();
		driver.findElement(By.cssSelector("option:nth-child(2)")).click();
		driver.findElement(By.id("asignaturas:codigo")).clear();
		driver.findElement(By.id("asignaturas:codigo")).sendKeys("3104");
		driver.findElement(By.id("asignaturas:creditos_totales")).clear();
		driver.findElement(By.id("asignaturas:creditos_totales")).sendKeys("6");
		driver.findElement(By.id("asignaturas:creditos_practicos")).clear();
		driver.findElement(By.id("asignaturas:creditos_practicos")).sendKeys("4");
		driver.findElement(By.id("asignaturas:creditos_teoricos")).clear();
		driver.findElement(By.id("asignaturas:creditos_teoricos")).sendKeys("2");
		driver.findElement(By.id("asignaturas:oferta")).clear();
		driver.findElement(By.id("asignaturas:oferta")).sendKeys(null);
		driver.findElement(By.id("asignaturas:nombre")).clear();
		driver.findElement(By.id("asignaturas:nombre")).sendKeys("Sistemas de Información para Internet");
		driver.findElement(By.id("asignaturas:curso")).clear();
		driver.findElement(By.id("asignaturas:curso")).sendKeys("3");
		driver.findElement(By.id("asignaturas:caracter")).clear();
		driver.findElement(By.id("asignaturas:caracter")).sendKeys("Obligatoria");
		driver.findElement(By.id("asignaturas:duracion")).clear();
		driver.findElement(By.id("asignaturas:duracion")).sendKeys("90");
		driver.findElement(By.id("asignaturas:unidad_temporal")).clear();
		driver.findElement(By.id("asignaturas:unidad_temporal")).sendKeys("2");
		driver.findElement(By.id("asignaturas:idiomas")).clear();
		driver.findElement(By.id("asignaturas:idiomas")).sendKeys(null);
		driver.findElement(By.id("asignaturas:accion")).click();
		assertThat(driver.findElement(By.id("asignaturas:codigo")).getText(), is("3104"));
		assertThat(driver.findElement(By.id("asignaturas:creditos_totales")).getText(), is("6"));
		assertThat(driver.findElement(By.id("asignaturas:creditos_practicos")).getText(), is("4"));
		assertThat(driver.findElement(By.id("asignaturas:creditos_teoricos")).getText(), is("2"));
		assertThat(driver.findElement(By.id("asignaturas:oferta")).getText(), is(""));
		assertThat(driver.findElement(By.id("asignaturas:nombre")).getText(), is("Sistemas de Información para Internet"));
		assertThat(driver.findElement(By.id("asignaturas:curso")).getText(), is("3"));
		assertThat(driver.findElement(By.id("asignaturas:caracter")).getText(), is("Obligatoria"));
		assertThat(driver.findElement(By.id("asignaturas:duracion")).getText(), is("90"));
		assertThat(driver.findElement(By.id("asignaturas:unidad_temporal")).getText(), is("2"));
		assertThat(driver.findElement(By.id("asignaturas:idiomas")).getText(), is(""));
	}
	
	@Requisitos({"RF-004"})
	@Test
	public void EliminarAsignatura() {
		driver.get("http://0.0.0.0:8080/ProyectoSII-war/faces/asignatura.xhtml");
		driver.manage().window().setSize(new Dimension(908, 760));
		driver.findElement(By.id("asignaturas:j_idt24:2:eliminar")).click();
		{
			List<WebElement> elements = driver.findElements(By.xpath("//form[@id=\'asignaturas\']/table/tbody/tr[3]/td"));
			assert(elements.size() == 0);
		}
	}
}
