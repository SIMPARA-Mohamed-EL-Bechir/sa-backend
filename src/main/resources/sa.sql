CREATE DATABASE SA;

create table CLIENT(
    ID integer primary key not null AUTO_INCREMENT,
    EMAIL varchar(50) unique
);

create table SENTIMENT(
    ID integer primary key not null AUTO_INCREMENT,
    TEXTE varchar(50),
    TYPE varchar(15),
    CLIENT_ID integer,
    constraint clientid_fk foreign key (CLIENT_ID) REFERENCES CLIENT(ID)
);