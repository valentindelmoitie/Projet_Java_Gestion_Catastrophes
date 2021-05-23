insert into country (`name`,is_underdeveloped,is_in_war) values('Belgique',false, false);
insert into country (`name`,is_underdeveloped,is_in_war) values('France',false, false);
insert into country (`name`,is_underdeveloped,is_in_war) values('Ukraine',false, true);
insert into country (`name`,is_underdeveloped,is_in_war) values('Burundi',true, false);
insert into country (`name`,is_underdeveloped,is_in_war) values('Autriche',false, false);
insert into country (`name`,is_underdeveloped,is_in_war) values('Pologne',false, false);
insert into country (`name`,is_underdeveloped,is_in_war) values('Suisse',false, false);

insert into region (`name`, population,is_warzone) values('Wallonie',3600000, false);
insert into region (`name`, population,is_warzone) values('Flandre',6500000, false);
insert into region (`name`, population,is_warzone) values('Bruxelles',174000, false);
insert into region (`name`, population,is_warzone) values('Haut de france',6000000, false);
insert into region (`name`, population,is_warzone) values('Ile de france',12200000, false);
insert into region (`name`, population,is_warzone) values('Bretagne',3200000, false);
insert into region (`name`, population,is_warzone) values('Kiev',1700000, false);
insert into region (`name`, population,is_warzone) values('Louhansk',2200000, true);
insert into region (`name`, population,is_warzone) values('Donetsk',4400000, true);
insert into region (`name`, population,is_warzone) values('Bururi',440000, false);
insert into region (`name`, population,is_warzone) values('Karuzi',600000, false);
insert into region (`name`, population,is_warzone) values('Rutana',450000, false);
insert into region (`name`, population,is_warzone) values('Basse-Autriche',457000, false);
insert into region (`name`, population,is_warzone) values('Haute-Autriche',336000, false);
insert into region (`name`, population,is_warzone) values('Salzbourg',280000, false);
insert into region (`name`, population,is_warzone) values('Cujavie-Poméranie',480000, false);
insert into region (`name`, population,is_warzone) values('Lublin',1260000, false);
insert into region (`name`, population,is_warzone) values('Silésie',400000, false);
insert into region (`name`, population,is_warzone) values('Opole',80000, false);
insert into region (`name`, population,is_warzone) values('Zurich',1248000, false);
insert into region (`name`, population,is_warzone) values('Suisse orientale',104800, false);
insert into region (`name`, population,is_warzone) values('Espace Mittelland',169000, false);

insert into location (region, country) values('Wallonie','Belgique');
insert into location (region, country) values('Flandre','Belgique');
insert into location (region, country) values('Bruxelles','Belgique');
insert into location (region, country) values('Haut de france','France');
insert into location (region, country) values('Ile de france','France');
insert into location (region, country) values('Bretagne','France');
insert into location (region, country) values('Kiev','Ukraine');
insert into location (region, country) values('Louhansk','Ukraine');
insert into location (region, country) values('Donetsk','Ukraine');
insert into location (region, country) values('Bururi','Burundi');
insert into location (region, country) values('Karuzi','Burundi');
insert into location (region, country) values('Rutana','Burundi');
insert into location (region, country) values('Basse-Autriche','Autriche');
insert into location (region, country) values('Haute-Autriche','Autriche');
insert into location (region, country) values('Salzbourg','Autriche');
insert into location (region, country) values('Cujavie-Poméranie','Pologne');
insert into location (region, country) values('Lublin','Pologne');
insert into location (region, country) values('Silésie','Pologne');
insert into location (region, country) values('Opole','Pologne');
insert into location (region, country) values('Zurich','Suisse');
insert into location (region, country) values('Suisse orientale','Suisse');
insert into location (region, country) values('Espace Mittelland','Suisse');

