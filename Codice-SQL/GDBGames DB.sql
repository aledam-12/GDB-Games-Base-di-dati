drop schema if exists gdbgames;
create schema gdbgames;
use GDBGAMES;
create table cliente (
email varchar (64) primary key,
nome varchar (32),
cognome varchar (32),
pw char (128) /*si deve memorizzare l'hashing */
);
create table acquisto (
emailCliente //da mod
nCarta numeric(10),
nFattura int primary key auto_increment,
dataAcquisto date,
via varchar(32),
cap numeric(5),
città varchar (16),
prezzoTotale numeric(7,2)
);
create table genere (
nome varchar (32) primary key
);
create table console (
nome varchar (32) primary key
);
create table videogioco (
console char(16),
titolo varchar (64) primary key,
descrizione varchar (512),
pegi numeric (2)
check (pegi >= 3 AND pegi <= 18)
);
create table distinzione (
titoloVideogioco varchar (64),
nomeGenere varchar(32),
primary key (nomeGenere, titoloVideogioco),
foreign key (titoloVideogioco) references videogioco(titolo)
on update cascade
on delete cascade,
foreign key (nomeGenere) references genere(nome)
on update cascade 
on delete restrict
);
create table copia (
percIva numeric (5,2)
stato boolean,
prezzo numeric(5,2),
codiceCopia int primary key auto_increment,
codiceAcquisto int,
titoloVideogioco varchar (64),
nomeConsole varchar (32),
foreign key (codiceAcquisto) references acquisto(nFattura)
on update cascade
on delete restrict,
foreign key (titoloVideogioco) references videogioco(titolo)
on update cascade
on delete restrict,
foreign key (nomeConsole) references console(nome)
on update cascade
on delete restrict
);
create table reclamo (
dataReclamo date,
nReclamo int primary key auto_increment,
titolo varchar(32),
contenuto varchar (1024),
emailCliente varchar (64),
foreign key (emailCliente) references cliente(email)
on update cascade
on delete cascade
);

