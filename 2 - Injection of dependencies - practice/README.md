# Spring Boot Project Practice  

## Topics Covered  

- Created a new project using **Spring Initializr** with the dependencies: **Spring Web, DevTools, Actuator, and Lombok**. 
- Created the packages: **controllers, services, repositories, and models** to practice **IoC (Inversion of Control) and DI (Dependency Injection)**. 
- Practiced returning data from the controller using a **list from the repositories package**, which simulates a database. 
- Practiced the **principle of immutability**. 
- Practiced the **principle of immutability** using the **Clonable** interface.  
- Created **interfaces** for the classes in the `services` and `repositories` packages to improve **decoupling** when injecting them.  
- Explained the **Spring container** and **Dependency Injection**.  
- Applied **Dependency Injection** using `@Component` and `@Autowired`, but later replaced `@Component` with specialized annotations like `@Service` and `@Repository`.  
- Practiced injecting dependencies through **attributes, setter methods, and constructors**, using **interfaces** for better decoupling.  
- Explained how and when to use the annotations `@Primary` and `@Qualifier`.  
- Explained and practiced the annotations `@RequestScope` and `@SessionScope`.  
- Reviewed multiple concepts, such as **injecting values from `.properties` files**.  
- Practiced creating a class to **read JSON files**.  
- Practiced injecting the JSON reader class **without using an annotation derived from `@Component`**, but instead using `@Bean`.  

## Annotations Covered

- `@Service`
- `@Repository`
- `@Componen`
- `@Autowired`
- `@Primary`
- `@Qualifier`
- `@RequestScope`
- `@SesionScope`
- `@Bean`
