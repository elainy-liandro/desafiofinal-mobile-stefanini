#language: pt
#Author: Elainy Rodrigues
#Data 02/05/2021
@Despesa @End2End
Funcionalidade: Despesa

  Contexto: 
    Dado que o usuario esteja na tela de boas vindas

  @AdicinarDespesa @SmokeTest
  Cenario: Adicionar nova despesa
    Quando clicar no botao Adicionar
    Quando eu passar o tutorial
    E incluir despesa do tipo compras de mercado
    Entao devo no botao adicionar e visualizar nova despesa

  @RemoverDespesa @SmokeTest
  Cenario: Remover nova despesa
    Dado que o usuario tenha uma despesa
    Quando clicar na despesa
    Quando eu clicar em excluir
    Entao confirmar a exclusao e exibir nenhuma despesa
