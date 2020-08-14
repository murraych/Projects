select * from breweries


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


select * from reviews

UPDATE reviews SET target_id = 5 WHERE id = 4

SELECT * FROM reviews WHERE brewery_id = ?
