create database reservation;

use reservation;

create table user(
	id int not null auto_increment,
    first_name varchar(30),
    last_name varchar(30),
    email varchar(30),
    password varchar(30),
    primary key(id),
    unique key(email)
);

create table flight(
	id int not null auto_increment,
    flight_number varchar(30) not null,
    operating_airlines varchar(30) not null,
    departure_city varchar(30) not null,
    arrival_city varchar(30) not null,
    date_of_departure date not null,
    estimated_departure_time timestamp default current_timestamp,
    primary key(id)
);

create table passenger(
	id int not null auto_increment,
    first_name varchar(30),
    last_name varchar(30),
    middle_name varchar(30),
    email varchar(30),
    phone varchar(30),
    primary key(id)
);

create table reservation(
	id int not null auto_increment,
    checked_in tinyint(1),
    number_of_bags int,
    passenger_id int,
    flight_id int,
    created timestamp default current_timestamp,
    primary key(id),
    foreign key(passenger_id) references passenger(id) on delete cascade,
    foreign key(flight_id) references flight(id)
);

select * from user;
select * from flight;
select * from passenger;
select * from reservation;

delete from user;
delete from reservation;
delete from passenger;

SET SQL_SAFE_UPDATES = 0;

drop table user;
drop table flight;
drop table passenger;
drop table reservation;

drop database reservation;
