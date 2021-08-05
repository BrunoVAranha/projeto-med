<h1 align="center">projeto-med</h1>
<h1 align="center">Projeto para a matéria de Programação Orientada a objetos   UFABC</h1>


<h2 align="center"> Tutorial para funcionamento no Windows</h2>

<h3 align="left"> Iniciar Server MongoDB</h3>

Instalar o MongoDB, e o MongoDBCompass (ferramenta para visualizar e administrar o banco de dados).

Abrir o Prompt de Comando na pasta de instalação do MongoDB (a pasta deve conter os seguintes arquivos):

![image](https://user-images.githubusercontent.com/49883183/128275667-0290f7f2-b59d-46b6-a1c5-0866dc420836.png)

Executar o comando "mongod" (sem aspas).
	
	mongod

![image](https://user-images.githubusercontent.com/49883183/128277213-b604920e-8cf8-432e-bbe5-d6da0c578d27.png)

Quando o servidor ja estiver ativo, abrir o MongoDBCompass e conectar-se a ele (a porta padrão é a 27017).

![image](https://user-images.githubusercontent.com/49883183/128277547-6dd17c5a-b2ab-4c04-a3b6-90e5f0c5695f.png)

<h3 align="left"> Iniciando a Aplicação</h3>

É necessário apenas clonar o repositório, compilar e executá-lo na IDE de preferência.

O projeto está configurado para criar um banco chamado "farmadb", e conectar-se a porta 27017. Caso precise alterar essas configurações, faça as alterações no arquivo application.properties:

![image](https://user-images.githubusercontent.com/49883183/128279007-76ed0260-1c9e-4c71-ad45-5df5100de892.png)

Assim que o usuário fornecer os inputs (nome, cpf, etc), o banco farmadb será criado (ou o banco que foi definido nas proporiedades), e para ser usado posteriormente, todo o processe de inicializar o servidor e conectar ao banco deve ser feito novamente.

![image](https://user-images.githubusercontent.com/49883183/128278445-795a5ea0-a6c1-4163-898b-685148874e38.png)








