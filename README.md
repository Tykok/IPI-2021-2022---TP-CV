# IPI-TP-CV

## Objectives

1. Show a list of all users.
2. Create a spring project to show a CV of a given user.
3. Add and endpoint to create an user.

## Database

Before run the project, you need to create a file named ``application.properties`` at the project root.

In this file, add this lines :

````properties
spring.datasource.url=jdbc:mysql://localhost:3306/TP_CV?serverTimezone=UTC
spring.datasource.username=
spring.datasource.password=
````

> Be care, if your local MySQL database is not on the port 3306, you need to change the value of ``spring.datasource.url``.
> Next, you need to add your username and password (if is needed) to connect at the database.

### SQL Script

Previously you create a file for the project, with that file the project could be connect to the database.

Here is the script for the database:

```sql
CREATE DATABASE TP_CV;
use TP_CV;

CREATE TABLE personne(
                         id Int AUTO_INCREMENT,
                         nom VARCHAR(50) NOT NULL,
                         prenom VARCHAR(50) NOT NULL,
                         adresse VARCHAR(50),
                         phone VARCHAR(50),
                         mail VARCHAR(50),
                         date_naissance DATE,
                         presentation VARCHAR(250),
                         job VARCHAR(50),
                         PRIMARY KEY(id)
);

CREATE TABLE skills(
                       id Int AUTO_INCREMENT,
                       titre VARCHAR(50) NOT NULL,
                       type INT NOT NULL,
                       description VARCHAR(150) NOT NULL,
                       notation VARCHAR(50),
                       id_personne INT NOT NULL,
                       PRIMARY KEY(id),
                       FOREIGN KEY(id_personne) REFERENCES personne(id)
);

CREATE TABLE experience(
                           id Int AUTO_INCREMENT,
                           titre VARCHAR(50) NOT NULL,
                           type INT NOT NULL,
                           description VARCHAR(150),
                           date_debut VARCHAR(50),
                           date_fin VARCHAR(50),
                           id_personne INT NOT NULL,
                           PRIMARY KEY(id),
                           FOREIGN KEY(id_personne) REFERENCES personne(id)
);
```

### MERISE - Modèle conceptuel des données
![image](https://user-images.githubusercontent.com/56304246/157238412-738dd02a-a4ce-44fc-bded-12cb5424425b.png)

## Endpoint

All endpoint and all tests are on a [Postman Documentation](https://documenter.getpostman.com/view/12631609/UVsFyo2d "Postman doc").