-- SELECT ... FROM
-- Selecting the names for all countries
SELECT name From country;

-- Selecting the name and population of all countries
SELECT name, population FROM country;

-- Selecting all columns from the city table
SELECT * from city;

-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio
SELECT * FROM city WHERE district = 'Ohio';


-- Selecting countries that gained independence in the year 1776


-- Selecting countries not in Asia
SELECT * FROM country WHERE continent NOT LIKE 'Asia%';

-- Selecting countries that do not have an independence year

SELECT * FROM country WHERE indepyear IS NULL;

-- Selecting countries that do have an independence year
SELECT * FROM country WHERE indepyear IS NOT NULL;

-- Selecting countries that have a population greater than 5 million



-- SELECT ... FROM ... WHERE ... AND/OR

SELECT name, continent, indepyear FROM country WHERE indepyear BETWEEN 1902 AND 1906 OR continent = 'Oceania';

-- Selecting cities in Ohio and Population greater than 400,000



-- Selecting country names on the continent North America or South America




-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword



