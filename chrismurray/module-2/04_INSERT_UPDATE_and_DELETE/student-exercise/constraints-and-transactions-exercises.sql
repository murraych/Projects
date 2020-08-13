-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.


INSERT INTO actor (first_name, last_name) VALUES ('Hampton', 'Avenue'), ('Lisa', 'Byway');


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.




INSERT INTO film (title, description, release_year, language_id, length) VALUES ('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, (SELECT language_id FROM language WHERE name = 'English'), 198);




-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.



INSERT INTO film_actor (actor_id, film_id) 
VALUES ((SELECT actor_id FROM actor WHERE first_name = 'Hampton' AND last_name = 'Avenue'), (SELECT film_id FROM film WHERE title = 'Euclidean PI')), 
((SELECT actor_id FROM actor WHERE first_name = 'Lisa' AND last_name = 'Byway'), (SELECT film_id FROM film WHERE title = 'Euclidean PI'));


-- 4. Add Mathmagical to the category table.

INSERT INTO category (name)
VALUES ('Mathmagical');



-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

SELECT * FROM film WHERE title = 'Euclidean PI';
SELECT * FROM film_category WHERE film_id = 1002;
SELECT * FROM film WHERE film_id = 1002;



INSERT INTO film_category (film_id, category_id)
VALUES ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT category_id FROM category WHERE name = 'Mathmagical'));

UPDATE film_category
SET category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical')
WHERE film_id IN (SELECT film_id from film WHERE title IN('EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE')); 



-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)



UPDATE film SET rating = 'G' WHERE film_id IN

(SELECT film.film_id FROM category
        INNER JOIN film_category
                ON category.category_id = film_category.category_id
        INNER JOIN film
                ON film_category.film_id = film.film_id
WHERE category.name = 'Mathmagical');

SELECT rating, title FROM film WHERE film_id IN (SELECT film.film_id FROM category
        INNER JOIN film_category
                ON category.category_id = film_category.category_id
        INNER JOIN film
                ON film_category.film_id = film.film_id
WHERE category.name = 'Mathmagical');



-- 7. Add a copy of "Euclidean PI" to all the stores.

INSERT INTO inventory (store_id, film_id)
SELECT
        store_id,
        (SELECT film_id FROM film WHERE title = 'Euclidean PI')
FROM 
        store;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- cant be completed because it violates a key constraint

BEGIN TRANSACTION;

DELETE FROM film
WHERE film_id = 1002;


ROLLBACK;
COMMIT TRANSACTION;



-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- No, violates foreign key constraint

BEGIN TRANSACTION;

DELETE FROM category
WHERE category_id = 17;

ROLLBACK;
COMMIT TRANSACTION;

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- Yes, because category is not needed for a film


BEGIN TRANSACTION;

DELETE FROM film_category
WHERE category_id = 17;

ROLLBACK;
COMMIT TRANSACTION;

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- 


BEGIN TRANSACTION;
DELETE FROM category
WHERE name = 'Mathmagical'

DELETE FROM film
WHERE film_id = 1002;


ROLLBACK;
COMMIT TRANSACTION;

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
