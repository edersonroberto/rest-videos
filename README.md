# rest-videos

## Tabela de Conteúdos
[Informação Geral](#informação-geral)&nbsp; 
[Tecnologias](#tecnologias)&nbsp; 
[Requisitos](#requisitos)&nbsp; 
[Instalação](#instalação)&nbsp; 
[Testes](#testes)

## Informação Geral
Esse projeto consiste em uma API RESTful para gerar estatísticas de vídeos inseridos.

## Tecnologias
Esse projeto foi criado com:
* Eclipse IDE for Enterprise Java Developers. Version: 2019-06 (4.12.0)
* Java Versão 8
* Apache Tomcat v8.5 Server


## Requisitos
Para rodar esse projeto utilizar:  
1. Eclipse versão 2019-06 ou superior. 
2. Tomcat v8.5 ou superior.

## Instalação
1. Clonar o repositório para o workspace do eclipse com o comando: git clone https://github.com/edersonroberto/rest-videos.git
2. No Eclipse: File > Import > Procurar por Existing Maven Projects > Selecionar a pasta rest-videos
3. Esperar o Maven baixar as dependências e o javadoc
4. Associar o Tomcat ao projeto 8.5 ou superior: Botão Direito no projeto > Properties > Target Runtimes > Selecionar O Server do Tomcat > Apply and Close
5. Rodar o Mvc Clean Install: Botão Direito no projeto > Run As > Maven Build > No campo Goals > Digitar clean install > Apply > Run

## Testes
Rodar o projeto no server: Botão Direito no projeto > Run As > Run on Server > Next > Selecionar o projeto rest-videos > Finish
Rodar os testes no JUnit: Botão Direito no projeto > Run As > JUnit Test 




