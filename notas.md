# Notas
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
  * [Java Reflection](#java-reflection)
  * [Autenticação X Autorização](#autentica--o-x-autoriza--o)
  * [Servlet X Filter](#servlet-x-filter)
  * [Jetty](#jetty)
  * [Wildfly, Weblogic e Websphere](#wildfly--weblogic-e-websphere)
  * [Maven](#maven)
    + [pom.xml](#pomxml)
    + [Maven Phases](#maven-phases)
    + [Relatórios do Maven](#relat-rios-do-maven)
    + [JaCoco](#jacoco)
    + [Tags <scope/\>](#tags--scope---)
  * [Notas adicionais](#notas-adicionais)
- [Módulo 2 - Do JDBC ao Spring Data](#m-dulo-2---do-jdbc-ao-spring-data)
  * [JDBC](#jdbc)
  * [Design Pattern - Factory](#design-pattern---factory)
  * [SQL Injection](#sql-injection)
  * [Pool de conexões](#pool-de-conex-es)
  * [Design Pattern - DAO](#design-pattern---dao)
  * [Queries N+1](#queries-n-1)
  * [JDBC X JPA](#jdbc-x-jpa)
  * [Notas adicionais](#notas-adicionais-1)
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

### Maven
É uma ferramenta de automação de compilação utilizada primariamente em projetos Java. Similarmente temos Gradle.
* O Ant gerencia builds, mas não as dependências. Dessa forma ele se diferencia dos citados acima.
* O argumento *-o* rodará o comando de forma offline, sem verificar se há uma versão nova de alguma dependência ou a necessidade de baixar algo.<br>
Ex.:<br>
`mvn -o compile`

#### pom.xml
POM (Project Object Model) é um arquivo que contém as informações e configurações de um projeto Maven.

#### Maven Phases
* **validate** - validação de que o projeto está correto e todas as informações necessárias estão disponíveis
* **compile** - compilação do código fonte do projeto
* **test** - testagem do código compilando utilizando o framework de testes adequado. Esses testes não exigem que o código esteja empacotado ou *deployado*
* **package** - empacotamento do código compilado em um formato de distribuição como o JAR
* **verify** - verificação da integridade para assegurar qualidade
* **install** - instala o pacote no repositório local para ser usado como dependência em outros projetos localmente
* **deploy** - feito no ambiente de build, copia o pacote final para o repositório remoto para compartilhamento com outros desenvolvedores e projetos.

#### Relatórios do Maven
Um desses relatórios é o PMD (*Programming Mistake Detector*) que analisa o código fonte e detecta possíveis margens de bug.<br>
`mvn pmd:pmd`<br>
`mvn pmd:check - esse comando falha o build caso alguma regra do PMD seja violada no código fonte e ele se relaciona à fase verify`<br>

#### JaCoco
Plugin de *test coverage* para Maven.

#### Tags <scope/\>
* compile - é o escopo padrão, as dependências compiladas ficarão no classpath
* provided - similar ao compile, mas os artefatos serão providos pelo JDK/container em tempo de execução
* runtime - não é necessário para compilar, mas sim em tempo de execução
* test - dependência apenas necessária para a compilação e execução dos testes
* system - igual ao provided, mas o artefato deve estar explicitado no <systemPath/\>

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
`public class ListaEmpresasServlet extends HttpServlet {}`
* Os JSPs devem ficar dentro da pasta WEB-INF para não serem acessados de forma externa às ações, pois eles dependem delas para serem alimentados

## Módulo 2 - Do JDBC ao Spring Data
### JDBC
Java Database Connectivity (java.sql.\*) é um conjunto de classes e interfaces para Java que fazem o envio de instruções SQL para qualquer banco de dados relacional.

### Design Pattern - Factory
É um padrão que fornece a possibilidade de criar uma *fábrica* para criação de objetos em tempo de execução, deixando o cliente isento de instanciar a classe. Criam-se objetos sem expor a lógica ou as configurações de criação ao cliente. Além disso, é possível referir-se ao objeto recém-criado usando uma interface (usando uma abstração), desacoplando a implementação.

### SQL Injection
É um tipo de ameaça de segurança que se aproveita de falhas em sistemas que interagem com bases de dados através de comandos SQL, onde o atacante consegue inserir uma instrução SQL personalizada e indevida dentro de uma consulta (SQL query) através da entradas de dados de uma aplicação, como formulários ou URL de uma aplicação. Pode ser evitado dentro do java.sql.\* utilizando PreparedStatement em vez do Statement simples.

### Pool de conexões
É um cache de conexões de banco de dados mantido de forma que as conexões possam ser reutilizadas quando requisições futuras ao banco de dados forem requeridas. Isso permite uma melhor utilização por múltiplos usuário. O pool de conexões também reduz a quantidade de tempo que um usuário deve esperar para estabelecer uma conexão com o banco de dados.

### Design Pattern - DAO
DAO (*Data Access Object*) é um padrão para aplicações que utilizam persistência de dados, onde tem a separação das regras de negócio das regras de acesso a banco de dados, implementada com linguagens de programação orientadas a objetos (como por exemplo Java) e arquitetura MVC, onde todas as funcionalidades de bancos de dados, tais como obter conexões, mapear objetos para tipos de dados SQL ou executar comandos SQL, devem ser feitas por classes DAO.

### Queries N+1
N+1 significa executar uma query e mais uma nova query (N) para cada relacionamento.
* Queries N+1 podem gerar um problema no desempenho
* Queries N+1 podem ser evitadas através de joins no SQL

### JDBC X JPA
A principal diferença entre as duas bibliotecas é o nível de abstração, sendo o JDBC de mais baixo nível (e mais antigo) enquanto o JPA *esconde* o SQL do programador.

### JPA
JPA (Jakarta Persistence API) é um ORM (Object Relacional Mapper) Java, um ORM mapeia as classes para tabelas e gera o SQL de forma automática.

### EntityManager
Para gerar uma instância de EntityManager é necessário configurar propriedades no arquivo persistence.xml e obter a instância através da classe Persistence, como mostrado abaixo:<br>
`EntityManagerFactory entityManagerFactory = `<br>
`    Persistence.createEntityManagerFactory("financas");`<br>
<br>
`EntityManager manager = entityManagerFactory.createEntityManager();`<br>
<br>
`manager.close();`<br>

### Transação
A transação é um mecanismo para manter a consistência das alterações de estado no banco, visto que todas as operações precisam ser executadas com sucesso, para que a transação seja confirmada.

### JPA - Método .find()
Ao utilizar o método entityManager.find() é gerado um objeto do tipo do modelo para representar o resultado. Esse objeto/entidade está em estado *managed* no JPA, dessa forma, qualquer alteração feita será *commitada/syncada* no banco de dados. Esse comportamento também se repete ao usar o entityManager.persist(objeto).

### JPA - Estados
* **Transient** - um novo objeto que ainda não foi associado com o Hibernate, portanto não está mapeado a um banco de dados e não tem id 
* **Managed** - o objeto está no banco de dados e sincronizado
* **Detached** - alterações feitas no objeto/entidade não serão traduzidos automaticamente para o banco de dados
* **Removed** - o objeto já foi *managed*, tem id, porém não se encontra mais no banco de dados

### JPA - Anotações @\*To\* (completar)
* **@OneToOne** - é criada uma coluna de chave estrangeira
* **@OneToMany** - 
* **@ManyToOne** - é criada uma coluna de chave estrangeira
* **@ManyToMany** - é criada uma tabela de relacionamento para as duas tabelas

### Notas adicionais
* Método execute da interface java.sql.Statement devolve *true* quando o resultado é um java.sql.ResultSet e *false* em caso contrário (update, delete, etc.)
* Em sua configuração padrão o JDBC possui auto-commit, dessa forma o usuário não tem controle total das transações com o banco de dados, para isso é necessário desligar esse recurso e usar os métodos commit() e rollback() manualmente.
* Ao utilizar uma classe que estenda AutoCloseable é possível envolver sua declaração em um try-with-resources, dessa forma não é necessário fechar o método. Ex.:<br>
`try (PreparedStatement stm = connection.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {}`
* Anotar com @Deprecated o construtor padrão não utilizável para evitar que um outro desenvolvedor o utilize. É necessário manter o construtor padrão para uso do JPA
* Por padrão, quando temos um relacionamento @OneToOne, ainda não obtemos a restrição que é esperada por um relacionamento @OneToOne, para isso é necessário colocar a anotação @JoinColumn(unique=true) no relacionamento. A anotação @JoinColumn só funciona na criação do schema.

## Módulo 3 - Aplicação web com Spring MVC e Spring Security

## Módulo 4 - API REST e Testes com Spring Boot

---
Andre Pinto (jan 21 - )
