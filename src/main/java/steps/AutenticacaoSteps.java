package steps;

import static org.junit.Assert.assertTrue;
import static utils.Utils.driver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.AutenticacaoPageObject;

public class AutenticacaoSteps {
	
	AutenticacaoPageObject apo = new AutenticacaoPageObject(driver);
	
	
	@Dado("que o usuario esteja na pagina de autenticacao")
	public void que_o_usuario_esteja_na_pagina_de_autenticacao() {
		assertTrue(apo.verificarSeEstaSendoExibidoTextoTelaAutenticacao() == true);
	}

	@Quando("clicar no botao Continuar sem criar uma conta")
	public void clicar_no_botao_Continuar_sem_criar_uma_conta() {
		apo.clicarBotaoContinuarSemCriarUmaConta();
	}
	
	@Quando("clicar no botao Comecar")
	public void clicar_no_botao_Comecar() {
		apo.clicarbotaoComecar_TelaBoasVindas();
	}

	@Quando("escolher a moeda pardrao e clicar em proximo")
	public void escolher_a_moeda_pardrao_e_clicar_em_proximo() throws InterruptedException {
		apo.selecionarMoedaPadrao_RealBrasileiro();
		apo.clicarBotaoProximo_AcessoInicial();
	}

	@Quando("inserir o saldo e clicar em proximo")
	public void inserir_o_saldo_e_clicar_em_proximo() throws InterruptedException {
		apo.digitarValor(260, 1290);
		apo.digitarValor(270, 1480);
		apo.digitarValor(270, 1480);
		apo.digitarValor(270, 1480);
		apo.clicarBotaoProximo_AcessoInicial();
	}

	@Entao("o sistema devera exibir tela de boas vindas")
	public void o_sistema_devera_exibir_tela_de_boas_vindas() {
		assertTrue(apo.verificarSeEstaSendoExibidoMenuHambuger_TelaInicial() == true);
	}

}
