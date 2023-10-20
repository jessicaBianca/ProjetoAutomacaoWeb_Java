package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import properties.PropertiesLoad;
import utils.Utils;

public class LoginPage {


    WebDriver driver;
    PropertiesLoad props = new PropertiesLoad("src/test/resources/users.properties");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    Utils utils = new Utils();
    public void acessarSiteSauceDemo() {
        driver.get("https://www.saucedemo.com/v1/");
        utils.validaTitulo("Swag Labs");
    }

    public void logar(String usuario) {

        switch (usuario){
            case "standard_user":
                driver.findElement(By.id("user-name")).sendKeys(props.getProps().getProperty("standard_user"));
                driver.findElement(By.id("password")).sendKeys(props.getProps().getProperty("password"));
                break;
            case "locked_user":
                driver.findElement(By.id("user-name")).sendKeys(props.getProps().getProperty("locked_user"));
                driver.findElement(By.id("password")).sendKeys(props.getProps().getProperty("password"));
                break;
            case "problem_user":
                driver.findElement(By.id("user-name")).sendKeys(props.getProps().getProperty("problem_user"));
                driver.findElement(By.id("password")).sendKeys(props.getProps().getProperty("password"));
                break;
            case "performance_user":
                driver.findElement(By.id("user-name")).sendKeys(props.getProps().getProperty("performance_user"));
                driver.findElement(By.id("password")).sendKeys(props.getProps().getProperty("password"));
                break;

        }

    }

    public void cliqueLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    public void validaAcessoNaPaginaDeProdutos() {
        driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed();

    }

    public void validaUsuarioBloqueado(String mensagem) {
        String mensagemEmTela = driver.findElement(By.xpath("//h3[contains(.,'Sorry, this user has been locked out.')]")).getText();
        Assert.assertEquals(mensagem, mensagemEmTela);
    }
}
