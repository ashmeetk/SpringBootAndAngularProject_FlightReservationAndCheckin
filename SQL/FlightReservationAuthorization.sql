use reservation;

create table role(
id int not null auto_increment,
name varchar(30),
primary key(id)
);

create table user_role(
user_id int,
role_id int,
foreign key (user_id) references user(id),
foreign key (role_id) references role(id)
);

insert into role values (1, "ADMIN");
insert into role values (2, "CUSTOMER");

select * from role;
select * from user_role;

drop table role;
drop table user_role;


