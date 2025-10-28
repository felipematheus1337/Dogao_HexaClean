# 🌭 Dogão-HexaClean

**Dogão-HexaClean** é um projeto didático composto por **dois microsserviços independentes** — **Pedidos** e **Pagamentos** — para praticar **Clean Architecture**, **Hexagonal Architecture**, **mensageria com Kafka** e **padrões de resiliência** como *Retry*, *Circuit Breaker* e *Idempotência*.

---

## 🧩 Estrutura do Projeto

| Microsserviço | Arquitetura | Responsabilidade | Banco | Kafka | Papel |
|----------------|--------------|------------------|--------|--------|-------|
| 🧾 `order-service` | Clean Architecture | Gerenciar pedidos (criar, listar, atualizar status) | PostgreSQL | Publisher + Subscriber | Publica `pedido.criado` e consome `pagamento.processado` |
| 💳 `payment-service` | Hexagonal Architecture | Processar pagamentos e retornar resultado | MongoDB | Subscriber + Publisher | Consome `pedido.criado` e publica `pagamento.processado` |

---

## ⚙️ Tecnologias

- **Java 17+**
- **Spring Boot 3**
- **Spring Kafka**
- **OpenFeign (futuro uso)**
- **Spring Data JPA / MongoDB**
- **Resilience4j** (Circuit Breaker / Retry)
- **Docker Compose** (para Kafka e bancos)
- **JUnit / Testcontainers**

---

## 🧠 Fluxo da Aplicação

| Etapa | Quem age | O que acontece |
|--------|-----------|----------------|
| 1️⃣ | Cliente → OrderService | Cria um pedido via REST |
| 2️⃣ | OrderService → Kafka | Publica `pedido.criado` |
| 3️⃣ | PaymentService (listener) | Recebe o evento e processa o pagamento |
| 4️⃣ | PaymentService → Kafka | Publica `pagamento.processado` |
| 5️⃣ | OrderService (consumer) | Atualiza o status do pedido |
| 6️⃣ | Cliente | Pode consultar o pedido atualizado |


🏗️ Domínios e Casos de Uso
🧾 Order Service (Clean Architecture)

CriarPedidoUseCase

CancelarPedidoUseCase

ConsultarPedidosUseCase

AtualizarStatusPedidoUseCase (a partir de evento Kafka)

💳 Payment Service (Hexagonal)

ProcessarPagamentoUseCase (consome pedido.criado)

RegistrarPagamentoUseCase

PublicarResultadoPagamentoUseCase (publica pagamento.processado)

🔄 Comunicação Assíncrona (Kafka)
Tópico	Publisher	Subscriber	Payload Exemplo
pedido.criado	Order Service	Payment Service	{ "pedidoId": 123, "valor": 35.50, "cliente": "Felipe" }
pagamento.processado	Payment Service	Order Service	{ "pedidoId": 123, "status": "APROVADO" }

💡 Padrões de Resiliência
Padrão	Local de Aplicação	Objetivo
🔁 Retry	Publicação Kafka no Payment Service	Reenvio de evento em falha temporária
🧱 Circuit Breaker	Feign client (futuro)	Evitar sobrecarga em serviço externo
🆔 Idempotência	Consumer de pedido.criado no Payment Service	Evitar reprocessamento de pedidos duplicados
🧪 Como Executar
Pré-requisitos

Docker e Docker Compose

Java 17+

Maven

# Subir infraestrutura (Kafka + bancos)
docker-compose up -d

# Rodar o Order Service
cd order-service
mvn spring-boot:run

# Rodar o Payment Service
cd payment-service
mvn spring-boot:run




