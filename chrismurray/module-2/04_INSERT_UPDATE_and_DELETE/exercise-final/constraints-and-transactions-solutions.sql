-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

	INSERT INTO actor(first_name, last_name)
	VALUES ('HAMPTON', 'AVENUE');
	INSERT INTO actor(first_name, last_name)
	VALUES ('LISA', 'BYWAY');

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.

	INSERT INTO film (title, description, release_year, language_id, length)
	VALUES ('EUCLIDEAN PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, (SELECT language_id FROM language WHERE name='English'), 198);

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

	INSERT INTO film_actor(actor_id, film_id)
	VALUES ((SELECT actor_id FROM actor WHERE first_name='HAMPTON' AND last_name='AVENUE'), (SELECT film_id FROM film WHERE title='EUCLIDEAN PI'));
	INSERT INTO film_actor(actor_id, film_id)
	VALUES ((SELECT actor_id FROM actor WHERE first_name='LISA' AND last_name='BYWAY'), (SELECT film_id FROM film WHERE title='EUCLIDEAN PI'));

-- 4. Add Mathmagical to the category table.

	INSERT INTO category(name)
	VALUES ('Mathmagical');

-- 5. Assign the Mathmagical category to the following films, "EUCLIDEAN PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

	INSERT INTO film_category(film_id, category_id)
	VALUES ((SELECT film_id FROM film WHERE title='EUCLIDEAN PI'), (SELECT category_id FROM category WHERE name='Mathmagical'));
	INSERT INTO film_category(film_id, category_id)
	VALUES ((SELECT film_id FROM film WHERE title='EGG IGBY'), (SELECT category_id FROM category WHERE name='Mathmagical'));
	INSERT INTO film_category(film_id, category_id)
	VALUES ((SELECT film_id FROM film WHERE title='KARATE MOON'), (SELECT category_id FROM category WHERE name='Mathmagical'));
	INSERT INTO film_category(film_id, category_id)
	VALUES ((SELECT film_id FROM film WHERE title='RANDOM GO'), (SELECT category_id FROM category WHERE name='Mathmagical'));
	INSERT INTO film_category(film_id, category_id)
	VALUES ((SELECT film_id FROM film WHERE title='YOUNG LANGUAGE'), (SELECT category_id FROM category WHERE name='Mathmagical'));

	-- Alternative

	UPDATE film_category SET category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical')
	WHERE film_id IN (SELECT film_id FROM film WHERE title IN ('Euclidean PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE'))

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

	UPDATE film
	SET rating = 'G'
	WHERE film_id IN
	(
		SELECT film_id
		FROM film_category
		WHERE category_id = (SELECT category_id FROM category WHERE name='Mathmagical')
	);

-- 7. Add a copy of "Euclidean PI" to all the stores.

	INSERT INTO inventory(film_id, store_id) SELECT (SELECT film_id FROM film WHERE title='EUCLIDEAN PI'), store_id FROM store;

	-- The solution relies on the fact you can INSERT INTO with a SELECT FROM

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)

	DELETE FROM film
	WHERE title='EUCLIDEAN PI';

	-- This DELETE statement fails because the "film_id" column of the film_actor
	-- table is a foreign key constraint

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)

	DELETE FROM category
	WHERE category_id = (SELECT category_id FROM category WHERE name='Mathmagical');

	-- This DELETE statement fails because the "category_id" column of the film_category
	-- table is a foreign key constraint

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)

	DELETE FROM film_category
	WHERE category_id = (SELECT category_id FROM category WHERE name='Mathmagical');

	-- THis DELETE statement succeeded since there were no comflicting constraints.
	-- All 5 rows added earlier were deleted.

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)

	DELETE FROM category
	WHERE category_id = (SELECT category_id FROM category WHERE name='Mathmagical');

	-- This DELETE succeeded since the category_id column constraint on file_category
	-- had been removed.

	DELETE FROM film
	WHERE title='EUCLIDEAN PI';

	-- This DELETE statement failed once again because the "film_id" column of
	-- the film_actor table is a foreign key constraint.

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.

	-- The film_actor table has a foreign key constraint on film_id which may
	-- prevent the film from being removed.
	-- The film_category table has a foreign key constraint on film_id which may
	-- prevent the film from being removed.
	-- The inventory table has a similar constraint on film_id, and may keep the
	-- film fron being deleted.
	-- So, "Euclidean PI" cannot be deleted from the film table until all
	-- references to its film_id are gone from from both the film_actor and
	-- inventory tables.
	--
	-- Run the following SQL to resolve the constraints and delete "Euclidean PI".

	DELETE FROM film_actor
	WHERE film_actor.film_id = (SELECT film_id FROM film WHERE title='EUCLIDEAN PI');

	DELETE FROM film_category
	WHERE film_category.film_id = (SELECT film_id FROM film WHERE title='EUCLIDEAN PI');

	DELETE FROM inventory
	WHERE inventory.film_id = (SELECT film_id FROM film WHERE title='EUCLIDEAN PI');

	DELETE FROM film
	WHERE film.title = 'EUCLIDEAN PI';
