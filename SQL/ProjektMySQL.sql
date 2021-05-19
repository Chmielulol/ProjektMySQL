create schema poczta;

use poczta;


create table address(
id int not null auto_increment,
street varchar(50) not null,
city varchar(50) not null,
postal_code varchar(50) not null,
country varchar(50) not null,
primary key (id));


create table central (
id int not null auto_increment,
`name` varchar(50) not null,
address_id int default null,
primary key(id),
foreign key (address_id) references address(id));


create table zones (
postal_code varchar(50) not null,
central_id int not null,
primary key(postal_code),
foreign key (central_id) references central(id));

create table `users` (
id int not null auto_increment,
username varchar(50) not null,
`password` varchar(50) not null,
`active` boolean default true,
address_id int default null,
central_id int default null,
primary key (id),
unique key (username),
foreign key (address_id) references address(id),
foreign key (central_id) references central(id));

create table authorities (
user_id int not null,
authority varchar(50) not null,
Foreign key (user_id) references users(id));


create table package (
id int not null auto_increment,
sender_id int not null,
receiver_id int not null,
`status` varchar(50) default null,
primary key (id),
foreign key (sender_id) references users(id),
foreign key (receiver_id) references users(id));

create table personal_data (
id int not null auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
phone int default null,
email varchar(50) default null,
user_id int default null,
primary key(id),
foreign key (user_id) references users(id));
