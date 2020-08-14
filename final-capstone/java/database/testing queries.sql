INSERT INTO beers(brewery_id, name, description, image, abv, gluten_free)
VALUES(1, 'my beer', 'very nice and heavy', 'img', 1.2, true);


INSERT INTO beer_type(id, name) VALUES(1, 'cider');
INSERT INTO beer_type(id, name) VALUES(2, 'Ale');

select * from breweries;

UPDATE breweries SET name=?, address1=?, city=?, zip_code=?, state=?, country=?, longitude=?, latitude=?, phone=?, website=?, history=?, image=?, active=? WHERE id=?

SELECT * FROM breweries ORDER BY name;

SELECT * FROM beers JOIN breweries ON beers.brewery_id = breweries.id WHERE brewery_id = ?;


INSERT INTO review_type(name) VALUES ('beer review');
INSERT INTO review_type(name) VALUES ('brewery review');




INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) VALUES (1, 1, 1, 'Christmas magic in a a bottle',
'This is one of my all time favorite beers, it keeps me warm and happy all winter long with its perfect combination of spices and Christmas magic', 5);
INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) VALUES(1, 1, 3,'Greatest Beer Ever', 'This is the best Xmas beer in the world!', 5);

INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) VALUES (2, 2, 3,'Feels like home', 'The atmosphere is great, and staff is super nice!', 5);
INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) VALUES (2, 2, 4,'Horrible!', 'The store is nasty, and staff is very rude, would not recomment!', 1);


UPDATE reviews SET review_type=?, target_id=?, user_id=?, review_title=?, review_body=?, review_caps=? WHERE id=?

UPDATE reviews SET target_id = 5 WHERE id = 4

SELECT * FROM reviews WHERE brewery_id = ?
DELETE FROM reviews WHERE target_id = 1;





INSERT INTO beers(brewery_id, name, description, image, abv, beer_type, gluten_free) VALUES (?,?,?,?,?,(SELECT beer_type.id FROM beer_type WHERE name = ?),?);

select * from beers
select * from beer_type ORDER BY id desc;

select * from reviews



delete from beer where name = 'newbeer'







