create table categorie(
	idCategorie serial primary key,
	nomCategorie varchar(50) not null,
	nbHeureN decimal(4,2) not null check(nbHeureN>0),
	salaireHN decimal(10,2) not null check(salaireHN>0),
	indamnite decimal(10,2) not null check(indamnite>0 and indamnite<salaireHN)
);


create table employe(
	idemploye serial primary key,
	nom varchar(50) not null,
	prenom varchar(50),
	matricule varchar(5) not null default getMatricule() unique,
	naissance date not null,
	embauche date not null,
	fincontrat date not null check(embauche<fincontrat),
	idCategorie int not null,
	foreign key (idCategorie) references categorie(idCategorie)
);

create table heureSup(
	idHeureSup serial primary key,
	nbHeure int not null check(nbHeure>0),
	idHSPrec int ,
	foreign key (idHSPrec) references heureSup(idHeureSup)
);

create table repetition(
	idRepetition serial primary key,
	nomRepetition varchar(20) not null,
	delaiRepetition decimal(10,2) not null
);

create table heureMajoration(
	idMajoration serial primary key,
	nomMajoration varchar(50) not null,
	dateMaj timestamp not null,
	delai decimal not null,
	pourcentage decimal not null check(pourcentage>=0 and pourcentage<=100),
	idRepetition int ,
	foreign key(idRepetition) references repetition(idRepetition)
);

create table pointage(
	idPointage serial primary key,
	idemploye int not null,
	pointe timestamp not null
);


create table utilisateur(
	idUtilisateur serial primary key,
	logins varchar(50) not null,
	passwords varchar(40) not null,
	admins boolean not null default 'f'
);

create table token(
	token varchar(40) primary key,
	idUtilisateur int not null,
	expiration timestamp not null,
	foreign key (idUtilisateur) references utilisateur(idUtilisateur)
);
