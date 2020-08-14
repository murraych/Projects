/*(name, address1, address2,city,state, zipcode,country,longitude,latitude,phone,website,history,image,food_id,active)*/
/*INSERT INTO breweries(name, address1,city,state, zip_code,country,phone,website,history)
        VALUES ('(512) Brewing Company','407 Radam,F200','Austin','TX','78745','USA','512-707-2337','http://512brewing.com/','(512) Brewing Company is a microbrewery located in the heart of Austin that brews for the community using as many local, domestic and organic ingredients as possible.');
INSERT INTO breweries(name, address1,city,state, zip_code,country,phone,website,history)
        VALUES('21st Amendment Brewery Cafe','563 Second Street','San Francisco','CA','94107','USA','1-415-369-0900', 'http://www.21st-amendment.com/', 'The 21st Amendment Brewery offers a variety of award winning house made brews and American grilled cuisine in a comfortable loft like setting. Join us before and after Giants baseball games in our outdoor beer garden.');
INSERT INTO breweries(name,city,state, zip_code,country,longitude,latitude,phone,website)
        VALUES('Siluria Brewing Company','Alabaster','AL','35007-8501','USA','-86.8163773','33.2442813','205-482-7661', 'http://www.siluriabrewing.com');
INSERT INTO breweries(name,address1,city,state, zip_code,country,longitude,latitude,phone,website)
        VALUES('Cheaha Brewing Co','1208 Walnut Ave','Anniston','AL','36201-4526','USA','-85.8337740514949','33.6601671','256-770-7300','http://www.cheahabrewingcompany.com');
INSERT INTO breweries(name,address1,city,state, zip_code,country,longitude,latitude,phone,website)
        VALUES('Avondale Brewing Co','201 41st St S','Birmingham','AL','35222-1932','USA','-86.774322','33.524521','205-777-5456','http://www.avondalebrewing.com');
--
INSERT INTO breweries(name,address1,city,state, zip_code,country,longitude,latitude,website,phone)
        VALUES('Colorado Farm Brewery','2070 County Road 12 S','Alamosa','CO','81101-9116','USA', '-105.985591761422','37.4002604814483','http://www.cofarmbeer.com','719-580-0051');
INSERT INTO breweries(name,address1,city,state, zip_code,website,phone,country,longitude,latitude)
        VALUES('San Luis Valley Brewing Co','631 Main St','Alamosa','CO','81101-2557','http://www.slvbrewco.com','719-587-2337','USA','-105.8742898','37.4681813');
INSERT INTO breweries(name,address1,city,state, zip_code,website,phone,country,longitude,latitude)
        VALUES('Square Peg Brewerks','625 Main St',
        'Alamosa','CO','81101-2557','http://www.squarepegbrewerks.com',
        '719-580-7472','USA','-105.8742898','37.4681813');
*/

insert into beer_type(name) values('India Pale Ale');       
        
        --10 barrels brewery and beers
INSERT INTO breweries(name,address1,city,state, zip_code,country,longitude,latitude,website,phone)
        VALUES('10 Barrel Brewing Company','2620 Walnut St','Denver','CO','80205','USA', '-104.985523','39.759762','http://www.10barrel.com','720-573-8992');
        
INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) VALUES (20, 'Apocalypse IPA', 'Apocalypse uses a combination of whole leaf and pellet hops that vreate a full well developed hop flavor.', '
https://10barrel.com/wp-content/uploads/2018/07/Apocalypse-IPA-12oz-Can-2.png', 6.8, 144)  
INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) VALUES (20, 'Joe Ipa', 'Joe Ipa has a bright citrusy flavor and an intense hop aroma', 
'https://10barrel.com/wp-content/uploads/2015/09/Joe-IPA-12oz-Can-2.png', 6.9, 144)  
UPDATE beers SET gluten_free = false WHERE brewery_id = 20;

        --Dos Luces
INSERT INTO breweries(name,address1,city,state, zip_code,country,longitude,latitude,website,phone)
        VALUES('Dos Luces Brewery','1236 South Broadway','Denver','CO','80210','USA', '-104.987215','39.694260','https://dosluces.com/','720-379-7763');
        
INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) 
        VALUES (22, 'Metztli-Pulque', 'Nicknamed �Meztli� for the Aztec god of the moon, our Pulque just might lead to some lunacy if you�re not careful.  
        With bold sweet and sour flavors, as well as higher alcohol.', 
        'https://dosluces.com/wp-content/uploads/2018/07/IMG_3599.jpg', 7, 131);
INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) 
        VALUES (22, 'Inti � Chicha', 'An Incan staple still enjoyed throughout the Andes, Chicha is a beer brewed from corn.  
        Dos Luces brews with malted blue corn, and we mix with whole kernels of Peruvian purple corn to give our Chicha its distinctive color and flavor.', 
        'https://www.porchdrinking.com/wp-content/uploads/2018/11/dos-luces-chicha.jpg', 5, 131);
        
