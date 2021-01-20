#Notas

## Conteúdo
(to-do)

---

## Módulo 1 - Fundamentos do Java na Web 

### Servlets
Servlet ou *servidorzinho* é uma classe Java usada para estender as funcionalidades de um servidor. Apesar dos servlets poderem responder a quaisquer tipos de requisições, eles normalmente são usados para estender as aplicações hospedadas por servidores web, desta forma eles podem ser imaginados como Applets Java que rodam em servidores em vez de rodarem nos navegadores web.

### Tomcat
O Tomcat é um servidor web Java, mais especificamente, um container de servlets. O Tomcat implementa, dentre outras de menor relevância, as tecnologias Java Servlet e JavaServer Pages (JSP) e não é um container Enterprise JavaBeans (EJB).

### Apache HTTP vs Apache Tomcat
O Tomcat é puramente Java enquanto Apache HTTP é escrito em C. Além disso, o Apache HTTP é um servidor estático (por padrão pelo menos) e precisa de alguma integração com outra linguagem para se gerar HTML dinamicamente. O Tomcat já é dinâmico de cara, usando Java e JSP, claro!

### doPost e doGet
É possível limitar os métodos HTTP suportados por um servlet usando as classes doPost e doGet ao invés da classe service.

## JSP
Jakarta Server Pages (anteriormente Javaserver Pages) é uma página automaticamente processada pelo Tomcat, para gerar HTML dinamicamente no JSP usamos Scriptlets (<% SCRIPT %>).
* Usa-se o RequestDispatcher para *chamar* um JSP a partir de um ServLet.

### Notas adicionais
* @WebServlet marca a classe como uma servlet e além disso a registra a URL
* As requisições sempre são strings
* Com o método GET as requisições aparecem na URL, diferente do método POST

---
Andre Pinto (jan 21 - )
