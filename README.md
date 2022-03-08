# IPI-TP-CV

## Objectives

Create a spring project to show a CV, and add somes endpoint used to add value for a user or return an user.

The application need to return a list of all user with each a list of skills and competences.

## SQL Script for the database

```sql
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
   type INT NOT NULL,
   description VARCHAR(150) NOT NULL,
   notation VARCHAR(50),
   id_personne INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_personne) REFERENCES personne(id)
);

CREATE TABLE experience(
   id Int AUTO_INCREMENT,
   type INT NOT NULL,
   description VARCHAR(150),
   date_debut DATE,
   date_fin DATE,
   id_personne INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_personne) REFERENCES personne(id)
);
```
