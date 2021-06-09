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
public class ExpedienteTest {
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
	
	@Requisitos({"RF-006"})
	@Test
	public void ActualizarExpediente () {
		driver.get("http://0.0.0.0:8080/ProyectoSII-war/faces/expediente.xhtml");
		driver.manage().window().setSize(new Dimension(908, 760));
		 driver.findElement(By.id("asignatura:j_idt24:0:actualizar")).click();
		driver.findElement(By.cssSelector("option:nth-child(2)")).click();
		driver.findElement(By.id("expedientes:num_expediente")).clear();
		driver.findElement(By.id("expedientes:num_expediente")).sendKeys("104300013");
		driver.findElement(By.id("expedientes:activo")).clear();
		driver.findElement(By.id("expedientes:activo")).sendKeys("true");
		driver.findElement(By.id("expedientes:nota_media_provisional")).clear();
		driver.findElement(By.id("expedientes:nota_media_provisional")).sendKeys("6.2");
		driver.findElement(By.id("expedientes:accion")).click();
		assertThat(driver.findElement(By.id("expedientes:j_idt24:0:num_expediente")).getText(), is("104300013"));
		assertThat(driver.findElement(By.id("expedientes:j_idt24:0:activo")).getText(), is("true"));
		assertThat(driver.findElement(By.id("expedientes:j_idt24:0:nota_media_provisional")).getText(), is("6.2"));
	}
	
	@Requisitos({"RF-006"})
	@Test
	public void EliminarExpediente() {
		driver.get("http://0.0.0.0:8080/ProyectoSII-war/faces/expediente.xhtml");
		driver.manage().window().setSize(new Dimension(908, 760));
		driver.findElement(By.id("expedientes:j_idt24:2:eliminar")).click();
		{
			List<WebElement> elements = driver.findElements(By.xpath("//form[@id=\'expedientes\']/table/tbody/tr[3]/td"));
			assert(elements.size() == 0);
		}
	}
}
