# 🔐 Password Validator

Projeto Spring Boot para validação de senhas com múltiplas regras de segurança.

---

## ✅ Regras de Validação

A senha deve atender **todas** as seguintes regras:

- ✅ Pelo menos **9 caracteres**
- ✅ Pelo menos **1 letra minúscula**
- ✅ Pelo menos **1 letra maiúscula**
- ✅ Pelo menos **1 número**
- ✅ Pelo menos **1 caractere especial**: `!@#$%^&*()-+`
- ❌ **Sem espaços em branco**
- ❌ **Sem caracteres repetidos**

---

## ▶️ Como Executar

Certifique-se de ter o **Java 21+** e o **Maven 3.8+** instalados.

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```
http://localhost:8080/api/password/validate
```

---

## 🧪 Exemplo de Requisição

### Requisição

```http
POST /api/password/validate
Content-Type: application/json

{
  "password": "AbTp9!fok"
}
```

### Resposta (válida)

```json
{
  "valid": true,
  "errors": []
}
```

### Resposta (inválida)

```json
{
  "valid": false,
  "errors": [
    "Password must be at least 9 characters.",
    "Password must contain at least one digit."
  ]
}
```

---

## 🧪 Rodando os Testes

```bash
mvn test
```

---

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/example/passwordvalidator/
│   │   ├── controller/        # Controller REST
│   │   ├── model/             # Modelos de requisição/resposta
│   │   ├── service/           # Serviço com lógica de validação
│   │   ├── validator/         # Regras de senha como interfaces e implementações
│   │   └── advice/            # Handler de exceções
│   └── resources/
│       └── application.properties
├── test/
│   └── java/com/example/passwordvalidator/
│       ├── controller/        # Testes da API
│       ├── validator/         # Testes das regras
│       └── service/           # Testes do serviço
```
## Considerações Finais

Este projeto foi desenvolvido com foco em atender todos os requisitos propostos de forma precisa, robusta e escalável. Ao final da implementação, posso afirmar com confiança que **todos os objetivos foram atingidos**, com uma solução limpa, testável e extensível.

### ✅ Validações Implementadas

A API valida senhas com base nos seguintes critérios:

- Pelo menos **9 caracteres**
- Pelo menos **1 dígito** (`0-9`)
- Pelo menos **1 letra minúscula** (`a-z`)
- Pelo menos **1 letra maiúscula** (`A-Z`)
- Pelo menos **1 caractere especial** entre os seguintes: `!@#$%^&*()-+`
- **Nenhum caractere repetido**
- **Sem espaços em branco**

Essas validações foram implementadas de forma isolada, garantindo que cada regra seja testável individualmente e facilmente ajustável no futuro.

### ❓ Sobre os Caracteres Especiais

Durante a implementação, surgiu a dúvida sobre se outros caracteres especiais como `?`, `=`, `%`, etc., deveriam ser considerados válidos. Como a descrição especificava **exclusivamente os caracteres** `!@#$%^&*()-+`, optei por **seguir à risca a definição**, aceitando apenas os caracteres listados. Essa abordagem evita ambiguidades e garante consistência com as regras fornecidas.

### 🔐 Sobre Autenticação e Middlewares

Decidi **não incluir autenticação, autorização ou middlewares adicionais** nesta versão do projeto, para **não desviar do foco principal**, que era a validação de senhas.

Essas camadas podem ser facilmente integradas futuramente, caso o projeto evolua para algo mais completo, como uma API pública ou um microserviço em um ecossistema maior.

Ainda assim, **considerei cuidadosamente essa possibilidade**, avaliando o impacto e a viabilidade de incluir autenticação via tokens, filtros globais de segurança ou interceptadores, mas preferi manter a simplicidade e foco técnico.

### 🧱 Design Orientado à Escalabilidade

Para garantir **escalabilidade e facilidade de manutenção**, optei por um design onde cada responsabilidade está **altamente granularizada**. Cada regra de validação foi encapsulada em sua própria classe (`PasswordRule`), seguindo o **princípio da responsabilidade única** (SRP - Single Responsibility Principle).

Essa decisão foi guiada pelos seguintes objetivos:

- ✅ **Facilidade de testes unitários**, com cobertura total e isolada de cada regra
- 🔁 **Reutilização das regras** em diferentes contextos (ex: políticas diferentes por usuário, tenant ou perfil)
- 🔧 **Extensibilidade**, permitindo adicionar ou remover regras sem impactos colaterais no restante do sistema

---

