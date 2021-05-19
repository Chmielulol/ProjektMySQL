drop schema if exists poczta_krakowsko_slaska;
create schema poczta_krakowsko_slaska;
use poczta_krakowsko_slaska;

create table address(
id int not null auto_increment,
street text default null,
city text default null,
postal_code text default null,
country text default null,
Primary key(id)
);


create table central(
id int not null auto_increment,
address_id int default null,
Primary key(id),
Foreign key (address_id) references address(id));

create table zone (
id int not null,
central_id int default null,
Primary key (id),
foreign key (central_id) references central(id));

create table courier (
id int not null auto_increment,
first_name varchar(45) default null,
last_name varchar(45) default null,
central_id int not null,
Primary key (id),
foreign key (central_id) references central(id));

create table collection_point (
id int not null auto_increment,
`owner` text default null,
address_id int default null,
zone_id int default null,
Primary key (id),
Foreign key (zone_id) references zone(id));

create table `client`(
id int not null auto_increment,
first_name varchar(45) default null,
last_name varchar(45) default null,
address_id int default null,
zone_id int default null,
Primary key(id),
Foreign key (zone_id) references zone(id),
Foreign key (address_id) references address(id));

create table package (
id int not null auto_increment,
sender_id int default null,
receiver_id int default null,
courier_id int default null,
`status` text default null, 
Primary key (id),
foreign key (sender_id) references `client`(id),
foreign key (receiver_id) references `client`(id),
foreign key (courier_id) references courier(id));
