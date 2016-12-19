# SpringBoot with MySQL connection - Books

## How to use

#### Prerequirements

- Maven 3
- Java 1.8
- working MySQL Server

#### Properties

You have to define/change in the `application.properties` some of details:

  - your MySQL database URL, pointing the correct database table - `spring.datasource.url`
  - your MySQL database username - `spring.datasource.username`
  - your MySQL database password - `spring.datasource.password`

#### To start it up

First from terminal or build configuration: 

`mvn clean install`
    
after that

`mvn spring-boot:run`
    
## Endpoints

#### POST

- `localhost:8080/save` - Saves books to the database. You have to add a `title` and an `author`.

I used **A**dvanced **R**est **C**lient with *Chrome* to send some data as `JSON`*. 

Alternatively you can use any SQL db tool like *HeidiSQL* and add them manually or with SQL commands.

There is an example JSON that you can use with **ARC**:

    {
        "title": "Foo",
        "author": "Bar"
    }
    
*.: To achive that use `Content-Type: application/json` Raw header in **ACR**.
    
#### GET

- `localhost:8080/greetings` - Just says a *"Hello World"*.

- `localhost:8080/book/get/{id}` - Get the book details from `id`.

- `localhost:8080/book/getByTitle/{title}` - Get the book details from `title`. 
