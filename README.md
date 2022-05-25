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
