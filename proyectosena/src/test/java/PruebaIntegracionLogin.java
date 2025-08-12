import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PruebaIntegracionLogin {

    @Test
    public void loginMiprimerProyectoPrueba() throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try{
            driver.get("http://localhost:8080/login");

            WebElement correo = driver.findElement(By.name("username"));
            WebElement password = driver.findElement(By.name("password"));

            correo.sendKeys("sebas@sebas.com");
            password.sendKeys("sebas");

            WebElement boton = driver.findElement(By.cssSelector("input[type='submit']"));
            boton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sidebar")));
            } catch (Exception e) {
            System.out.println("No se encontró el elemento con ID 'sidebar'");
            e.printStackTrace();
            }

            String currentUrl = driver.getCurrentUrl();
            System.out.println("URL actual después del login: " + currentUrl);
            if (currentUrl.contains("/error")) {
            WebElement errorBody = driver.findElement(By.tagName("body"));
            System.out.println("Contenido del error:\n" + errorBody.getText());
}

            assertTrue(currentUrl.contains("/home"), "no redirigio al index");

        }finally{
            driver.quit();
        }

    }
}
