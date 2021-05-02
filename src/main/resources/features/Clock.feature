#language: pt
#enconding: UTF-8

Funcionalidade: Clock mobile

Eu como um usuario gostaria de adicionar um novo alarme para que eu acorde mais cedo no dia seguuinte

Cenario: Adicionar novo alarme

Dado que o usuario acione o menu Alarme
Quando o usuario acionar o botao adicionar Alarme
E configurar a hora para "4:25","AM"
E o usuario alterar o som do alarme
Entao o app adiona um novo alarme com as informacoes:
	|Repetir										|			
	|Argon            					|
	|Marcador										|
	|Rotina do Google Assistente|
	|Excluir										|
	


