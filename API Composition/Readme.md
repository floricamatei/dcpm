## Microservices - API Composition Pattern

### Bibliografie

M-am inspirat / influentat din:

- cursul "Data and Communication Patterns for Microservices" a lui Thorben Janssen (https://thorben-janssen.com).
- https://microservices.io/patterns/data/api-composition.html
- diverse articole despre "Hexagonal Architecture".
- https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
- diagramele au fost realizate utilizand https://app.diagrams.net/

### Monoliths vs Microservices

Se gasesc numeroase articole pe tema Monoliths vs Microservices.

Microservices - Reguli de baza pentru persistenta datelor:

1.  Fiecare serviciu trebuie să aibă propria sa bază de date.

2.  Un serviciu își cunoaște doar propria bază de date.

3.  Nu se folosesc transactii distribuite

4.  De fiecare dată când actualizați microserviciul, trebuie să actualizați automat baza de date daca este cazul (Liquibase, Flyway).

### Database per service Pattern

- https://microservices.io/patterns/data/database-per-service.html

### API Composition Pattern

![](https://github.com/dgpavel/dcpm/blob/main/API%20Composition/api-composition.jpg)

- OrderInfoService trebuie sa stie adresa IP si numarul de port la celelalte 3 servicii.
- daca oricare din OrderService, BookService, InventoryService, ReviewService pica atunci si OrderInfoService pica
- daca oricare din OrderService, BookService, InventoryService, ReviewService raspunde greu si OrderInfoService va raspunde greu
- BookService nu este optimizat pentru nevoile lui OrderInfoService (review-urile nu sunt necesare)

### Hexagonal Architecture

In realizarea fiecarui microserviciu am aplicat principiile arhitecturii hexagonale.

![](https://github.com/dgpavel/dcpm/blob/main/API%20Composition/bookservice-hexagonal.jpg)

### Concluzii si intrebari

Merita efortul abordari arhitecturii bazate pe microservici?

Merita efortul unei arhitecturi hexagonale?

"There is no Kubernetes, no microservices, no hexagonal architecture, no DDD, no CQRS, no Event Sourcing, no Kafka, and not any of the popular NoSQL databases. Just a three-tier monolith that uses MySQL." - https://vladmihalcea.com/revogain-software-architecture/
