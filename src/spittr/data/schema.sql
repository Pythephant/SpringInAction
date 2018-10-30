use spittr;

create table Spitter (
	id bigint auto_increment primary key,
	username varchar(16) unique not null,
	password varchar(25) not null,
	firstname varchar(30),
	lastname varchar(30)
);

create table Spittle (
	id bigint auto_increment primary key,
	message varchar(255) not null,
	spitime datetime,
	latitude double,
	longitude double
);