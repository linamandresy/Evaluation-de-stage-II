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


create or replace view nbjour as select idemploye,sum(dureejour) nbJour from pointage where dureeferier=0 and idjoursemaine!=7 group by idemploye;
create or replace view nbnuit as select idemploye,sum(dureenuit) nbNuit from pointage where dureeferier=0 and idjoursemaine!=7 group by idemploye;
create or replace view nbdimanche as select idemploye,case when dureeFerier= 0 then dureenuit+dureejour else 0 end nbdimanche from pointage where idjoursemaine=7;
create or replace view nbft as select idemploye,sum(dureejour+dureenuit) nbft from pointage where  dureeferier>0 group by idemploye;
create or replace view nbf as select idemploye,sum(dureeferier) nbf from pointage where dureeferier>0  group by idemploye;
create or replace view hs  as select employe.idemploye, case when sum(dureejour+dureenuit+dureeferier) - categorie.nbHeureN-nbft>0 then sum(dureejour+dureenuit+dureeferier) - categorie.nbHeureN-nbft else 0 end heuresup from pointage right join employe on pointage.idemploye=employe.idemploye join categorie on employe.idcategorie=categorie.idcategorie join nbft on nbft.idemploye=pointage.idemploye group by employe.idemploye,categorie.nbHeureN,nbft;


create or replace view v_horraire as
	select  
		nbjour.idemploye,
		coalesce(nbjour.nbjour,0) nbjour,
		coalesce(nbnuit.nbnuit,0) nbnuit,
		coalesce(nbdimanche.nbdimanche,0) nbdimanche,
		coalesce(nbft.nbft,0) nbft,
		coalesce(nbf.nbf,0) nbf,
		coalesce(hs.heuresup,0) heuresup
	from hs 
	left join nbnuit on hs.idemploye=nbnuit.idemploye
	left join nbdimanche on hs.idemploye=nbdimanche.idemploye
	left join nbft on hs.idemploye=nbft.idemploye
	left join nbf on hs.idemploye=nbf.idemploye
	left join nbjour on hs.idemploye=nbjour.idemploye;