--Great Divide
INSERT INTO breweries(name,address1,city,state, zip_code,country,longitude,latitude,website,phone)
        VALUES('Great Divide Brewing Co','2201 Arapahoe St','Denver','CO','80205','USA', '-105.058182','40.228322','https://greatdivide.com','303-296-9460');  

INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) VALUES (23, 'Mango + Ginger Whitewater Craft Hard Seltzer ', 
'Mango + Ginger WHITEWATER Craft Hard Seltzer is our refreshing and lively take on a craft spiked seltzer. Brewed with all-natural ingredients, 
gluten-free with low carbs and zero sugar, WHITEWATER showcases real yet subtle fruit flavor', 'https://greatdivide.com/wp-content/uploads/2020/02/WhiteWater-Mango-Ginger-can-No-background-1.png', 5.0, 131);  
INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) VALUES (23, 'Ruby Red Grapefruit Whitewater Craft Hard Seltzer ', 
'Ruby Red Grapefruit WHITEWATER Craft Hard Seltzer is our refreshing and lively take on a craft spiked seltzer. 
Brewed with all-natural ingredients, gluten-free with low carbs and zero sugar, WHITEWATER showcases real yet subtle fruit flavor.', 
'https://greatdivide.com/wp-content/uploads/2020/02/WhiteWater-Rubyred-Grapefruit-can-No-background.png', 5.0, 131)  

        
        --a brewery Review(2)
/*INSERT INTO reviews(review_type, target_id, user_id, review_title, review_body, review_caps)
        VALUES(2, 23, 1, 'WOW!', 'Joe and Adam are great! Super chill but also enforcing mask and distancing mandates in a friendly way. 
        The beer is great too - especially the hefeweizen and the goose! Highly recommended during these pandemic times and in general!', 5); */
INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) 
        VALUES (2, 2, 3,'Feels like home', 'The atmosphere is great, and staff is super nice!', 5);  
INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) 
        VALUES (2, 2, 4,'Horrible!', 'The store is nasty, and staff is very rude, would not recomment!', 1);     
           
        --a beer review(1)
INSERT INTO reviews(review_type, target_id, user_id, review_title, review_body, review_caps)
        VALUES(1, 17, 1, 'Meeh!', 'I drank the Mango and Ginger seltzer and it tastes like watermelon!', 2);
        
INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) 
        VALUES (1, 1, 1, 'Christmas magic in a a bottle', 'This is one of my all time favorite beers, it keeps me warm and happy all winter long with its perfect combination of spices and Christmas magic', 5);
        
INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) 
        VALUES(1, 1, 3,'Greatest Beer Ever', 'This is the best Xmas beer in the world!', 5);

INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) 
        VALUES(1, 1, 3,'Greatest Beer Ever', 'This is the best Xmas beer in the world!', 5);

INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) 
        VALUES(1, 15, 1, 'Not impressed' , 'The price is god damn high, I can find chaper options' , 3);
INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) 
        VALUES(1, 15, 3, 'Nice' , 'Not the greates beer out there' , 4);
INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) 
        VALUES(1, 15, 5, 'Great' , 'I could drink this beer everyday' , 5);

INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) 
        VALUES (2, 2, 3,'Feels like home', 'The atmosphere is great, and staff is super nice!', 5);
        
INSERT INTO reviews (review_type, target_id, user_id, review_title, review_body, review_caps) 
        VALUES (2, 2, 4,'Horrible!', 'The store is nasty, and staff is very rude, would not recomment!', 1); 


        --some updates
UPDATE reviews SET target_id = ? WHERE id = ?
 
 
 
select * from beers join reviews on reviews.target_id = beers.id
select * from beers;
SELECT * from reviews where target_id = 1


select * from reviews where review_type = 1
SELECT name, SUM(reviews.review_caps)/COUNT(review_caps) AS avg_rating FROM reviews JOIN beers ON reviews.target_id = beers.id WHERE review_type = 1 GROUP BY beers.id, beers.name ORDER BY avg_rating DESC LIMIT 5

SELECT reviews.target_id, beers.name, SUM(reviews.review_caps)/COUNT(*) AS avg_rating FROM reviews 
        JOIN beers ON reviews.target_id = beers.id 
WHERE 
        review_type = 1 GROUP BY reviews.target_id, beers.name ORDER BY avg_rating DESC LIMIT 5;


SELECT reviews.id, review_type, target_id, review_title, review_body, review_caps, users.username FROM reviews JOIN users ON reviews.user_id = users.user_id WHERE target_id = ?











