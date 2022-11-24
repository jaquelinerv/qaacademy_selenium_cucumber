package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CadastroPage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginStep {
    WebDriver driver;
    ChromeOptions options;
    LoginPage loginPage;
    CadastroPage cadastroPage;

    @Before
    public void before() {
        options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Dado("que eu esteja na pagina inicial:{string}")
    public void queEstejaNaPaginaInicial(String url) {
        driver.get(url);
    }

/*    @E("possua um cadastro")
    public void possuoCadastro(){
        cadastroPage.clicarBotaoRegistrar();
        cadastroPage.preencherEmail("teste@teste.com");
        cadastroPage.preencherNome("Emerson");
        cadastroPage.preencherSenha("123456");
        cadastroPage.preencherConfirmacaoSenha("123456");
        cadastroPage.selecionaSaldo();
        cadastroPage.clicaBotaoCadastrar();
        cadastroPage.clicaBotaoFecharContaCriada();
    }*/

    @E("possua um cadastro com os dados")
    public void possuoCadastroDataTable(List<Map<String, String>> dataTable) {
        String email = dataTable.get(0).get("Email");
        String nome = dataTable.get(0).get("Nome");
        String senha = dataTable.get(0).get("Senha");
        String confirmacao = dataTable.get(0).get("Confirmacao");

        cadastroPage.clicarBotaoRegistrar();
        cadastroPage.preencherEmail(email);
        cadastroPage.preencherNome(nome);
        cadastroPage.preencherSenha(senha);
        cadastroPage.preencherConfirmacaoSenha(confirmacao);
        cadastroPage.selecionaSaldo();
        cadastroPage.clicaBotaoCadastrar();
        cadastroPage.clicaBotaoFecharContaCriada();
    }

    @Quando("eu preencher email:{string} e senha:{string}")
    public void preencherEmailESenha(String email, String senha) {
        loginPage.preencheLoginEmail(email);
        loginPage.preencheSenha(senha);
    }

    @E("clicar em fazer login")
    public void clicarLogin() {
        loginPage.clicarBotaoAcessar();
    }

    @Entao("valido que a pagina de boas vindas foi carregada")
    public void validarPaginaBoasVindas() {
        String url = "http://localhost:3000/home";
        new WebDriverWait(driver, 5000).until(ExpectedConditions.urlToBe(url));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

}
