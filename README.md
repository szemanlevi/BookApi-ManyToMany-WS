# Spring data JPA task

## Introduction

Implement the following API using spring-data-JPA:

### 1. Create the following entities:

Book:
- id
- title

Author:
- id
- name

### 2. Add some sample data to the database.

- Use hibernate to generate the schema, then use `schema.sql` and `data.sql` files.
- How can you switch between these two modes quickly? (You will need this capability in the following tasks)

#### Example data:
##### Book titles:
  ```
  Bible
  The Decameron
  The Life of Dante
  The Great Gatsby
  The Curious Case of Benjamin Buttons
  ```

##### Authors:
  ```
  Giovanni Bocacchio
  F. Scott Fitzgerald
  ```
### 3. Make the entities queryable through a REST API.
*It's enough to implement `findAll` and `findById` for books and authors.*


### 4. Add a relationship between the two entities:
*One author can have multiple books:*
* a)
    - Add a list of books to the author entity. Use a unidirectional relationship.
    - What ways could you use to connect the tables? Use a foreign key in the `book` table.
    - Use proper names for the FKs
    - Fix the schema and the data files, so the API still works.
* b)
    - Change the relationship to bidirectional.
    - Try to access the REST data through the browser. What happens? How can you fix it?
    - How many solutions can you find for this problem? Compare the differences between the solutions!

### 5. Alter the solution so that one book can also have multiple authors.
- Make sure you have one list of authors in the `Book` entity, and one list of book in the `Author` entity.
- Make sure, the foreign keys are well named
- Add fictional data, so we can see, that one book can have multiple authors.

### 6. Can you research what the famous 'N+1 query problem' is? *(Optional)*
- Can you see it in this project?
- Can you fix it?

### 7. Add an endpoint to save new books, authors
- Add `save` to service
- Add `@PostMapping` handling method to controllers
- How can you handle adding authors to books and vica versa?
- Use Postman to send randomly books with randomly generated titles, and authors with random names

### 8. Document your API with Swagger
- Start [HERE](https://springdoc.org/)

### 9. Add DELETE book endpoints

### 10. Test it with Postman
- send GET for /books
- test if status is 200
- save response length
- send DELETE /book/{id}
- send GET for /books
- check response length is smaller than before

### 11. Test from command line
- install npm
- install newman as global dependency
- export collection from Postman
- run it with newman

### 12. Add validation
- add validation dependency
- use a validation annotation on the title of the `Book` entity
- validate incoming `POST`-s for new books, explore different ways to handle validation errors (3 ways came up already)
- settle with the solution using the `@ExceptionHandler` annotations
- in the json response, send the number of errors, with the name of the fields with their validation messages
- add custom error message for this field
- create a custom validator `NoSingleWord`, that disallows adding a String with a single word
- allow only multiple word titles for `Book` entity

### 13. Add i18n
- [spring documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.internationalization)
- [stackoverflow](https://stackoverflow.com/questions/55220453/how-to-i18n-a-spring-restcontroller-on-java-validation-constraints)