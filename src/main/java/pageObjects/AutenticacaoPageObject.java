package pageObjects;

import static utils.Utils.esperarAlgunsSegundos;
import static utils.Utils.swipe;
import static utils.Utils.clicarNaTela;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AutenticacaoPageObject {

	public AutenticacaoPageObject(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Inscreva-se para salvar suas informações")
	private MobileElement textoTelaAutenticacao;

	@AndroidFindBy(accessibility = "Continuar sem criar uma conta")
	private MobileElement botaoContinuarSemCriarUmaConta;

	@AndroidFindBy(accessibility = "Começar")
	private MobileElement botaoComecar_TelaBoasVindas;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Buscar']")
	private MobileElement campoDeBusca_MoedaPadrao;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Real brasileiro BRL']")
	private MobileElement moedaPadrao_RealBrasileiro;

	@AndroidFindBy(accessibility = "Próximo")
	private MobileElement botaoProximo_AcessoInicial;

	@AndroidFindBy(accessibility = "Inserir saldo em conta principal")
	private MobileElement textoSaldoContaPrincipal;

	@AndroidFindBy(className = "android.widget.EditText")
	private MobileElement campoSaldoContaPrincipal;

	@AndroidFindBy(accessibility = "Abrir menu de navegação")
	private MobileElement menuHambuger_TelaInicial;

	public void clicarBotaoContinuarSemCriarUmaConta() {
		botaoContinuarSemCriarUmaConta.click();
	}

	public void clicarbotaoComecar_TelaBoasVindas() {
		botaoComecar_TelaBoasVindas.click();
	}

	public void selecionarMoedaPadrao_RealBrasileiro() throws InterruptedException {
		esperarAlgunsSegundos(3000);
		swipe(300, 1200, 305, 700);
//		moedaPadrao_RealBrasileiro.click();
	}
	
	public void digitarValor(int a, int b) {
		clicarNaTela(a, b);
	}

	public void clicarBotaoProximo_AcessoInicial() {
		botaoProximo_AcessoInicial.click();
	}

	public void obterTextoSaldoContaPrincipal() {
		textoSaldoContaPrincipal.getText();
	}

	public boolean verificarSeEstaSendoExibidoMenuHambuger_TelaInicial() {
		if (menuHambuger_TelaInicial.isDisplayed() == true) {
			return true;
		}
		return false;
	}

	public boolean verificarSeEstaSendoExibidoTextoTelaAutenticacao() {
		if (textoTelaAutenticacao.isDisplayed() == true) {
			return true;
		}
		return false;
	}
	
}
