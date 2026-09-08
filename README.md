# SubTracker

> Gerenciador de assinaturas recorrentes (streaming, SaaS, academia) com alertas de renovação e visão de gasto total.

## 📌 Sobre o Projeto

Quase todo mundo hoje paga por múltiplas assinaturas — Netflix, Spotify, academia, ferramentas SaaS pessoais — e perde o controle de quanto isso soma por mês, ou esquece de cancelar algo que não usa mais. O **SubTracker** centraliza essas assinaturas, calcula o impacto real no orçamento e avisa sobre renovações próximas.

Este é o primeiro projeto do roadmap: foco em fundamentos sólidos de Spring Boot antes de avançar para desafios mais complexos.

## 🎯 O Problema

- Assinaturas recorrentes se acumulam de forma invisível — não há um lugar único para visualizar o gasto total.
- Renovações automáticas pegam as pessoas de surpresa, gerando cobranças indesejadas.
- Não existe uma visão simples de "quanto eu realmente gasto por mês com isso".

## ✅ A Solução

Uma API que permite cadastrar assinaturas com valor e ciclo de cobrança, calcula automaticamente o gasto agregado e alerta sobre renovações próximas.

## 🚀 Funcionalidades

- [ ] CRUD de assinaturas (nome, valor, ciclo de cobrança — mensal/anual, categoria, data de início)
- [ ] Cálculo automático de gasto total mensal e anual (agregações via JPQL/Query Methods)
- [ ] Endpoint que lista assinaturas "a vencer nos próximos N dias"
- [ ] Filtro de assinaturas por categoria

## 🛠️ Stack Tecnológica

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 25 |
| Framework | Spring Boot 4.x |
| Persistência | Spring Data JPA + PostgreSQL |
| Migrations | Flyway |
| Testes | JUnit 5, Mockito |
| Documentação de API | springdoc-openapi (Swagger UI) |
| Build | Maven |

## 🏗️ Arquitetura (visão geral)

```
src/main/java/com/subtracker
├── domain/           
├── repository/       
├── service/
│   └── SubscriptionService.java   
├── controller/       
└── dto/              
```

## ▶️ Como Rodar Localmente

```bash
git clone https://github.com/seu-usuario/subtracker.git
cd subtracker

docker run --name subtracker-db -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=subtracker -p 5432:5432 -d postgres:16

./mvnw flyway:migrate
./mvnw spring-boot:run
```

API disponível em `http://localhost:8080`, documentação em `http://localhost:8080/swagger-ui.html`.

## 📄 Licença

MIT
