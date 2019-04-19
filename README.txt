### Funcionalidades / Regras de negócio:
	- CRUD de Estado;
		* Não pode repetir o nome;
		* Não pode repetir o acrônimo;
		* Não pode remover caso tenha alguma cidade associada;
	- CRUD de Cidade;
		* Não pode repetir o nome no mesmo estado;
		* Não pode remover caso tenha algum usuário associado;
	- CRUD de Usuário;
		* Não pode repetir o login;
		* Usuário que faz parte do grupo ADMIN tem campo específico "ano de experiência";
		* Usuário que faz parte do grupo VISITANTE tem campo específico "cidade".

		
### Adicionei o arquivo "src\main\webapp\WEB-INF\beans.xml" para não ter o problema "Unable to find CID BeanManager" ao implantar no Wildfly 13:
https://stackoverflow.com/questions/50511358/is-faces-config-xml-and-web-xml-needed-nowadays

Por enquanto ele está vazio e sem configuração nenhuma. Mais explicações sobre esse arquivo quando formos falar de CDI.