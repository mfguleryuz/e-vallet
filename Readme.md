CONTENTS OF THIS FILE
---------------------
 * Introduction
 * Requirements
 * Installation
 * Configuration
 * Maintainers


Introduction
------------
This project created for E-Vallet app that customers in database and show customer details.
the project have been crated from two parts 
* first part is frontend app that contains 
reactJs app UI part.
* second part is backend app that springboot project with sqlite.

Application 
* Allow Add/Delete/Update Operations for the Vallet and founds in Vallet
* logging all operations
* founds must be positive check
* citizen id must be unique check


Requirements
------------
* Java - Springboot (Spring Boot DevTools, Spring Data JPA, Spring Web)
* ReactJs (Hooks, Axios HTTP library) , Bootstrap5      
* Sqlite


Installation
------------
* npx create-react-app my-app
    cd my-app
    npm start
* add springboot package


Configuration
------------
* for sqlite add dependency to pom.xml
<dependency>
	<groupId>org.xerial</groupId>
	<artifactId>sqlite-jdbc</artifactId>
</dependency>


Maintainers
------------
Mehmet Fatih Güleryüz