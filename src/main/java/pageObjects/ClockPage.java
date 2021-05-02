package pageObjects;

import static org.junit.Assert.assertEquals;
import static utils.Utils.driver;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ClockPage {

	public ClockPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Alarme")
	private MobileElement botaoAlarme;

	@AndroidFindBy(accessibility = "Adicionar alarme")
	private MobileElement botaoAdd;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement botaoOk;

	@AndroidFindBy(id = "com.google.android.deskclock:id/edit_label")
	private MobileElement campoLabel;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement campoEditText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Padrão (Oxygen)']")
	private MobileElement textoCombo;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Dispensar']")
	private MobileElement botaoDispensar;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Argon']")
	private MobileElement opcaoCombo;

	@AndroidFindBy(xpath = "//android.widget.Switch[@text='ATIVADO'][1]")
	private MobileElement switchApp;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Repetir']")
	private MobileElement check;

	public void acessarMenuAlarme() throws Exception {
		System.out.println("acessando menu alarme");
		botaoAlarme.click();
	}

	public void acionarBotaoNovoAlarme() throws Exception {
		System.out.println("adicionando novo alarme");
		botaoAdd.click();
	}

	public void acionarBotaoOk() throws Exception {
		botaoOk.click();
	}

	public void interagirComEditText() throws Exception {

		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		campoLabel.click();

		campoEditText.sendKeys("novo alarme");
	}

	public void interagirComCombo() throws Exception {
		System.out.println("interagindo com o combo");

		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		textoCombo.click();

		botaoDispensar.click();

		opcaoCombo.click();
	}

	public void interagirComSwitch() throws Exception {
		System.out.println("interagindo com o switch");

		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		switchApp.click();

		assertEquals("false", switchApp.getAttribute("checked"));
	}

	public void interagirComCheckBox() throws Exception {

		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		check.click();

		assertEquals("true", check.getAttribute("checked"));

	}

	public void clicarNaHora(String hora) throws Exception {

		MobileElement clickHora = (MobileElement) driver.findElement(MobileBy.AccessibilityId(hora));
		clickHora.click();
	}

	public void clicarNoMinuto(String minuto) throws InterruptedException {

		MobileElement clickMinuto = (MobileElement) driver.findElement(MobileBy.AccessibilityId(minuto));
		clickMinuto.click();

	}

	public void selecionarOPeriodo(String periodo) throws InterruptedException {
		MobileElement clickPeriodo = (MobileElement) driver.findElement(MobileBy.id("android:id/pm_label"));
		clickPeriodo.click();
	}

}
