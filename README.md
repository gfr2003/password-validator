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
