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
public class AlumnosTest {
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
	
	@Requisitos({"RF-007"})
	@Test
	public void ActualizarAsignatura () {
		driver.get("http://0.0.0.0:8080/ProyectoSII-war/faces/alumnos.xhtml");
		driver.manage().window().setSize(new Dimension(908, 760));
		driver.findElement(By.name("alumno:j_idt20:0:j_idt42")).click();
		driver.findElement(By.cssSelector("option:nth-child(2)")).click();
		driver.findElement(By.id("alumno:id")).clear();
		driver.findElement(By.id("alumno:id")).sendKeys("0507854");
		driver.findElement(By.id("alumno:dni")).clear();
		driver.findElement(By.id("alumno:dni")).sendKeys("45635218A");
		driver.findElement(By.id("alumno:nombre")).clear();
		driver.findElement(By.id("alumno:nombre")).sendKeys("Alicia");
		driver.findElement(By.id("alumno:apellido1")).clear();
		driver.findElement(By.id("alumno:apellido1")).sendKeys("Alonso");
		driver.findElement(By.id("alumno:apellido2")).clear();
		driver.findElement(By.id("alumno:apellido2")).sendKeys("Alonso");
		driver.findElement(By.id("alumno:email_i")).clear();
		driver.findElement(By.id("alumno:email_i")).sendKeys("aliciaalonso2@emilio.com");
		driver.findElement(By.id("alumno:email_p")).clear();
		driver.findElement(By.id("alumno:email_p")).sendKeys("aliciaalonso245@emilio.com");
		driver.findElement(By.id("alumno:telefono")).clear();
		driver.findElement(By.id("alumno:telefono")).sendKeys("900030507");
		driver.findElement(By.id("alumno:movil")).clear();
		driver.findElement(By.id("alumno:movil")).sendKeys("600010307");
		driver.findElement(By.id("alumno:direccion")).clear();
		driver.findElement(By.id("alumno:direccion")).sendKeys("Calle Arriba, Numero 3");
		driver.findElement(By.id("alumno:localidad")).clear();
		driver.findElement(By.id("alumno:localidad")).sendKeys("Málaga");
		driver.findElement(By.id("alumno:provincia")).clear();
		driver.findElement(By.id("alumno:provincia")).sendKeys("Málaga");
		driver.findElement(By.id("alumno:accion")).click();
		assertThat(driver.findElement(By.id("alumno:id")).getText(), is("0507854"));
		assertThat(driver.findElement(By.id("alumno:dni")).getText(), is("45635218A"));
		assertThat(driver.findElement(By.id("alumno:nombre")).getText(), is("Alicia"));
		assertThat(driver.findElement(By.id("alumno:apellido1")).getText(), is("Alonso"));
		assertThat(driver.findElement(By.id("alumno:apellido2")).getText(), is("Alonso"));
		assertThat(driver.findElement(By.id("alumno:email_i")).getText(), is("aliciaalonso2@emilio.com"));
		assertThat(driver.findElement(By.id("alumno:email_p")).getText(), is("aliciaalonso245@emilio.com"));
		assertThat(driver.findElement(By.id("alumno:telefono")).getText(), is("900030507"));
		assertThat(driver.findElement(By.id("alumno:movil")).getText(), is("600010307"));
		assertThat(driver.findElement(By.id("alumno:direccion")).getText(), is("Calle Arriba, Numero 3"));
		assertThat(driver.findElement(By.id("alumno:localidad")).getText(), is("Málaga"));
		assertThat(driver.findElement(By.id("alumno:provincia")).getText(), is("Málaga"));

	}
	
	@Requisitos({"RF-007"})
	@Test
	public void EliminarMatricula() {
		driver.get("http://0.0.0.0:8080/ProyectoSII-war/faces/alumnos.xhtml");
		driver.manage().window().setSize(new Dimension(908, 760));
		driver.findElement(By.id("matricula:j_idt24:2:eliminar")).click();
		{
			List<WebElement> elements = driver.findElements(By.xpath("//form[@id=\'matricula\']/table/tbody/tr[3]/td"));
			assert(elements.size() == 0);
		}
	}
}