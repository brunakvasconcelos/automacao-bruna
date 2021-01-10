package testS;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class informacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalUsuario(){
       //Abrindo o navegador
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Bruna\\Driver\\chromedriver.exe");
        WebDriver navegador= new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       //navegando para a pagina taskit
          navegador.get("http://www.juliodelima.com.br/taskit");
          // Clicar no link escrito Sing In
           navegador.findElement(By.linkText("Sign in")).click();
           // Identificando o formulario de login
            WebElement formularioSignInbox = navegador.findElement(By.id("signinbox"));
            // Digtar no campo com nome Login que esta dentro do formulario de id "sing inbox" o texto "julio0001"
            formularioSignInbox.findElement(By.name("login")).sendKeys("julio0001");
            // Digtar no campo com nome "password" que esta dentro do formulario de id "sing inbox" o texto "123456"
             formularioSignInbox.findElement(By.name("password")).sendKeys("123456");
            //Clicar no link com o texto "SIGN INBOX"
              navegador.findElement(By.linkText("SIGN IN")).click();
            //Validar que dentro do element com class "me" esta o texto "HI JULIO"
              WebElement me = navegador.findElement(By.className("me"));
              String textoNoElementoMe = me.getText();
              assertEquals("Hi, Julio",textoNoElementoMe);
             //Fechar o navegador
              navegador.quit();

    }
}
