create table disaster
    (   id                   int AUTO_INCREMENT,
        `name`               varchar(50)  CHARACTER SET utf8,
        `type`               varchar(25)  CHARACTER SET utf8 not null,
        `description`        varchar(400) CHARACTER SET utf8 not null,
        `date`               date not null,
        end_date             date,
        intensity            int,
        impacted_people      int not null check(impacted_people >= 0),
        direct_casualties    int not null check(direct_casualties >=0),
        indirect_casualties  int not null check(indirect_casualties >= 0),
        is_natural           bit not null,
        constraint disaster_id_pk primary key(id),
        constraint disaster_type_list check(`type` in('Ouragan','Tremblement de terre','Tsunami','Naufrage','Incendie','Nucléaire','Industriel','Humanitaire')),
        constraint disaster_intensity_limits check(intensity >= 0 and intensity <= 20),
        constraint disaster_name_uk unique(`name`)
    )   ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8;

create table region
    (   `name`               varchar(30) CHARACTER SET utf8,
        population           int not null check(population >= 0),
        is_warzone           bit not null,
        constraint region_name_pk primary key(`name`)
    )   ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8;
        
create table hospital
    (   id                  int AUTO_INCREMENT,
        `name`                varchar(50) CHARACTER SET utf8  not null,
        maximum_capacity    int not null check(maximum_capacity >= 0),
        address             varchar(80) CHARACTER SET utf8  not null,
        specialization      varchar(50) CHARACTER SET utf8,
        region              varchar(30) CHARACTER SET utf8 not null,
        constraint hospital_id_pk primary key(id),
		constraint hospital_region_fk foreign key(region) references region(`name`),
        constraint hospital_specialization_list check(specialization in ('Cardiologie','Urgences','Imagerie','Soins intensifs')),
        constraint hospital_name_uk unique(`name`)
    )   ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8;

create table dangerous_site
    (   id                  int AUTO_INCREMENT,
        `type`                varchar(25)  CHARACTER SET utf8 not null,
        `description`         varchar(200) CHARACTER SET utf8 not null,
        manager             varchar(60)  CHARACTER SET utf8,
        region              varchar(30)  CHARACTER SET utf8 not null,
        constraint dangerous_site_pk primary key(id),
        constraint dangerous_site_fk foreign key(region) references region(`name`),
        constraint dangerous_site_type_list check(`type` in('Nucléaire','Industriel','Naturel','Humanitaire'))
    )   ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8;
        --
        
create table country
    (   `name`                varchar(30) CHARACTER SET 'utf8' ,
        is_underdeveloped   bit not null,
        is_in_war           bit not null,
        constraint country_pk primary key(`name`)
    )   ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8;
    
create table impact_location
    (   disaster            int,
        region              varchar(30) CHARACTER SET utf8 ,
        constraint impact_location_pk primary key(disaster, region),
        constraint impact_location_fk_disaster foreign key(disaster) references disaster(id),
        constraint impact_location_fk_region foreign key(region) references region(`name`)
    )   ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8;
    
create table `help`
    (   disaster            int,
        hospital            int,
        constraint help_pk primary key (disaster,hospital),
        constraint help_fk_disaster foreign key(disaster) references disaster(id),
        constraint help_fk_hospital foreign key(hospital) references hospital(id)
    )   engine = INNODB 
        DEFAULT CHARACTER SET = utf8;

create table danger
    (   dangerous_site      int,
        disaster            int,
        constraint danger_pk primary key (dangerous_site, disaster),
        constraint danger_fk_dangerous_site foreign key(dangerous_site) references dangerous_site(id),
        constraint danger_fk_disaster foreign key(disaster) references disaster(id)
    )   ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8;
        
create table location
    (   region              varchar(30) CHARACTER SET utf8,
        country             varchar(30) CHARACTER SET utf8,
        constraint location_pk primary key (region, country),
        constraint location_fk_region foreign key(region) references region(name),
        constraint location_fk_country foreign key(country) references country(name)
    )   ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8;

