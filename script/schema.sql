create table categorie(
	idCategorie serial primary key,
	nomCategorie varchar(50) not null,
	nbHeureN decimal(10,2) not null check(nbHeureN>0),
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
	nomHS varchar(20) not null,
	nbHeure int not null check(nbHeure>0),
	idHSPrec int ,
	pourcentage decimal(10,2) not null check(pourcentage>=100 and pourcentage<=200),
	foreign key (idHSPrec) references heureSup(idHeureSup)
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

-- Modification J1
create table majoration(
	idmajoration serial primary key,
	nomMaj varchar(20) not null,
	pourcentage decimal(5,2) not null check(pourcentage>=100 and pourcentage<=200)
);


create table semaine(
	idsemaine serial primary key,
	noSemaine varchar(20) not null default getSemaine()
);

create table joursemaine(
	idJoursemaine serial primary key,
	nomJour varchar(20) not null,
	idmajoration int not null,
	foreign key (idmajoration) references majoration(idmajoration)
);

create table pointage(
	idpointage serial primary key,
	idJoursemaine int not null,
	idemploye int not null,
	dureeJour decimal(5,2) not null check(dureeJour>=0 and dureeJour<24),
	dureeNuit decimal(5,2) not null check(dureeNuit>=0 and dureeNuit<24),
	dureeFerier decimal(5,2) not null check(dureeFerier>=0 and dureeFerier<24),
	foreign key (idJourSemaine) references JourSemaine(idJourSemaine),
	foreign key (idemploye) references employe(idemploye)
);