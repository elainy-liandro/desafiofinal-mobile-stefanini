package steps;

import static utils.Utils.driver;

import java.util.List;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.ClockPage;

public class ClockSteps {

	ClockPage cp = new ClockPage(driver);

	@Dado("que o usuario acione o menu Alarme")
	public void acionarOMenuAlarme() throws Exception {

		cp.acessarMenuAlarme();
	}

	@Quando("o usuario acionar o botao adicionar Alarme")
	public void oUsuarioAcionarOBotaoAdicionarAlarme() throws Exception {

		cp.acionarBotaoNovoAlarme();
	}
	
	@Quando("configurar a hora para {string},{string}")
	public void configurarAHoraPara(String hora, String periodo) throws Exception {

		String tempo[] = hora.split(":");
		String horaA = tempo[0];
		String minutos = tempo[1];

		cp.clicarNaHora(horaA);
		cp.clicarNoMinuto(minutos);
		cp.selecionarOPeriodo(periodo);
		cp.acionarBotaoOk();
	}
	
	@Quando("o usuario alterar o som do alarme")
	public void oUsuarioAlterarOSomDoAlarme() throws Exception {

		cp.alterarSomDoAlarme();
	}

	@Entao("o app adiona um novo alarme com as informacoes:")
	public void oAppAdionaUmNovoAlarmeComAsInformacoes(List<String> dados) {
		
		cp.validarInformacoes(dados);
	}

}
