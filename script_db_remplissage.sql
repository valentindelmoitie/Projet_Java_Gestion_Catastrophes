insert into country (`name`,is_underdeveloped,is_in_war) values('Belgique',false, false);
insert into country (`name`,is_underdeveloped,is_in_war) values('France',false, false);
insert into country (`name`,is_underdeveloped,is_in_war) values('Ukraine',false, true);
insert into country (`name`,is_underdeveloped,is_in_war) values('Burundi',true, false);

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
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Donets?ke Klinichne',75,'Illicha Ave, 14, Donetsk, Donetska oblast, Ukraine, 83000',null,'Donetsk');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('BUMEREC',720,'Avenue du Cercle-Nautique, Bujumbura, Burundi',null,'Bururi');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Kira Hospital',470,'Ave Nzero, Bujumbura, Burundi',null,'Rutana');
insert into hospital (`name`, maximum_capacity,address,specialization, region) values('Hopital de Bubanza',150,'RN9, Bubanza, Burundi','Soins intensifs','Rutana');

insert into disaster (`name`,`type`,`description`,`date`,end_date,intensity,impacted_people,direct_casualties,indirect_casualties,is_natural)
values('catastrophe nucléaire de Tchernobyl','Nucléaire','Accident nucléaire majeur', str_to_date ('26-apr-1986','%e-%b-%Y'),null,14,200000,50,4000,false);
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



