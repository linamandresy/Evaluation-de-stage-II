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

insert into joursemaine(nomjour,idmajoration) values ('Lundi',4);
insert into joursemaine(nomjour,idmajoration) values ('Mardi',4);
insert into joursemaine(nomjour,idmajoration) values ('Mercredi',4);
insert into joursemaine(nomjour,idmajoration) values ('Jeudi',4);
insert into joursemaine(nomjour,idmajoration) values ('Vendredi',4);
insert into joursemaine(nomjour,idmajoration) values ('Samedi',4);
insert into joursemaine(nomjour,idmajoration) values ('Dimanche',2);