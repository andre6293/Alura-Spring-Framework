# Notas

## Conteúdo
- [Módulo 1 - Fundamentos do Java na Web](#m-dulo-1---fundamentos-do-java-na-web)
  * [Servlets](#servlets)
  * [Tomcat](#tomcat)
  * [Apache HTTP vs Apache Tomcat](#apache-http-vs-apache-tomcat)
  * [doPost e doGet](#dopost-e-doget)
  * [JSP](#jsp)
  * [RequestDispatcher](#requestdispatcher)
  * [JTSL](#jtsl)
  * [Inversão de Controle (IOC)](#invers-o-de-controle--ioc-)
  * [MVC](#mvc)
  * [Notas adicionais](#notas-adicionais)
- [Módulo 2 - Do JDBC ao Spring Data](#m-dulo-2---do-jdbc-ao-spring-data)
- [Módulo 3 - Aplicação web com Spring MVC e Spring Security](#m-dulo-3---aplica--o-web-com-spring-mvc-e-spring-security)
- [Módulo 4 - API REST e Testes com Spring Boot](#m-dulo-4---api-rest-e-testes-com-spring-boot)

---

## Módulo 1 - Fundamentos do Java na Web 
### Servlets
Servlet ou *servidorzinho* é uma classe Java usada para estender as funcionalidades de um servidor. Apesar dos servlets poderem responder a quaisquer tipos de requisições, eles normalmente são usados para estender as aplicações hospedadas por servidores web, desta forma eles podem ser imaginados como Applets Java que rodam em servidores em vez de rodarem nos navegadores web.

### Tomcat
O Tomcat é um servidor web Java, mais especificamente, um container de servlets. O Tomcat implementa, dentre outras de menor relevância, as tecnologias Java Servlet e JavaServer Pages (JSP) e não é um container Enterprise JavaBeans (EJB).
* Cada servlet é criado somente uma vez no Tomcat, são singleton. E eles só são criados quando requisitados por padrão. Tal comportamento pode ser alterado colocando o atributo loadOnStartup=1 na anotação @WebServlet.

### Apache HTTP vs Apache Tomcat
O Tomcat é puramente Java enquanto Apache HTTP é escrito em C. Além disso, o Apache HTTP é um servidor estático (por padrão pelo menos) e precisa de alguma integração com outra linguagem para se gerar HTML dinamicamente. O Tomcat já é dinâmico de cara, usando Java e JSP, claro!

### doPost e doGet
É possível limitar os métodos HTTP suportados por um servlet usando as classes doPost e doGet ao invés da classe service.

### JSP
Jakarta Server Pages (anteriormente Javaserver Pages) é uma página automaticamente processada pelo Tomcat, para gerar HTML dinamicamente no JSP usamos Scriptlets (<% SCRIPT %>). Pode-se usar expression language (**${}**) ou também, com o uso de JSTL, usar taglibs como *core:if*, *core:forEach* e *core:url*.

### RequestDispatcher
Usa-se o RequestDispatcher para *chamar* um JSP a partir de um ServLet. Pode  chamar qualquer recurso acessível pela URL (uma página HTML, CSS, JavaScript, Servlet ou JSP).

### JTSL
JTSL ou *Java Standard Tag Library* é uma biblioteca padrão de tags do Java. Ela estende a especificação JSP adicionando uma biblioteca de tags das tags JSP para tarefas comuns, tais como processamento de dados XML, execução condicional, loops e internacionalização.

### Inversão de Controle (IOC)
É um princípio de design de programas de computadores onde a sequência (controle) de chamadas dos métodos é invertida em relação à programação tradicional, ou seja, ela não é determinada diretamente pelo programador. Ex.: Tomcat e Spring.

### MVC
MVC (*Model View Controller*) é um padrão arquitetural de controle e organização em camadas. Quando o controlador decide qual ação executar, a ação em si decide qual Modelo utilizar. Já a camada View se preocupa em renderizar os dados. Note que o View não sabe de onde vem os dados e não acessa diretamente o banco de dados, apenas recebe e mostra os dados de visualização.

### Java Reflection
Serve para determinar métodos e atributos que serão utilizados de determinada classe (que você nem conhece) em tempo de execução.

### Autenticação X Autorização
Autenticação é sobre verificar a identidade. Isso pode acontecer através de um login, token, impressão digital, RG, entre várias outras formas e combinações. Autorização, é verificar a permissão de acesso podendo criar permissões e papeis específicos que detalhem o acesso.

### Servlet X Filter
São bem semelhantes, porém o filtro tem uma responsabilidade a mais que é parar a execução através do parâmetro FilterChain que é usado para mandar a requisição para frente. 

### Jetty
Um **Servlet container** ou **Servlet Engine** como o Tomcat.

### Wildfly, Weblogic e Websphere
Wildfly (Redhat), Weblogic (Oracle), Websphere (IBM) são *Application Servers* e possuem mais recursos do que os *servlet containers*.

### Notas adicionais
* @WebServlet marca a classe como uma servlet e além disso a registra a URL
* As requisições sempre são strings
* Com o método GET as requisições aparecem na URL, diferente do método POST
* Não utilizar a uri jstl/core ou jstl/fmt, tratam-se de uris da versão 1.0 e foram depreciadas. Usar jsp/jstl/core e jsp/jstl/fmt no lugar.
* Não é possível fazer um laço e modificar a lista ao mesmo tempo, pelo menos não na implementação Arraylist. Para esse caso é necessário utilizar um Iterator.
Ex.:<br>
`Iterator<Tipo> it = lista.iterator();`
<br>E posteriormente usar o método<br>
`it.remove();`
* Através da anotação @WebServlet podemos definir mais do que uma URL para chamar o servlet, por exemplo:<br>
`@WebServlet(urlPatterns= {"/listaEmpresas", "/empresas"})`<br>
`public class ListaEmpresasServlet extends HttpServlet { `
* Os JSPs devem ficar dentro da pasta WEB-INF para não serem acessados de forma externa às ações, pois eles dependem delas para serem alimentados

## Módulo 2 - Do JDBC ao Spring Data
## Módulo 3 - Aplicação web com Spring MVC e Spring Security
## Módulo 4 - API REST e Testes com Spring Boot

---
Andre Pinto (jan 21 - )
