create table if not exists content(
	id int AUTO_INCREMENT,
	title varchar(255) NOT NULL,
	description text,
	status varchar(20) NOT NULL,
	content_type varchar(50) NOT NULL,
	date_created timestamp NOT NULL,
	date_updated timestamp,
	url varchar(255),
	primary key (id)
);