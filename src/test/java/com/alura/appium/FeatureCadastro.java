package com.alura.appium;

import static org.junit.Assert.assertTrue;

import com.alura.appium.PageObjects.CadastroPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;


public class FeatureCadastro {

    @Test
    public void cadastro_nao_concluido_senhas_nao_conferem(){
       AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        CadastroPageObject teladeCadastro = new CadastroPageObject(driver);
        teladeCadastro.BuscarElemento();
        teladeCadastro.PreencherForm("jacqueteste", "1234", "4321");
        teladeCadastro.Cadastrar();

        Assert.assertEquals("Senhas não conferem", teladeCadastro.MensagemErro());
        driver.navigate().back();
    }

    @Test
    public void cadastro_fluxo_normal() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        CadastroPageObject teladeCadastro = new CadastroPageObject(driver);
        teladeCadastro.BuscarElemento();
        teladeCadastro.PreencherForm("jacqueteste", "12345", "12345");
        teladeCadastro.Cadastrar();

        //Criar uma Pageobject (pagina de login está na primeira aula das boas práticas)
        MobileElement campoNomeUsuario = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_usuario");
        MobileElement campoSenhaUsuario = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoNomeUsuario.setValue("JacqueTeste2");
        campoSenhaUsuario.setValue("123456");
        MobileElement botaoLogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
                botaoLogar.click();

    }
}