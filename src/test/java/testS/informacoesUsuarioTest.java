package testS;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;

import java.util.concurrent.TimeUnit;

public class informacoesUsuarioTest {
    private WebDriver navegador;
@Rule
public TestName teste = new TestName();
    @Before
    public void setUP() {
        //Abrindo o navegador
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //navegando para a pagina taskit
        navegador.get("http://www.juliodelima.com.br/taskit");
        navegador.manage().window().maximize();
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
        //Clicar em um link que possui a class me
        navegador.findElement(By.className("me")).click();
        //Clicar em um link que tem o texto "More data about you"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

    //@Test
    public void testAdicionarUmaInformacaoAdicionalUsuario() {

        //Clicar no botao através do seu xpath //button[@data-target="addmoredate"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar o popup onde está o formulário de id addmoredata
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //Na combo de name "type" escolhe a opcao "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");
        //No campo de name "contact" digitar "+5511999999999"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("5511999999999");
        //Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();
        //Na mensagem de id "toast-container" validar que o texto é "Your contact has been added"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Your contact has been added", mensagem);
    }
    @Test
    public void removerUmContatoDeUmUsuario() {
        //Clicar no elemento pelo seu xpath //spain[text{}="+55113627406"]/following-sibling::a
        navegador.findElement(By.xpath("//span[contains(text(),\"55113627409\")]/following-sibling::a")).click();
        //Confirmar a janela javascript
        navegador.switchTo().alert().accept();
        //Validar que a mensagem apresentada foi Rest in peace, dear phone!
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Rest in peace, dear phone!", mensagem);
        String screenshotArquivo = "C:\\Users\\Bruna\\IdeaProjects\\Bruna\\Screenshots" + Generator.dataHoraParaArquivo() + teste.getMethodName()+".png";
        Screenshot.tirar(navegador,screenshotArquivo);
        // Aguardar ate 10 segundos para que a janela desapareca
        WebDriverWait aguardar = new WebDriverWait(navegador,10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
        //Fazer logout
        navegador.findElement(By.linkText("Logout")).click();

    }
    @After
    public void tearDown() {
        //Fechar o navegador
        //navegador.quit();
    }


}
