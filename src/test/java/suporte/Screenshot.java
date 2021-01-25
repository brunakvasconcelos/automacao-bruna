package suporte;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;

public class Screenshot {
    public static void tirar(WebDriver navegador, String arquivo){
        File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        try{
            

           org.apache.commons.io.FileUtils.copyFile(screenshot, new File(arquivo));

        }catch (Exception e){
            System.out.printf("Houveram problemas ao copiar o arquivo para a pasta:" + e.getMessage());
        }

    }
}
