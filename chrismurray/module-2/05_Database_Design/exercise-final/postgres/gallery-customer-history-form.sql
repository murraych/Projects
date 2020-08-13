CREATE TABLE customer
(
	custno serial,
	cust_name varchar(200),
	cust_street varchar(200),
	cust_city varchar(200),
	cust_prov varchar(200),
	cust_postalcode varchar(10),
	cust_phone char(11),

	CONSTRAINT pk_customer_custno PRIMARY KEY (custno)
);

CREATE TABLE customer_art
(
	custno int,
	art_code int,
	purchase_date timestamp,
	price money,

	CONSTRAINT pk_customer_art PRIMARY KEY (custno, art_code, purchase_date)
);

CREATE TABLE art
(
	art_code serial,
	art_title varchar(200),
	artist_id int,

	CONSTRAINT pk_art_art_code PRIMARY KEY (art_code)
);

CREATE TABLE artist
(
	artist_id serial,
	artist_firstname varchar(200),
	artist_lastname varchar(200),

	CONSTRAINT pk_artist_artist_id PRIMARY KEY (artist_id)
);

ALTER TABLE art ADD FOREIGN KEY (artist_id) REFERENCES artist(artist_id);
ALTER TABLE customer_art ADD FOREIGN KEY (custno) REFERENCES customer(custno);
ALTER TABLE customer_art ADD FOREIGN KEY (art_code) REFERENCES art(art_code);