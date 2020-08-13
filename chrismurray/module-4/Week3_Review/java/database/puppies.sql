create table puppies (
	id serial PRIMARY KEY,
	name VARCHAR(50),
	weight INT,
	gender VARCHAR(50),
	paper_trained BOOLEAN
);
insert into puppies (id, name, weight, gender, paper_trained) values (1, 'Lady', 8, 'Female', true);
insert into puppies (id, name, weight, gender, paper_trained) values (2, 'Snoopy', 15, 'Male', true);
insert into puppies (id, name, weight, gender, paper_trained) values (3, 'Astro', 10, 'Male', false);
insert into puppies (id, name, weight, gender, paper_trained) values (4, 'Lassie', 9, 'Female', true);
insert into puppies (id, name, weight, gender, paper_trained) values (5, 'Clifford', 14, 'Male', false);
ALTER SEQUENCE puppies_id_seq RESTART WITH 6;
select * from puppies;