package steps;

import static utils.Utils.driver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.DespesaPageObject;

public class DespesaSteps {

	DespesaPageObject dpo = new DespesaPageObject(driver);

	// Adicionar Despesa

	@Quando("clicar no botao Adicionar")
	public void clicar_no_botao_Adicionar() {
		dpo.clicarBotaoAdicionarDespesa();
	}

	@Quando("eu passar o tutorial")
	public void eu_passar_o_tutorial() throws InterruptedException {
		int c = 9;
		while (c != 0) {
			dpo.digitarValor(370, 900);
			c--;
		}
	}

	@Quando("incluir despesa do tipo compras de mercado")
	public void incluir_despesa_do_tipo_compras_de_mercado() throws InterruptedException {

		dpo.digitarValor(260, 1290);
		dpo.digitarValor(270, 1480);
		dpo.digitarValor(270, 1480);

		dpo.clicarBotaoTipoDeDespesa();
	}

	@Entao("devo no botao adicionar e visualizar nova despesa")
	public void devo_no_botao_adicionar_e_visualizar_nova_despesa() {
		dpo.clicarNoAdicinarDespesa_FormDespesa();
	}

	// Excluir Despesa

	@Dado("que o usuario tenha uma despesa")
	public void que_o_usuario_tenha_uma_despesa() throws InterruptedException {
		dpo.clicarBotaoAdicionarDespesa();
		int c = 9;
		while (c != 0) {
			dpo.digitarValor(370, 900);
			c--;
		}

		dpo.digitarValor(260, 1290);
		dpo.digitarValor(270, 1480);
		dpo.digitarValor(270, 1480);

		dpo.clicarBotaoTipoDeDespesa();
		dpo.clicarNoAdicinarDespesa_FormDespesa();
	}

	@Quando("clicar na despesa")
	public void clicar_na_despesa() throws InterruptedException {
		dpo.digitarValor(410, 940);
		dpo.digitarValor(380, 385);
	}

	@Quando("eu clicar a exclusao e exibir nenhuma despesa")
	public void eu_clicar_em_excluir_e_exibir_nenhuma_despesa() {
		dpo.clicarBotaoExcluirDespesa();
	}

}
