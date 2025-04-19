# 📋 listUser

Aplicação de listagem de usuários desenvolvida com **Jakarta EE**.

---

## 🎯 Funcionalidades

- Listagem de usuários cadastrados
- Cadastro de novos usuários
- Segurança básica com criptografia de dados sensíveis
- Estrutura organizada seguindo princípios de boas práticas com DAO, MVC e JSPs

---

## 🧱 Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   └── com.listUser
│   │       ├── controller
│   │       │   ├── AdminController.java           -> Controlador da área administrativa
│   │       │   ├── IndexController.java           -> Controlador da página inicial
│   │       │   └── i18n                           -> Internacionalização
│   │       ├── dao
│   │       │   ├── UsuarioDAO.java                -> Acesso a dados do usuário
│   │       │   ├── PapelDAO.java                  -> Acesso a dados de papéis/permissões
│   │       │   └── util                           -> Utilitários para conexão com banco
│   │       ├── model
│   │       │   ├── Usuario.java                   -> Entidade do usuário
│   │       │   └── Papel.java                     -> Entidade do papel/permissão
│   │       └── security
│   │           └── Criptografia.java              -> Classe utilitária para criptografia
│   ├── resources
│   │   └── resources
│   │       ├── message_en_US.properties           -> Mensagens em inglês
│   │       └── message_pt_BR.properties           -> Mensagens em português
│   └── webapp
│       ├── auth
│       │   └── admin                              -> Telas JSP da área administrativa
│       ├── public                                 -> Telas JSP públicas
│       ├── resources                              -> Bootstrap, JS, CSS
│       └── WEB-INF
│           ├── web.xml                            -> Arquivo de configuração da aplicação
│           └── lib                                -> Bibliotecas utilizadas
```

---

## 🚀 Tecnologias Utilizadas

- **Jakarta EE**
- **JSP/Servlets**
- **JSTL**
- **Bootstrap**
- **Java 8+**
- **JDBC**

---

## 🛠️ Como Executar

1. Clone o repositório
2. Importe o projeto em sua IDE (Ex: Eclipse ou VSCode com extensões Java)
3. Configure um servidor **Apache Tomcat**
4. Execute a aplicação acessando `http://localhost:8080/listUser`

---

## 🧠 Autor

Feito por [Thiago Alves] com foco em estudos de Jakarta EE 
