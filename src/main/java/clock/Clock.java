package clock;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Clock {

	private AndroidDriver driver;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "0044918883");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.google.android.deskclock");
		desiredCapabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");

		URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	}

	public void acessarMenuAlarme() throws Exception {
		System.out.println("acessando menu alarme");

		// ALARM
		MobileElement botaoAlarme = (MobileElement) driver
				.findElementByXPath("//android.widget.TextView[@text='Alarme']");
		botaoAlarme.click();

		Thread.sleep(2000);
	}

	public void novoAlarme() throws Exception {
		System.out.println("adicionando novo alarme");
		// Add alarm
		MobileElement botaoAdd = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Adicionar alarme"));
		botaoAdd.click();

		Thread.sleep(2000);

		// android:id/button1
		MobileElement botaoOk = (MobileElement) driver.findElement(MobileBy.id("android:id/button1"));
		botaoOk.click();

		Thread.sleep(2000);
	}

	@Test
	public void interagirComEditText() throws Exception {

		acessarMenuAlarme();
		novoAlarme();

		// android:id/button1
		MobileElement campoLabel = (MobileElement) driver
				.findElement(MobileBy.id("com.google.android.deskclock:id/edit_label"));
		campoLabel.click();

		Thread.sleep(2000);

		//// android.widget.EditText
		MobileElement campoEditText = (MobileElement) driver
				.findElement(MobileBy.xpath("//android.widget.EditText"));
		campoEditText.sendKeys("novo alarme");

		Thread.sleep(2000);
	}

	@Test
	public void interagirComCombo() throws Exception {
		System.out.println("interagindo com o combo");
		
		acessarMenuAlarme();
		novoAlarme();
		
		Thread.sleep(2000);

		//Toque Padrão (Oxygen)
		MobileElement textoCombo = (MobileElement) driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Padrão (Oxygen)']"));
		textoCombo.click();

		Thread.sleep(2000);
		
		MobileElement botaoDispensar = (MobileElement) driver
				.findElement(MobileBy.xpath("//android.widget.Button[@text='Dispensar']"));
		botaoDispensar.click();
		
		Thread.sleep(2000);

		// Argon
		MobileElement opcaoCombo = (MobileElement) driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Argon']"));
		opcaoCombo.click();

		Thread.sleep(2000);
	}

	@Test
	public void interagirComSwitch() throws Exception {
		System.out.println("interagindo com o switch");
		
		// com.google.android.deskclock:id/onoff

		acessarMenuAlarme();
		novoAlarme();

		MobileElement switchApp = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.Switch[@text='ATIVADO'][1]"));
		switchApp.click();

		Thread.sleep(2000);

		assertEquals("false", switchApp.getAttribute("checked"));
	}
	
	@Test
	public void interagirComCheckBox() throws Exception {
		
		acessarMenuAlarme();
		novoAlarme();
		
		//Repeat
		MobileElement check = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.CheckBox[@text='Repetir']"));
		check.click();

		Thread.sleep(2000);

		assertEquals("true", check.getAttribute("checked"));
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
