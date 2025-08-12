package com.miproyectosena.proyectosena;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PruebaIntegracionProducto {
    @Test
    public void testRegistroProductoCompleto() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("http://localhost:8080/login");

            WebElement email = driver.findElement(By.name("username"));
            WebElement pass = driver.findElement(By.name("password"));
            email.sendKeys("simon@simon.com");
            pass.sendKeys("simon");

            WebElement botonLogin = driver.findElement(By.cssSelector("input[type='submit']"));
            botonLogin.click();

            // Esperar redirección al home
            Thread.sleep(2000);

            //Acceder a la página de registro de productos
            driver.get("http://localhost:8080/producto/nuevo");

            //Llenar el formulario
            WebElement nombre = driver.findElement(By.name("nombreProducto"));
            nombre.sendKeys("Producto de prueba desde Selenium");

            Select categoria = new Select(driver.findElement(By.name("categoria_id")));
            categoria.selectByVisibleText("Tecnologia"); // O cualquier otra que exista

            WebElement fileInput = driver.findElement(By.name("imagen"));
            File file = new File("C:\\Users\\Julian\\OneDrive\\Escritorio\\test-image.jpg"); // Asegúrate de que este archivo exista
            fileInput.sendKeys(file.getAbsolutePath());

            WebElement descripcion = driver.findElement(By.id("descripcionProducto"));
            descripcion.sendKeys("Este es un producto de prueba automático con más de 70 caracteres para cumplir los requisitos.");
             List<WebElement> pagos = driver.findElements(By.name("pagoSeleccionado"));
            if (!pagos.isEmpty()) {
                pagos.get(0).click();
            }

            WebElement costo = driver.findElement(By.name("costoProducto"));
            costo.sendKeys("50000");

            //Enviar el formulario
            WebElement botonSubmit = driver.findElement(By.cssSelector("button[type='submit']"));
            botonSubmit.click();

            //Verificar que redirige a página con éxito
            Thread.sleep(3000);
            String currentUrl = driver.getCurrentUrl();
            System.out.println("URL después del registro: " + currentUrl);

            assertTrue(currentUrl.contains("/producto/nuevo?exito=true"), "No redirigió a la URL esperada con éxito");
             } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            driver.quit();
        }
    }


}
