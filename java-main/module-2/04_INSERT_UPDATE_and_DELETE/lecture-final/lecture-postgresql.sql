-- INSERT

-- 1. Add Klingon as a spoken language in the USA

SELECT * FROM country WHERE name LIKE '%ingd%';

SELECT * FROM countrylanguage WHERE countrycode IN ('USA', 'GBR');

INSERT INTO countrylanguage (language, countrycode, isofficial, percentage) VALUES ('Klingon', 'USA', FALSE, .02);

-- 2. Add Klingon as a spoken language in Great Britain

INSERT INTO countrylanguage (language, countrycode, isofficial, percentage) VALUES ('Klingon', 'GBR', FALSE, .02);


-- UPDATE

-- 1. Update the capital of the USA to Houston

SELECT ID FROM city WHERE LOWER(name) = 'houston';

SELECT * FROM city WHERE LOWER(name) LIKE '%wash%';

SELECT * FROM country WHERE code = 'USA';

UPDATE country
SET capital = (SELECT ID FROM city WHERE LOWER(name) = 'houston')
WHERE code = 'USA';

-- 2. Update the capital of the USA to Washington DC and the head of state

UPDATE country
SET capital = (SELECT ID FROM city WHERE name = 'Washington')
WHERE code = 'USA';


-- DELETE

-- 1. Delete English as a spoken language in the USA

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

DELETE FROM countrylanguage
WHERE countrycode = 'USA' and language = 'English';

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

-- 2. Delete all occurrences of the Klingon language 

SELECT * FROM countrylanguage WHERE language = 'Klingon';

DELETE FROM countrylanguage WHERE language = 'Klingon';


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.

INSERT INTO countrylanguage (language) VALUES ('Elvish');

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?

SELECT * FROM country WHERE code = 'ZZZ';



-- 3. Try deleting the country USA. What happens?

DELETE FROM country WHERE code = 'USA';


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA

SELECT * FROM countrylanguage;

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('USA', 'English', TRUE, .2);

-- 2. Try again. What happens?

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('USA', 'English', TRUE, .2);

-- 3. Let's relocate the USA to the continent - 'Outer Space'

SELECT * FROM country;

UPDATE country SET continent = 'Outer Space' WHERE code = 'USA';


-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

BEGIN TRANSACTION;

SELECT COUNT(*) FROM countrylanguage;

DELETE FROM countrylanguage;

SELECT COUNT(*) FROM countrylanguage;

ROLLBACK;

--COMMIT;

SELECT COUNT(*) FROM countrylanguage;


-- 2. Try updating all of the cities to be in the USA and roll it back

-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.