package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach() {
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaDeLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        paginaDeLogin.preencherFormularioDeLogin("fulano", "pass");
        paginaDeLogin.efetuarLogin();

        String nomeUsuarioLogado = paginaDeLogin.getNomeUsuarioLogado();
        Assert.assertEquals("fulano", nomeUsuarioLogado);
        Assert.assertFalse(paginaDeLogin.isPaginaAtual());
    }

    @Test
    public void naoDeveriaEfetuarLoginComDadosInvalidos() {
        paginaDeLogin.preencherFormularioDeLogin("invalido", "1233");
        paginaDeLogin.efetuarLogin();

        Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        Assert.assertTrue(paginaDeLogin.isPaginaAtual());
        Assert.assertTrue(paginaDeLogin.isMensagemDeLoginInvalidoVisivel());
    }

}
