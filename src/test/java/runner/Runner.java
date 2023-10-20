package runner;


import com.google.common.io.Files;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

import java.time.LocalDateTime;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/java/features",
        glue= "steps",
        plugin = {"pretty","html:target/report.html"},
        monochrome = true

)

public class Runner {

    public static WebDriver driver;

    @BeforeClass
    public static void setupTest(){
        //System.setProperty("webdriver.edge.driver","C:\\Windows\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public static void takeScreenshot(){
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{

            String fileName = LocalDateTime.now().toString().replace(" ", "-")
                    .replace("T", " Time ")
                    .replace(":", "-");

            Files.copy(screenshotFile, new File("src/test/java/screenshots/" +   fileName  + ".jpg"));

        } catch (Exception e){
            System.out.println("Error:  " + e);
        }
    }
    @AfterClass
    public static void stopTest(){
        takeScreenshot();
        driver.quit();
    }
}
