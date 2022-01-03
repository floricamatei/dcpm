## Microservices - Circuit Breaker Pattern

### Bibliografie

M-am inspirat / influentat din:

- cursul "Data and Communication Patterns for Microservices" a lui Thorben Janssen (https://thorben-janssen.com)
- https://docs.microsoft.com/en-us/azure/architecture/patterns/circuit-breaker
- https://medium.com/geekculture/design-patterns-for-microservices-circuit-breaker-pattern-276249ffab33
- diagramele au fost realizate utilizand https://app.diagrams.net/

### Context si problema

Suntem in contextul aceleiasi aplicatii din prezentarea API Composition Pattern. Protocolul HTTP este utilizat la comunicarea intre microservicii. Apelul catre un microserviciu este sincron. Dupa ce s-a trimis o cerere trebuie sa se astepte sa vina raspunsul. Uneori asta ar putea dura o perioada lunga de timp.

![](https://github.com/dgpavel/dcpm/blob/main/Circuit%20Breaker/context-problem.jpg)

### Microservicii si REST API 404 - Missing Resource

- feign.FeignException$NotFound

### Circuit Breaker Pattern

- am utilizat libraria resilience4j - https://github.com/resilience4j/resilience4j, https://spring.io/projects/spring-cloud-circuitbreaker
- am utilizat libraria OpenFeign - https://github.com/OpenFeign/feign, https://spring.io/projects/spring-cloud-openfeign

Browser -> BookService -> ReviewService: Circuit Breaker - dezactivat + ReviewService - oprit. Obtinem:

- consola BookService: java.net.ConnectException: Connection refused: no further information
- browser: Internal Server Error, status=500

Browser -> BookService -> ReviewService: Circuit Breaker - dezactivat + ReviewService - timp lung de raspuns. Obtinem:

- timp lung de raspuns
- browser: {"id":1,"title":"Hibernate Tips - More than 70 solutions to common Hibernate problems","authors":"Thorben Janssen","reviews":[{"message":"If you are working with Hibernate ORM, Thorben's book should be on your desk. Excellent contents, presented in a very practical FAQ-style format.A copy of Hibernate Tips should be given to each developer when joining a project using Hibernate","writtenBy":"Gunnar Morling, Open Source Software Engineer"},{"message":"Thorben's book tackles real world tasks and problems that arise during development with Hibernate. The table of contents reads like a best-of-Hibernate-questions that have been asked during everyday development, from getting started to harder problems.","writtenBy":"Michael Simons, Senior Developer"}]}

Browser -> BookService -> ReviewService: Circuit Breaker - activat + ReviewService - oprit. Obtinem:

- consola BookService: java.net.ConnectException: Connection refused: no further information
- timp rapid de raspuns
- browser: {"id":1,"title":"Hibernate Tips - More than 70 solutions to common Hibernate problems","authors":"Thorben Janssen","reviews":[]}

Browser -> BookService -> ReviewService: Circuit Breaker - activat + ReviewService - timp lung de raspuns. Obtinem:

- consola BookService: java.util.concurrent.TimeoutException: TimeLimiter 'ReviewServiceClient#getReviewsForBook(Long)' recorded a timeout exception.
- timp rapid de raspuns
- browser: {"id":1,"title":"Hibernate Tips - More than 70 solutions to common Hibernate problems","authors":"Thorben Janssen","reviews":[]}

Browser -> OrderInfoService: Circuit Breaker - dezactivat + @RestControllerAdvice nu trateaza FeignException$NotFound + OrderService raspunde cu 404.

- consola OrderInfoService: feign.FeignException$NotFound: [404] during [GET] to [http://localhost:7070/api/v1/orders/78] [OrderServiceClient#getOrder(Long)]. with root cause feign.FeignException$NotFound
- browser: Internal Server Error, status=500

Browser -> OrderInfoService: Circuit Breaker - dezactivat + @RestControllerAdvice trateaza FeignException$NotFound + OrderService raspunde cu 404.

- consola OrderInfoService: feign.FeignException$NotFound: [404] during [GET] to [http://localhost:7070/api/v1/orders/78] [OrderServiceClient#getOrder(Long)]. with root cause feign.FeignException$NotFound
- browser: {"timestamp":"2022-01-03T11:00:23.8841437","status":"NOT_FOUND","message":"[404] during [GET] to [http://localhost:7070/api/v1/orders/78] [OrderServiceClient#getOrder(Long)]: [{\"timestamp\":\"2022-01-03T11:00:23.8631417\",\"status\":\"NOT_FOUND\",\"message\":\"The resource was not found by given identifier\",\"validations\":null,\"details\":\"uri=/api/v1/orders/78\"}]","validations":null,"details":"uri=/api/v1/orderinfo/78"}

Browser -> OrderInfoService: Circuit Breaker - activat + @RestControllerAdvice nu trateaza FeignException$NotFound + OrderService raspunde cu 404.

- consola OrderInfoService: org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException: No fallback available. with root cause feign.FeignException$NotFound
- browser: Internal Server Error, status=500

Browser -> OrderInfoService: Circuit Breaker - activat + @RestControllerAdvice trateaza FeignException$NotFound + OrderService raspunde cu 404.

- consola OrderInfoService: feign.FeignException$NotFound: [404] during [GET] to [http://localhost:7070/api/v1/orders/78] ... at org.springframework.cloud.openfeign.FeignCircuitBreakerInvocationHandler.lambda$asSupplier$1(FeignCircuitBreakerInvocationHandler.java:112)
- browser: {"timestamp":"2022-01-03T11:00:23.8841437","status":"NOT_FOUND","message":"[404] during [GET] to [http://localhost:7070/api/v1/orders/78] [OrderServiceClient#getOrder(Long)]: [{\"timestamp\":\"2022-01-03T11:00:23.8631417\",\"status\":\"NOT_FOUND\",\"message\":\"The resource was not found by given identifier\",\"validations\":null,\"details\":\"uri=/api/v1/orders/78\"}]","validations":null,"details":"uri=/api/v1/orderinfo/78"}

### Concluzii și întrebări

Merita efortul abordari arhitecturii bazate pe microservici?

"Don’t Start With Microservices – Monoliths Are Your Friend" - https://arnoldgalovics.com/microservices-in-production/
