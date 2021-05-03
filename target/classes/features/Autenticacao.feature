#language: pt
#Author: Elainy Rodrigues
#Data 02/05/2021
@Autenticacao @End2End
Funcionalidade: Autenticacao

  Contexto: 
    Dado que o usuario esteja na pagina de autenticacao

  @AutenticacaoSemConta @SmokeTest
  Cenario: Realizar acesso sem criar uma conta
    Quando clicar no botao Continuar sem criar uma conta
    E clicar no botao Comecar
    E escolher a moeda pardrao e clicar em proximo
    E inserir o saldo e clicar em proximo
    Entao o sistema devera exibir tela de boas vindas
