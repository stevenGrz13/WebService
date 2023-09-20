create database solar;
\c solar;

drop table client cascade;
drop table donnees cascade;

create table client(
    id serial not null,
    email varchar(500) not null,
    pass varchar(500) not null,
    primary key(id)
);

insert into client(email,pass) values ('james','j');

create table donnees(
    id serial not null,
    voltage real not null,
    courant real not null,
    energie real not null,
    puissance real not null,
    primary key(id)
);