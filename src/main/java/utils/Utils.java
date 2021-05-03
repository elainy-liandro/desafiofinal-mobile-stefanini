package utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.core.api.Scenario;

public class Utils {

	public static AppiumDriver<WebElement> driver;

	public static void acessarApp() throws MalformedURLException, InterruptedException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "0071589488");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "ru.innim.my_finance");
		desiredCapabilities.setCapability("appActivity", "ru.innim.my_finance.MainActivity");

		driver = new AppiumDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public static File gerarScreenShot(Scenario cenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		cenario.embed(screenshot, "image/png");
		File imagem = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(imagem,
					(new File("./target/screenshots", cenario.getName() + "-" + cenario.getStatus() + ".png")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return imagem;
	}

	@SuppressWarnings("rawtypes")
	public static void swipe(int startX, int startY, int endX, int endY) {
		System.out.println("Inicio - Swipe");
		(new TouchAction(driver)).press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY))
				.release().perform();
		System.out.println("Fim - Swipe");
	}

	public static void esperarAlgunsSegundos(long t) throws InterruptedException {
		Thread.sleep(t);
	}

	public static void inputTextAppiumCommand(MobileElement elemento, String keyeventCommand) {

		elemento.click();

		List<String> argsCommandKeyevent = Arrays.asList("text", transformarNome(keyeventCommand));
		Map<String, Object> commandKeyevent = ImmutableMap.of("command", "input", "args", argsCommandKeyevent);

		String output = (String) driver.executeScript("mobile: shell", commandKeyevent);

		System.out.println(output);
	}

	public static String transformarNome(String texto) {
		String[] lista = texto.split(" ");

		String stringModificada = "";

		for (String palavra : lista) {
			stringModificada += palavra + "%s";

		}

		if (stringModificada.length() > 0) {
			stringModificada = stringModificada.substring(0, stringModificada.length() - 2);
		}

		return stringModificada;
	}

}