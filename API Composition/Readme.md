## Microservices - API Composition Pattern

### Prefata

In prezentarea de azi m-am inspirat / influentat din:
- prezentarea "Hexagonal Architecture" care are link in mailul trimis de Bogdan Ardeleanu.
- prezentarea lui Gabi Vaduva cu docker
- prezentarea lui George cu Open API
- un curs a lui Thorben Janssen.

### Monoliths vs Microservices

Se gasesc numeroase articole pe tema Monoliths vs Microservices.

Reguli de baza pentru persistenta datelor:
 1. Fiecare serviciu trebuie să aibă propria sa bază de date.

 2. Un serviciu își cunoaște doar propria bază de date.

 3. Nu se folosesc transactii distribuite
 
 4. De fiecare dată când actualizați microserviciul, trebuie să actualizați automat baza de date.

### API Composition Pattern
Paternul API Composition este aplicabil in operatiile de citire ale nivelului de persistenta.

![](https://github.com/dgpavel/dcpm/blob/main/API%20Composition/api-composition.jpg)

- OrderInfoService trebuie sa stie adresa IP si numarul de port la celelalte 3 servicii.
- daca oricare din OrderService, BookService, InventoryService, ReviewService pica atunci si OrderInfoService pica
- daca oricare din OrderService, BookService, InventoryService, ReviewService raspunde greu si OrderInfoService va raspunde greu


### Hexagonal Architecture
In realizarea fiecarui microserviciu am aplicat principiile arhitecturii hexagonale.

![](https://github.com/dgpavel/dcpm/blob/main/API%20Composition/bookservice-hexagonal.jpg)

### Concluzii si intrebari
Merita efortul abordari arhitecturii bazate pe microservici?

Merita efortul unei arhitecturi hexagonale?

