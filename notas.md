#Notas

## Conteúdo
(to-do)

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
MVC (*Model View Controller*), é um padrão arquitetural 


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

## Módulo 2 - Do JDBC ao Spring Data
## Módulo 3 - Aplicação web com Spring MVC e Spring Security
## Módulo 4 - API REST e Testes com Spring Boot

---
Andre Pinto (jan 21 - )
