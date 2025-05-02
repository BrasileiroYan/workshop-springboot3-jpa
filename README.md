# Workshop Spring Boot 3 + JPA

Este projeto é uma API REST construída com **Spring Boot 3** e **JPA (Hibernate)**, com objetivo educacional. Ele simula o funcionamento básico de um sistema de pedidos online, com operações CRUD e relacionamentos entre entidades.

## 🚀 Tecnologias utilizadas
- Java 17+
- Spring Boot 3
- Spring Data JPA (Hibernate)
- Banco de dados H2 (em memória)
- Maven

## 📦 Funcionalidades

A API permite gerenciar os seguintes recursos:

- **Usuários (`User`)**
- **Pedidos (`Order`)**
- **Itens do pedido (`OrderItem`)**
- **Produtos (`Product`)**
- **Categorias (`Category`)**
- **Pagamentos (`Payment`)**

Também foram aplicados:

- Relacionamentos entre entidades (`OneToMany`, `ManyToMany`, etc.)
- Controle de exceções com `@ControllerAdvice`
- Organização em camadas (controller, service, repository)
- Seed de dados com `CommandLineRunner`

## 🔧 Como executar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/workshop-springboot3-jpa.git
   cd workshop-springboot3-jpa
   ```

2. Abra o projeto em uma IDE compatível com Spring Boot, como **IntelliJ IDEA** ou **Eclipse**.

3. Execute a aplicação a partir da classe `CourseApplication.java`, localizada em:

   ```
   src/main/java/com/example/course/CourseApplication.java
   ```

4. Após iniciar o projeto, a API estará disponível em:
   ```
   http://localhost:8080
   ```

5. Para acessar o console do banco de dados H2:

   ```
   http://localhost:8080/h2-console
   ```

   - **JDBC URL:** `jdbc:h2:mem:testdb`
   - **Usuário:** `sa`
   - **Senha:** *(deixe em branco)*

## 🔄 Exemplos de requisições

### 🔍 Buscar todos os usuários
```http
GET /users
```

### 🔎 Buscar um usuário por ID
```http
GET /users/1
```

### 📝 Criar um novo produto
```http
POST /products
Content-Type: application/json

{
  "name": "Monitor LG 24'",
  "description": "Full HD, HDMI",
  "price": 799.99,
  "imgUrl": "https://exemplo.com/imagem-monitor.png"
}
```

### ❌ Exemplo de erro tratado (usuário não encontrado)
```json
{
  "timestamp": "2025-05-02T18:20:44.123Z",
  "status": 404,
  "error": "Resource not found",
  "message": "Id not found: 99",
  "path": "/users/99"
}
```

## 🛠️ Autor: Yan Pedro Façanha Brasileiro

Projeto desenvolvido como prática de aprendizado no ecossistema Spring.  
Ideal para reforçar conceitos de:

- Desenvolvimento de API RESTful  
- Integração com banco de dados usando JPA  
- Organização de projeto em camadas  
- Tratamento de exceções  
- Uso de banco de dados em memória

---

> Sinta-se à vontade para sugerir melhorias, abrir *issues* ou fazer *fork* do repositório.  
> Este projeto é apenas para fins educacionais.
