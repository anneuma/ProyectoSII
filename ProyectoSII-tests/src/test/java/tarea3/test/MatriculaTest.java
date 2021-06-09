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
public class MatriculaTest {
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
	
	@Requisitos({"RF-003"})
	@Test
	public void ActualizarAsignatura () {
		driver.get("http://0.0.0.0:8080/ProyectoSII-war/faces/matricula.xhtml");
		driver.manage().window().setSize(new Dimension(908, 760));
		driver.findElement(By.name("matricula:j_idt20:0:j_idt42")).click();
		driver.findElement(By.cssSelector("option:nth-child(2)")).click();
		driver.findElement(By.id("matricula:id")).clear();
		driver.findElement(By.id("matricula:id")).sendKeys("100200007");
		driver.findElement(By.id("matricula:curso_academico")).clear();
		driver.findElement(By.id("matricula:curso_academico")).sendKeys("Primero");
		driver.findElement(By.id("matricula:estado")).clear();
		driver.findElement(By.id("matricula:estado")).sendKeys("1");
		driver.findElement(By.id("matricula:num_archivo")).clear();
		driver.findElement(By.id("matricula:num_archivo")).sendKeys("102564785");
		driver.findElement(By.id("matricula:turno_preferente")).clear();
		driver.findElement(By.id("matricula:turno_preferente")).sendKeys("Mañana");
		driver.findElement(By.id("matricula:fecha_matricula")).clear();
		driver.findElement(By.id("matricula:fecha_matricula")).sendKeys("10/09/2017");
		driver.findElement(By.id("matricula:nuevo_ingreso")).clear();
		driver.findElement(By.id("matricula:nuevo_ingreso")).sendKeys("True");
		driver.findElement(By.id("matricula:accion")).click();
		assertThat(driver.findElement(By.id("matricula:id")).getText(), is("100200007"));
		assertThat(driver.findElement(By.id("matricula:curso_academico")).getText(), is("Primero"));
		assertThat(driver.findElement(By.id("matricula:estado")).getText(), is("1"));
		assertThat(driver.findElement(By.id("matricula:num_archivo")).getText(), is("102564785"));
		assertThat(driver.findElement(By.id("matricula:turno_preferente")).getText(), is("Mañana"));
		assertThat(driver.findElement(By.id("matricula:fecha_matricula")).getText(), is("10/09/2017"));
		assertThat(driver.findElement(By.id("matricula:nuevo_ingreso")).getText(), is("True"));

	}
	
	@Requisitos({"RF-003"})
	@Test
	public void EliminarMatricula() {
		driver.get("http://0.0.0.0:8080/ProyectoSII-war/faces/matricula.xhtml");
		driver.manage().window().setSize(new Dimension(908, 760));
		driver.findElement(By.id("matricula:j_idt24:2:eliminar")).click();
		{
			List<WebElement> elements = driver.findElements(By.xpath("//form[@id=\'matricula\']/table/tbody/tr[3]/td"));
			assert(elements.size() == 0);
		}
	}
}