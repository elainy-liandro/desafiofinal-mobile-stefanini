package steps;

import static utils.Utils.acessarApp;
import static utils.Utils.driver;

import java.io.IOException;
import java.net.MalformedURLException;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setUp() throws MalformedURLException, InterruptedException {
		acessarApp();
	}

	@After
	public void fecharApp(Scenario cenario) throws IOException { 
		utils.Utils.gerarScreenShot(cenario);
		driver.quit();
	}

}
