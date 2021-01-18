DROP DATABASE IF EXISTS bibliotheque;
CREATE DATABASE bibliotheque;
USE bibliotheque;
#**************
# crée table adherent 1e
#**************
create table adherent (
id_adherent int NOT NULL AUTO_INCREMENT,
nom varchar (15) not null,
prenom varchar (15) not null,
naissance date not null,
codePostal char (5) not null,
mail varchar (30) not null,
primary key (id_adherent)) ENGINE = INNODB;

insert into adherent(nom, prenom, naissance, codePostal, mail) 
values ('rouh', 'ro', '2019-01-01', '93650', 'rouh@gmail.com');

insert into adherent(nom, prenom, naissance, codePostal, mail) 
values ('soleman', 'sarah', '1999-01-03', '75000', 'sarah@gmail.com');


#**************
# crée table auteur 4e
#**************
create table auteur (
id_auteur int NOT NULL AUTO_INCREMENT,
nom varchar (60) not null,
prenom varchar (60) not null,
primary key (id_auteur)) ENGINE = INNODB;

insert into auteur (nom, prenom)
values ('Torvalds and Diamond', 'Linux and David');

insert into auteur (nom, prenom)
values ('Orwell', 'George');

#**************
# crée table livre 2e
#**************
create table livre (
identifiant int NOT NULL AUTO_INCREMENT,
titre varchar (20) not null,
id_auteur int,
primary key (identifiant),
 CONSTRAINT fk_livre_auteur foreign key (id_auteur) references auteur (id_auteur)
) ENGINE = INNODB;

insert into livre (titre, id_auteur)
values ('Nineteen Eighty-Four', 1);

insert into livre (titre, id_auteur)
values ('JUST FOR FUN', 2);

#**************
# crée table bibliotheque 3e
#**************
create table bibliotheque (
id int NOT NULL AUTO_INCREMENT,
nom varchar (60) not null,
adress varchar (60) not null,
primary key (id)) ENGINE = INNODB;

insert into bibliotheque (nom, adress)
values ('7 Mars', '2 rue Paris');

insert into bibliotheque (nom, adress)
values ("Bibliotèque publique d'information", '19 rue beaubourg');

#**************
# crée table Exemplaire 5e
#**************
create table exemplaire (
id_exemplaire int NOT NULL AUTO_INCREMENT,
id_adherent int,
editeur varchar (60) not null,
annee_edition date not null,
primary key (id_exemplaire),
 CONSTRAINT fk_exeloplaire_adherent foreign key (id_adherent) references adherent (id_adherent)
) ENGINE = INNODB;

insert into exemplaire (editeur, annee_edition)
values ('Gallimard', '1999-01-03');

insert into exemplaire (editeur, annee_edition)
values ('Xlibris Corp', '2002-07-04');


