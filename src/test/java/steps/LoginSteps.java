package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import runner.Runner;
import utils.Utils;


public class LoginSteps extends Runner {


    LoginPage loginPage = new LoginPage(driver);

    @Given("que acesso o sauce demo")
    public void que_acesso_o_sauce_demo() {
      loginPage.acessarSiteSauceDemo();
    }

    @When("digito {string} e senha")
    public void digitoESenha(String usuario) {
        loginPage.logar(usuario);

    }

    @And("clico em login")
    public void clicoEmLogin() {
        loginPage.cliqueLogin();
    }

    @Then("acesso a página de produtos com sucesso")
    public void acessoAPáginaDeProdutosComSucesso() {
        loginPage.validaAcessoNaPaginaDeProdutos();
    }

    @Then("valido a mensagem {string} em tela")
    public void validoAMensagemEmTela(String mensagem) {
        loginPage.validaUsuarioBloqueado(mensagem);
    }
}
