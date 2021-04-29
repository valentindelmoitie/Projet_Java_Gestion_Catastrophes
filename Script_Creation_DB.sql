create table disaster
    (   id                   int check(id > 0),
        name                 varchar(50),
        type                 varchar(25) not null constraint disaster_type_list check(type in('Hurricane','Earthquake','Tsunami','Fire')),
        description          varchar(400) not null,
        date                 date not null,
        end_date             date,
        intensity            int constraint disaster_intensity_limits check(intensity > 0 and intensity <= 20),
        impacted_people      int not null check(impacted_people >= 0),
        direct_casualties    int not null check(direct_casualties >=0),
        indirect_casualties  int not null check(indirect_casualties >= 0),
        is_natural           bit not null,
        constraint disaster_id_pk primary key(id)
    ) engine = INNODB;

create table region
    (   name                 varchar(30),
        population           int not null check(population >= 0),
        is_warzone           bit not null,
        constraint region_name_pk primary key(name)
    ) engine = INNODB;

create table hospital
    (   id                  int check(id > 0),
        name                varchar(50) not null,
        maximum_capacity    int not null check(maximum_capacity >= 0),
        address             varchar(80) not null,
        specialization      varchar(50) constraint hospital_specialization_list check(specialization in ('Cardiologie','Urgences','Imagerie','Soins intensifs')),
        region              varchar(30),
        constraint hospital_id_pk primary key(id),
		constraint hospital_region_fk foreign key(region) references region(name)
    ) engine = INNODB;

create table dangerous_site
    (   id                  int check(id > 0),
        type                varchar(25) not null constraint dangerous_site_type_list check(type in('Nucleaire','Industriel','Naturel')),
        description         varchar(200) not null,
        manager             varchar(60),
        region              varchar(30),
        constraint dangerous_site_pk primary key(id),
        constraint dangerous_site_fk foreign key(region) references region(name)
    ) engine = INNODB;
    
create table country
    (   name                varchar(30),
        is_underdeveloped   bit not null,
        is_in_war           bit not null,
        constraint country_pk primary key(name)
    ) engine = INNODB;
    
create table impact_location
    (   disaster            int,
        region              varchar(30),
        constraint impact_location_pk primary key(disaster, region),
        constraint impact_location_fk_disaster foreign key(disaster) references disaster(id),
        constraint impact_location_fk_region foreign key(region) references region(name)
    ) engine = INNODB;
    
create table help
    (   disaster            int,
        hospital            int,
        constraint help_pk primary key (disaster,hospital),
        constraint help_fk_disaster foreign key(disaster) references disaster(id),
        constraint help_fk_hospital foreign key(hospital) references hospital(id)
    ) engine = INNODB;

create table danger
    (   disaster            int,
        region              varchar(30),
        constraint danger_pk primary key (disaster, region),
        constraint danger_fk_disaster foreign key(disaster) references disaster(id),
        constraint danger_fk_region foreign key(region) references region(name)
    ) engine = INNODB;
    

create table location
    (   region              varchar(30),
        country             varchar(30),
        constraint location_pk primary key (region, country),
        constraint location_fk_region foreign key(region) references region(name),
        constraint location_fk_country foreign key(country) references country(name)
    )engine = INNODB;



insert into country values('Belgique',false, false);
insert into country values('France',false, false);
insert into country values('Ukraine',false, true);
insert into country values('Burundi'true, false);


insert into region values('Wallonie',3600000, false);
insert into region values('Flandre',6500000, false);
insert into region values('Bruxelles',174000, false);

insert into region values('Haut de france',6000000, false);
insert into region values('Ile de france',12200000, false);
insert into region values('Bretagne',3200000, false);

insert into region values('Kiev',1700000, false);
insert into region values('Louhansk',2200000, true);
insert into region values('Donetsk',4400000, true);

insert into region values('Bururi',440000, false);
insert into region values('Karuzi',600000, false);
insert into region values('Rutana',450000, false);


insert into location values('Wallonia','Belgique');
insert into location values('Flandre','Belgique');
insert into location values('Bruxelles','Belgique');

insert into location values('Haut de france','France');
insert into location values('Ile de france','France');
insert into location values('Bretagne','France');

insert into location values('Kiev','Ukraine');
insert into location values('Louhansk','Ukraine');
insert into location values('Donetsk','Ukraine');

insert into location values('Bururi','Burundi');
insert into location values('Karuzi','Burundi');
insert into location values('Rutana','Burundi');


insert into hospital values(1,'GHDC',720,'Rue Marguerite Depasse 6, 6060 Charleroi',null,'Wallonie');
insert into hospital values(2,'CHU UCL Namur',400,'Place Louise Godin 15, 5000 Namur','Cardiologie','Wallonie');
insert into hospital values(3,'CHU Brugmann',620,'Rue Bruyn 1, 1120 Bruxelles',null,'Bruxelles');
insert into hospital values(4,'AZ Groeninge',835,'President Kennedylaan 4, 8500 Kortrijk','Soins intensifs','Flandre');

insert into hospital values(5,'CLINEA',515,'1 Rue du Fort, 59720 Louvroil, France','Imagerie','Haut de france');
insert into hospital values(6,'Centre Hospitalier Avesnes',315,'46 Route Haut Lieu, 59440 Avesnes-sur-Helpe, France',null,'Haut de france');
insert into hospital values(7,'Hopital Albert Chenevier',715,'40 Rue de Mesly, 94000 Creteil, France',null,'Ile de france');
insert into hospital values(8,'Centre Hospitalier de Saint-Denis',965,'2 Rue du Dr Delafontaine, 93200 Saint-Denis, France','Soins intensifs','Ile de france');
insert into hospital values(9,'Hopital du Scorff',365,'5 Avenue Choiseul, 56322 Lorient, France',null,'Bretagne');

insert into hospital values(10,'American Medical Centers Kiev',1215,'Berdychivska street 1 , Kiev 04116 , Ukraine',null,'Kiev');
insert into hospital values(11,'Children Hospital',115,'Radianska St, 68, Luhansk, Luhansk Oblast, Ukraine, 91000',null,'Louhansk');
insert into hospital values(12,'Dorozhnya Klinichna Likarnya Na St. Donetsk',315,'Universytetska St, 60, Donetsk, Donetsk Oblast, Ukraine, 83000','Cardiologie','Donetsk');
insert into hospital values(13,'Donets?ke Klinichne',75,'Illicha Ave, 14, Donetsk, Donetska oblast, Ukraine, 83000',null,'Donetsk');

insert into hospital values(1,'BUMEREC',720,'Avenue du Cercle-Nautique, Bujumbura, Burundi',null,'Bururi');
insert into hospital values(1,'Kira Hospital',470,'Ave Nzero, Bujumbura, Burundi',null,'Rutana');
insert into hospital values(1,'Hopital de Bubanza',150,'RN9, Bubanza, Burundi','Soins intensifs','Rutana');

-- REGION COUNTRY HOSPITAL LOCATIONDEJA REMPLIE

