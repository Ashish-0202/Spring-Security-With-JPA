CREATE database if not exists SpringSecurity_demo;

use springsecurity_demo;

CREATE TABLE IF NOT EXISTS users(
user_id int NOT NULL primary key auto_increment,
username varchar(20) not null,
password varchar(20) not null,
enabled boolean
);

DROP Table authorities;

insert into users values (1,'Ashish','{noop}Ashu@2002',1);

CREATE TABLE if not exists authorities (
auth_id int not null primary key auto_increment ,
authority varchar(25),
user_id int not null,
foreign key(user_id) references users(user_id)
);

insert into authorities values (1,'ROLE_ADMIN',1),(2,'ROLE_USER',1);