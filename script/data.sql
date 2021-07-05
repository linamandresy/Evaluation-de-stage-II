insert into
	utilisateur(logins, passwords, admins)
values
	(
		'lina',
		'7c4a8d09ca3762af61e59520943dc26494f8941b',
		't'
	);

insert into
	utilisateur(logins, passwords)
values
	(
		'rojo',
		'7c4a8d09ca3762af61e59520943dc26494f8941b'
	);

-- Modification J1
insert into
	majoration(nomMaj,pourcentage)
values
	(
		'Nuit HM30',
		130
	);

	
insert into
	majoration(nomMaj,pourcentage)
values
	(
		'Dimanche HM40',
		140
	);

insert into
	majoration(nomMaj,pourcentage)
values
	(
		'Férier HM50',
		150
	);

insert into
	majoration(nomMaj,pourcentage)
values
	(
		'Normal HM0',
		100
	);

insert into joursemaine(nomjour,idmajoration) values ('Lundi Jour',4);
insert into joursemaine(nomjour,idmajoration) values ('Mardi Jour',4);
insert into joursemaine(nomjour,idmajoration) values ('Mercredi Jour',4);
insert into joursemaine(nomjour,idmajoration) values ('Jeudi Jour',4);
insert into joursemaine(nomjour,idmajoration) values ('Vendredi Jour',4);
insert into joursemaine(nomjour,idmajoration) values ('Samedi Jour',4);
insert into joursemaine(nomjour,idmajoration) values ('Dimanche Jour',2);
insert into joursemaine(nomjour,idmajoration) values ('Lundi Nuit',1);
insert into joursemaine(nomjour,idmajoration) values ('Mardi Nuit',1);
insert into joursemaine(nomjour,idmajoration) values ('Mercredi Nuit',1);
insert into joursemaine(nomjour,idmajoration) values ('Jeudi Nuit',1);
insert into joursemaine(nomjour,idmajoration) values ('Vendredi Nuit',1);
insert into joursemaine(nomjour,idmajoration) values ('Samedi Nuit',1);
insert into joursemaine(nomjour,idmajoration) values ('Dimanche Nuit',2);