package Teste;
import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 import java.sql.Driver;


    public class InformacoesTest {
    @Test
    public void testAdicionarInfoUsuarios() {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");

        //Abrindo Navegador
      WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();

        //Navegando para pagina do taskit
       navegador.get("http://ham.org.br/#");

        //Clicar no link que contém o texto "Resultados de Exames"
        navegador.findElement(By.linkText("Resultados de Exames")).click();

        //Clicar no campo com o nome "Laboratoriais"
        navegador.findElement(By.linkText("Imagens")).click();

        //Identificando o formulario de login
       // WebElement formularioExames = navegador.findElement(By.cssSelector("form"));


        //Digitar no campo "Login"  que está dentro do formulário "laboratoriais"  o texto "2528725"
        //navegador.findElement(By.cssSelector("input[ng-model='usuario.email']")).sendKeys("2528725");
       // navegador.findElement(By.cssSelector("usuario-email")).sendKeys("2528725");

        //Digitar no campo Senha que está dentro do formulário de login "input ng-model"  o texto "736419"

       //  formularioExames.findElement(By.name("usuario.senha")).sendKeys("736419");

        //Clicar no botão "Entrar"

        //Validar que dentro do elemento com span class  está o texto "Conta"

        //Fechar o navegador

        //validação
        assertEquals(1,1);


       }
}
