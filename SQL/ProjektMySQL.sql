drop schema poczta;
create schema poczta;

use poczta;

create table address(
id int not null auto_increment,
street varchar(50) not null,
city varchar(50) not null,
postal_code varchar(50) not null,
country varchar(50) not null,
primary key (id)) engine = InnoDB;

insert into address (street, city, postal_code, country)
values 
	('Garbarska 12', 'Kraków', '31-131', 'Polska'),
    ('Mozowiecka 3', 'Warszawa', '31-131', 'Polska'),
    ('Jana Pawła 31', 'Wadowice', '31-131', 'Polska'),
    ('Mydlarska 2', 'Chmielów', '31-131', 'Polska'),
    ('Kapitańska 25', 'Piątek', '31-131', 'Polska')
;

create table central (
id int not null auto_increment,
`name` varchar(50) not null,
address_id int default null,
primary key(id),
foreign key (address_id) references address(id)) engine = InnoDB;

insert into central (name)
values 
	('Urzad pocztowy Kraków'),
    ('Urzad pocztowy Warszawa'),
    ('Urzad pocztowy Gdańska'),
    ('Lokalny urzad pocztowy Wilno')
;

create table zones (
postal_code varchar(50) not null,
central_id int not null,
primary key(postal_code),
foreign key (central_id) references central(id)) engine = InnoDB;

create view GetAllPostalCodes
as
select postal_code from address
union 
select postal_code from zones
order by postal_code;

create table `users` (
id int not null auto_increment,
username varchar(50) not null,
`password` varchar(50) not null,
`active` boolean default true,
address_id int default null,
central_id int default null,
primary key (id),
foreign key (address_id) references address(id),
foreign key (central_id) references central(id)) engine = InnoDB;

DELIMITER //
create procedure RemoveAllInactiveUsers()
begin
	delete from users where active = false;
end //
DELIMITER ;

insert into users (username, password)
values 
	('Aleczek', 'alekjestfajny123'),
    ('Kubek', 'janpawel2137'),
    ('UltraKoks', 'BasiaKC'),
    ('tomekPL', 'tomekPL'),
    ('DarkTibik', '72_na2js!@0x')
;

create table authorities (
id int not null auto_increment,
user_id int not null,
authority varchar(50) not null,
Primary key (id),
Foreign key (user_id) references users(id)) engine = InnoDB;

create table package (
id int not null auto_increment,
sender_id int not null,
receiver_id int not null,
`status` varchar(50) default null,
primary key (id),
foreign key (sender_id) references users(id),
foreign key (receiver_id) references users(id)) engine = InnoDB;

DELIMITER //
create procedure ChangePackageStatus(in newStatus varchar(50))
begin
	update package
    set status = newStatus;
end //
DELIMITER ;

create table personal_data (
id int not null auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
phone int default null,
email varchar(50) default null,
user_id int default null,
primary key(id),
foreign key (user_id) references users(id)) engine = InnoDB;

create view GetUsersInfo
as 
select username, first_name, last_name, phone, email from personal_data
join users on personal_data.user_id = users.id
order by first_name, last_name;

DELIMITER //
create trigger RemovePersonalDataAfterUserRemove after delete on users 
for each row
begin 
	delete from personal_data where users.id = personal_data.user_id;
end //
DELIMITER ;
