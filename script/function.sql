create sequence sq_matricule start with 1 increment by 1;

create or replace function getMatricule() 
	returns varchar(5)
	language plpgsql
	as $$
	begin 
		return 'EMP'||nextval('sq_matricule');
	end;
$$;

create sequence sq_semaine start with 1 increment by 1;

create or replace function getSemaine()
	returns varchar(20)
	language plpgsql
	as $$
	begin
		return 'Semaine n° '||nextval('sq_semaine');
	end;
$$;