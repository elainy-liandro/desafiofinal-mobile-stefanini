package pageObjects;

import static utils.Utils.clicarNaTela;
import static utils.Utils.esperarAlgunsSegundos;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DespesaPageObject {
	
	public DespesaPageObject(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
	private MobileElement botaoAdicionarDespesa;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='0']")
	private MobileElement campoValorDespesa;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Compras de mercado']/android.widget.ImageView")
	private MobileElement tipoDeDespesa;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Comentário']")
	private MobileElement campoComentario;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Adicionar']")
	private MobileElement botaoAdicionarDespesa_FormDespesa;
	
	@AndroidFindBy(accessibility = "COMPRAS DE MERCADO R$ 0,00")
	private MobileElement cardComNovaDespesaAdicionada;
	
	@AndroidFindBy(accessibility = "EXCLUIR")
	private MobileElement excluirDespesa;
	
	@AndroidFindBy(accessibility = "SIM")
	private MobileElement confirmarExclusaoDespesa_SIM;
	
	public void digitarValor(int a, int b) throws InterruptedException {
		esperarAlgunsSegundos(1000);
		clicarNaTela(a, b);
	}

	public void clicarBotaoAdicionarDespesa() {
		botaoAdicionarDespesa.click();
	}
	
	public void clicarCampoValorDespesa() {
		campoValorDespesa.click();
	}
	
	public void clicarBotaoTipoDeDespesa() {
		tipoDeDespesa.click();
	}

	public void clicarNoAdicinarDespesa_FormDespesa() {
		botaoAdicionarDespesa_FormDespesa.click();
	}
	
	public boolean verificarSeEstaSendoExibidoCardComNonaDespesaZerada() {
		if (cardComNovaDespesaAdicionada.isDisplayed() == true) {
			return true;
		}
		return false;
	}
	
	public void clicarBotaoExcluirDespesa() {
		excluirDespesa.click();
	}
	
	public void clicarBotaoConfirmacaoExcluirDespesa() {
		confirmarExclusaoDespesa_SIM.click();
	}

}