insert into hospital (`name`, maximum_capacity,address,specialization, region) values('GHDC',720,'Rue Marguerite Depasse 6, 6060 Charleroi','Cardiologie','Wallonie');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('CHU UCL Namur',400,'Place Louise Godin 15, 5000 Namur','Cardiologie','Wallonie');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('CHU Brugmann',620,'Rue Bruyn 1, 1120 Bruxelles',null,'Bruxelles');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('AZ Groeninge',835,'President Kennedylaan 4, 8500 Kortrijk','Soins intensifs','Flandre');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('CLINEA',515,'1 Rue du Fort, 59720 Louvroil, France','Imagerie','Haut de france');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Centre Hospitalier Avesnes',315,'46 Route Haut Lieu, 59440 Avesnes-sur-Helpe, France',null,'Haut de france');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Hopital Albert Chenevier',715,'40 Rue de Mesly, 94000 Creteil, France',null,'Ile de france');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Centre Hospitalier de Saint-Denis',965,'2 Rue du Dr Delafontaine, 93200 Saint-Denis, France','Soins intensifs','Ile de france');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Hopital du Scorff',365,'5 Avenue Choiseul, 56322 Lorient, France',null,'Bretagne');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('American Medical Centers Kiev',1215,'Berdychivska street 1 , Kiev 04116 , Ukraine',null,'Kiev');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Children Hospital',115,'Radianska St, 68, Luhansk, Luhansk Oblast, Ukraine, 91000',null,'Louhansk');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Dorozhnya Klinichna Likarnya Na St. Donetsk',315,'Universytetska St, 60, Donetsk, Donetsk Oblast, Ukraine, 83000','Cardiologie','Donetsk');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Donetske Klinichne',75,'Illicha Ave, 14, Donetsk, Donetska oblast, Ukraine, 83000',null,'Donetsk');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('BUMEREC',720,'Avenue du Cercle-Nautique, Bujumbura, Burundi',null,'Bururi');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Kira Hospital',470,'Ave Nzero, Bujumbura, Burundi',null,'Rutana');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Hopital de Bubanza',150,'RN9, Bubanza, Burundi','Soins intensifs','Rutana');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Spring Grove Community Hospital',570,'3380, Basse-Autriche, Bezirk Melk, Gemeinde Pöchlarn, Ornding','Cardiologie','Basse-Autriche');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Beacon Clinic',430,'7141, Burgenland, Bezirk Neusiedl am See, Podersdorf am See',null,'Haute-Autriche');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Griffin Medical Clinic',475,'8132, Styrie, Bezirk Bruck-Mürzzuschlag, Roßgraben','Imagerie','Salzbourg');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Rosewood General Hospital',220,'6170, Tyrol, Bezirk Innsbruck-Land, Marktgemeinde Zirl',null,'Salzbourg');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Peace Forest Hospital',357,'36-106, Basses-Carpates, Kolbuszowa',null,'Cujavie-Poméranie');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Marine Clinic',400,'26-080, Sainte-Croix, Kielce County',null,'Cujavie-Poméranie');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Parkview Clinic',800,'73-120, Poméranie occidentale, Stargard County, gmina Chociwel, Chociwel','Soins intensifs','Silésie');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Hope Garden Clinic',120,'Basse-Silésie, Lubin County, gmina',null,'Silésie');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Pioneer General Hospital',360,'38-247, Petite-Pologne, Tarnow County, gmina Szerzyny','Imagerie','Silésie');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Lifecare Clinic',410,'23-425, Voïvodie de Lublin, Bilgoraj County',null,'Opole');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Pearl River Medical Center',70,'3454, Berne, Arrondissement administratif de Emmental, Sumiswald','Imagerie','Zurich');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Bellevue Hospital Center',450,'8154, Zurich, Bezirk Dielsdorf, Hofstetten','Soins intensifs','Zurich');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Harmony Hospital',230,'9442, Saint-Gall, Wahlkreis Rheintal, Berneck',null,'Espace Mittelland');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Kindred Clinic',270,'1527, Fribourg, District de la Broye, Villeneuve (FR)','Cardiologie','Espace Mittelland');

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('catastrophe nucléaire de Tchernobyl','Nucléaire','Accident nucléaire majeur', str_to_date ('26-apr-1986','%e-%b-%Y'),null,7,200000,50,4000,false);
insert into dangerous_site (`type`,`description`,manager,region) 
values ('Nucléaire','Centrale nucléaire de Tchernobyl','Gouvernement Ukrainien','Kiev');
insert into danger(dangerous_site,disaster) values (1, 1);
insert into impact_location (disaster, region) values (1,'Kiev');
insert into impact_location (disaster, region) values (1,'Louhansk');
insert into impact_location (disaster, region) values (1,'Donetsk');
insert into `help` (disaster, hospital) values(1, 10);
insert into `help` (disaster, hospital) values(1, 11);
insert into `help` (disaster, hospital) values(1, 13);

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Feux de fôret Tchernobyl','Incendie','Incendie de forêt autour de la centrale nucléaire de Tchernobyl', str_to_date ('04-apr-2020','%e-%b-%Y'),str_to_date ('14-apr-2020','%e-%b-%Y'),null,20,0,0,false);
insert into danger(dangerous_site,disaster) values (1, 2);
insert into impact_location (disaster, region) values (2,'Kiev');

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Naufrage du Herald of Free Enterprise','Naufrage','Navire chavire au large du port de Zeebruges',str_to_date ('06-mar-1987','%e-%b-%Y'),null,null,1000,193,0,false);
insert into dangerous_site (`type`,`description`,manager,region) 
values ('Naturel','Mer du nord',null,'Flandre');
insert into danger(dangerous_site,disaster) values (2,3);
insert into impact_location (disaster, region) values (3,'Flandre');
insert into `help` (disaster, hospital) values(3, 4);

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Naufrage lac Tanganyika','Naufrage','Naufrage en raison du mauvais temps et surcharge importante',str_to_date ('24-mar-2003','%e-%b-%Y'),null, null,150,109,0,false);
insert into dangerous_site (`type`,`description`,manager,region) 
values ('Naturel','Lac Tanganyika',null,'Bururi');
insert into danger(dangerous_site,disaster) values (3, 4);
insert into impact_location (disaster, region) values (4,'Bururi');
insert into `help` (disaster, hospital) values(4, 14);
insert into `help` (disaster, hospital) values(4, 16);

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Tempête de 1987','Ouragan','Tempête synoptique automnale',str_to_date ('15-oct-1987','%e-%b-%Y'),null, 3,1250000,15,0,true);
insert into dangerous_site (`type`,`description`,manager,region) 
values ('Nucléaire','Usine de retraitement de la Hague','Orano','Haut de france');
insert into dangerous_site (`type`,`description`,manager,region) 
values ('Nucléaire','Centrale nucléaire de Doel','Engie','Flandre');
insert into dangerous_site (`type`,`description`,manager,region) 
values ('Industriel','Usine de traitement chimique',null,'Flandre');
insert into danger(dangerous_site,disaster) values(4,5);
insert into danger(dangerous_site,disaster) values(5,5);
insert into danger(dangerous_site,disaster) values(6,5);
insert into impact_location (disaster, region) values (5,'Haut de france');
insert into impact_location (disaster, region) values (5,'Bretagne');
insert into impact_location (disaster, region) values (5,'Ile de france');
insert into impact_location (disaster, region) values (5,'Flandre');
insert into impact_location (disaster, region) values (5,'Bruxelles');
insert into impact_location (disaster, region) values (5,'Wallonie');
insert into `help` (disaster, hospital) values(5, 2);
insert into `help` (disaster, hospital) values(5, 3);
insert into `help` (disaster, hospital) values(5, 5);
insert into `help` (disaster, hospital) values(5, 7);

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Pandémie de Covid-19 en Suisse','Humanitaire','Crise sanitaire',str_to_date ('01-mar-2020','%e-%b-%Y'),null, null,1500000,8563,0,true);
insert into impact_location (disaster, region) values (6,'Zurich');
insert into impact_location (disaster, region) values (6,'Suisse orientale');
insert into impact_location (disaster, region) values (6,'Espace Mittelland');
insert into `help` (disaster, hospital) values(6, 28);
insert into `help` (disaster, hospital) values(6, 29);
insert into `help` (disaster, hospital) values(6, 30);

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Pandémie de Covid-19 en Belgique','Humanitaire','Crise sanitaire',str_to_date ('01-mar-2020','%e-%b-%Y'),null, null,10000000,24609,0,true);
insert into impact_location (disaster, region) values (7,'Flandre');
insert into impact_location (disaster, region) values (7,'Bruxelles');
insert into impact_location (disaster, region) values (7,'Wallonie');
insert into `help` (disaster, hospital) values(7, 1);
insert into `help` (disaster, hospital) values(7, 2);
insert into `help` (disaster, hospital) values(7, 3);
insert into `help` (disaster, hospital) values(7, 4);

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Accident du funiculaire de Kaprun','Incendie','Incendie dans un tunnel',str_to_date ('11-nov-2000','%e-%b-%Y'),null, null,167,155,0,false);
insert into impact_location (disaster, region) values (8,'Basse-Autriche');
insert into `help` (disaster, hospital) values(8, 17);
insert into `help` (disaster, hospital) values(8, 18);

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Accident ferroviaire de Szczekociny','Industriel','Collision entre 2 trains',str_to_date ('03-mar-2012','%e-%b-%Y'),null, null,70,16,0,false);
insert into impact_location (disaster, region) values (9,'Silésie');
insert into `help` (disaster, hospital) values(9, 23);
insert into `help` (disaster, hospital) values(9, 24);

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Explosion de gaz de Ghislenghien','Industriel','Explosion de conduite de gaz',str_to_date ('30-jul-2004','%e-%b-%Y'),null,null,160,24,0,false);
insert into dangerous_site (`type`,`description`,manager,region) 
values ('Industriel','Zone industrielle de Ghislenghien',null,'Wallonie');
insert into danger(dangerous_site,disaster) values (7,10);
insert into impact_location (disaster, region) values (10,'Wallonie');
insert into `help` (disaster, hospital) values(10, 2);

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Catastrophe du Bois du Cazier','Incendie','Incendie dans une mine',str_to_date ('08-aug-1956','%e-%b-%Y'),null,null,600,262,200,false);
insert into dangerous_site (`type`,`description`,manager,region) 
values ('Industriel',' charbonnage du Bois du Cazier',null,'Wallonie');
insert into danger(dangerous_site,disaster) values (8,11);
insert into impact_location (disaster, region) values (11,'Wallonie');
insert into `help` (disaster, hospital) values(11, 2);
insert into `help` (disaster, hospital) values(11, 1);

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Séisme de 1946 en Suisse','Tremblement de terre','Tremblement de terre dans la region de Wildhorn',str_to_date ('25-jan-1946','%e-%b-%Y'),null,6,6000,4,2,true);
insert into dangerous_site (`type`,`description`,manager,region) 
values ('Industriel',' Usine chimique de Wildhorn',null,'Zurich');
insert into dangerous_site (`type`,`description`,manager,region) 
values ('Industriel',' Usine de traitement de metaux lourds',null,'Espace Mittelland');
insert into danger(dangerous_site,disaster) values (9,12);
insert into danger(dangerous_site,disaster) values (10,12);
insert into impact_location (disaster, region) values (12,'Zurich');
insert into impact_location (disaster, region) values (12,'Espace Mittelland');
insert into `help` (disaster, hospital) values(12, 27);

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Tremblement de terre 2006 - FR/SW','Tremblement de terre','Catastrophe fictive sur la Suisse (sans la suisse orientale) et la France',str_to_date ('27-jan-2006','%e-%b-%Y'),null,null,6000,4,12,true);
insert into impact_location (disaster, region) values (13,'Zurich');
insert into impact_location (disaster, region) values (13,'Espace Mittelland');
insert into impact_location (disaster, region) values (13,'Haut de france');
insert into impact_location (disaster, region) values (13,'Bretagne');
insert into impact_location (disaster, region) values (13,'Ile de france');
insert into danger(dangerous_site,disaster) values (9,13);
insert into danger(dangerous_site,disaster) values (10,13);
insert into danger(dangerous_site,disaster) values(4,13);



insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('Ouragan 2008 - PL/BE','Ouragan','Catastrophe fictive sur la Silésie (Pologne) et la Belgique',str_to_date ('14-mar-2008','%e-%b-%Y'),null,null,7500,156,12,true);
insert into impact_location (disaster, region) values (14,'Flandre');
insert into impact_location (disaster, region) values (14,'Bruxelles');
insert into impact_location (disaster, region) values (14,'Wallonie');
insert into impact_location (disaster, region) values (14,'Silésie');
insert into danger(dangerous_site,disaster) values (2,14);
insert into danger(dangerous_site,disaster) values (5,14);
insert into danger(dangerous_site,disaster) values (6,14);
insert into danger(dangerous_site,disaster) values (7,14);
insert into danger(dangerous_site,disaster) values (8,14);


commit;