-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on
-- Wikipedia.)

	INSERT INTO city(id, name, countrycode, district, population)
	VALUES (4080, 'Smallville', 'USA', 'Kansas', 45001);

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.

	-- ### POSTGRES ###
	INSERT INTO countrylanguage(countrycode, language, isofficial, percentage)
	VALUES ('USA', 'Kryptonese', false, 0.0001);

	-- ### SQL SERVER ###
	INSERT INTO countrylanguage(countrycode, language, isofficial, percentage)
	VALUES('USA', 'Kryptonese', 0, 0.0001);

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change
-- the appropriate record accordingly.

	UPDATE countrylanguage
	SET language = 'Krypto-babble'
	WHERE language = 'Kryptonese';

-- 4. Set the US captial to Smallville, Kansas in the country table.

	UPDATE country
	SET capital = 4080
	WHERE code = 'USA';

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

	DELETE FROM city
	WHERE id = 4080;

	-- This DELETE statement fails because the "capital" column of the country
	-- table is a foreign key constraint

-- 6. Return the US captial to Washington.

	UPDATE country
	SET capital = 3813
	WHERE code = 'USA';

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

	DELETE FROM city
	WHERE id = 4080;

	-- It works this time because there are no foreign key references to
	-- this row

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972
-- (exclusive).
-- (590 rows affected)

-- POSTGRESQL: 

	UPDATE countrylanguage
	SET isofficial = NOT isofficial
	WHERE countrycode IN
	(
		SELECT code
		FROM country
		WHERE indepyear BETWEEN 1801 AND 1971
	);
	
-- MSSQL: 

	UPDATE countrylanguage
	SET isofficial = ~isofficial
	WHERE countrycode IN
	(
		SELECT code
		FROM country
		WHERE indepyear BETWEEN 1801 AND 1971
	);
	
-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4068 rows affected)

	UPDATE city
	SET population = ceiling(population / 1000)
	WHERE population > 0;

-- 10. Assuming a country's surfacearea is expressed in square miles, convert it to
-- square meters for all countries where French is spoken by more than 20% of the
-- population.
-- (7 rows affected)

	UPDATE country
	SET surfacearea = surfacearea * 2589988.1
	WHERE code IN
	(
		SELECT countrycode
		FROM countrylanguage
		WHERE language = 'French' AND percentage >= 20
	);