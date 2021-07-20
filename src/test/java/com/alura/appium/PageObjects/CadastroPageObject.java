package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import javafx.scene.input.InputMethodTextRun;

public class CadastroPageObject {

    private AppiumDriver driver;
    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoConfirmarCadastro;
    private InputMethodTextRun mensagemErro;

    public CadastroPageObject (AppiumDriver driver){
        this.driver = driver;

    }
    public void BuscarElemento()
    {
        campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmarSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoConfirmarCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    public void PreencherForm(String usuario, String senha, String confirmacao)
    {

        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmacao);
    }

    public void Cadastrar()
    {
        botaoConfirmarCadastro.click();
    }

    public String MensagemErro()
    {
        mensagemErro = (InputMethodTextRun) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
        return mensagemErro.getText();
    }

}


