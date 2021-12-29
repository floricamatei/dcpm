## Microservices - Circuit Breaker Pattern

### Bibliografie

M-am inspirat / influentat din:

- cursul "Data and Communication Patterns for Microservices" a lui Thorben Janssen (https://thorben-janssen.com)
- https://spring.io/projects/spring-cloud-circuitbreaker
- https://alistair.cockburn.us/hexagonal-architecture/
- https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
- https://medium.com/geekculture/design-patterns-for-microservices-circuit-breaker-pattern-276249ffab33
- https://medium.com/javarevisited/handling-http-client-errors-with-feign-and-hystrix-523e2dd8eb35
- diagramele au fost realizate utilizand https://app.diagrams.net/

###

Cum am vazut in prezentarea precedenta intr-o aplicatie bazata pe microservicii acestea schiba date utilizand API

### Circuit Breaker Pattern

- am utilizat libraria resilience4j - https://github.com/resilience4j/resilience4j/
- am utilizat libraria OpenFeign - https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/
