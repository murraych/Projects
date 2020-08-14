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
/*
insert into beer_type(name) values('India Pale Ale');       
        
        --10 barrels brewery and beers
INSERT INTO breweries(name,address1,city,state, zip_code,country,longitude,latitude,website,phone)
        VALUES('10 Barrel Brewing Company','2620 Walnut St','Denver','CO','80205','USA', '-104.985523','39.759762','http://www.10barrel.com','720-573-8992');
        
INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) VALUES (1, 'Apocalypse IPA', 'Apocalypse uses a combination of whole leaf and pellet hops that vreate a full well developed hop flavor.', '
https://10barrel.com/wp-content/uploads/2018/07/Apocalypse-IPA-12oz-Can-2.png', 6.8, 142)  
INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) VALUES (1, 'Joe Ipa', 'Joe Ipa has a bright citrusy flavor and an intense hop aroma', 
'https://10barrel.com/wp-content/uploads/2015/09/Joe-IPA-12oz-Can-2.png', 6.9, 142)  
UPDATE beers SET gluten_free = false WHERE brewery_id = 20;

DELETE FROM breweries WHERE id = 6;

        --Dos Luces
INSERT INTO breweries(name,address1,city,state, zip_code,country,longitude,latitude,website,phone)
        VALUES('Dos Luces Brewery','1236 South Broadway','Denver','CO','80210','USA', '-104.987215','39.694260','https://dosluces.com/','720-379-7763');
        
INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) 
        VALUES (2, 'Metztli-Pulque', 'Nicknamed “Meztli” for the Aztec god of the moon, our Pulque just might lead to some lunacy if you’re not careful.  
        With bold sweet and sour flavors, as well as higher alcohol.', 
        'https://dosluces.com/wp-content/uploads/2018/07/IMG_3599.jpg', 7, 131);
INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) 
        VALUES (2, 'Inti — Chicha', 'An Incan staple still enjoyed throughout the Andes, Chicha is a beer brewed from corn.  
        Dos Luces brews with malted blue corn, and we mix with whole kernels of Peruvian purple corn to give our Chicha its distinctive color and flavor.', 
        'https://www.porchdrinking.com/wp-content/uploads/2018/11/dos-luces-chicha.jpg', 5, 131);
        
--Great Divide
INSERT INTO breweries(name,address1,city,state, zip_code,country,longitude,latitude,website,phone)
        VALUES('Great Divide Brewing Co','2201 Arapahoe St','Denver','CO','80205','USA', '-105.058182','40.228322','https://greatdivide.com','303-296-9460');  

INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) VALUES (3, 'Mango + Ginger Whitewater Craft Hard Seltzer ', 
'Mango + Ginger WHITEWATER Craft Hard Seltzer is our refreshing and lively take on a craft spiked seltzer. Brewed with all-natural ingredients, 
gluten-free with low carbs and zero sugar, WHITEWATER showcases real yet subtle fruit flavor', 'https://greatdivide.com/wp-content/uploads/2020/02/WhiteWater-Mango-Ginger-can-No-background-1.png', 5.0, 131);  
INSERT INTO beers(brewery_id, name, description, image, abv, beer_type) VALUES (3, 'Ruby Red Grapefruit Whitewater Craft Hard Seltzer ', 
'Ruby Red Grapefruit WHITEWATER Craft Hard Seltzer is our refreshing and lively take on a craft spiked seltzer. 
Brewed with all-natural ingredients, gluten-free with low carbs and zero sugar, WHITEWATER showcases real yet subtle fruit flavor.', 
'https://greatdivide.com/wp-content/uploads/2020/02/WhiteWater-Rubyred-Grapefruit-can-No-background.png', 5.0, 131)  
 */
        
        --a brewery Review(2),
INSERT INTO reviews(review_type, target_id, user_id, review_title, review_body, review_caps)
        VALUES(2, 3, 1, 'WOW!', 'Joe and Adam are great! Super chill but also enforcing mask and distancing mandates in a friendly way. 
        The beer is great too - especially the hefeweizen and the goose! Highly recommended during these pandemic times and in general!', 5);
        
        --a beer review(1)
INSERT INTO reviews(review_type, target_id, user_id, review_title, review_body, review_caps)
        VALUES(1, 15, 3, 'Meeh!', 'This beer tastes like watermelon!', 2);

INSERT INTO review_type (name) VALUES ('Beer Review');
INSERT INTO review_type (name) VALUES ('Brewery Review');
 
select * from beers
select * from reviews


--Starting Chris Beer Adds

--INSERT INTO beer_type (name) VALUES ('Mexican Lager');
select * from breweries where name='Prost Brewing'

--Prost Brewery
INSERT INTO breweries (name, address1, city, state, zip_code, country, longitude, latitude, phone, website, image, food_id) VALUES('Prost', '2540 19th Street', 'Denver', 'CO', '80211', 'USA', 
                        '-105.006710', '39.761390', '303-729-1175', 'https://prostbrewing.com', 'https://prostbrewing.com/wp-content/themes/prost-custom/images/prost-footer-logo.svg', 1)
--Prost Beers
INSERT INTO beers (brewery_id, name, description, image, abv, beer_type, gluten_free) VALUES (7, 'Pilsner', 'Northern German-style Pils quenches your thirst with a luxuriously subdued malt body and peppery, clean hop finish. Light in color, but full in flavor, this bier is our true pride', 
'https://prostbrewing.com/wp-content/uploads/2019/01/Prost-Pilsner-530x420.png', 4.9, 77, false);
                
INSERT INTO beers (brewery_id, name, description, image, abv, beer_type, gluten_free) VALUES (7, 'Dunkel', 'Frankconian lager dominated by roasted chocolate and nutty notes. Brewerd with darker, imported Munich grain, it finishes pleasantly malty and smooth.', 
'https://prostbrewing.com/wp-content/uploads/2019/01/Prost-Dunkel-530x420.png', 5.6, 124, false);

INSERT INTO beers (brewery_id, name, description, image, abv, beer_type, gluten_free) VALUES (7, 'Weissbier', 'German-style whear ale with strong banana and clove notes. Brewed with the finest imported German ingredients, it is as estery as it is fragrant',
'https://prostbrewing.com/wp-content/uploads/2019/01/Prost-Weissbier-530x420.png', 5.0, 1, false);


--Epic Brewing
INSERT INTO breweries (name, address1, city, state, zip_code, country, longitude, latitude, phone, website, image, food_id) VALUES ('Epic Brewing', '3001 Walnut Street', 'Denver', 'CO', '80205', 'USA',
 '-104.981410', '39.763340', '801-906-0123', 'https://www.epicbrewing.com/', 'https://static1.squarespace.com/static/5ecea08bff39df0155937536/t/5ef21f23cc65d84436289ab7/1596813608918/?format=1500w', 3)

INSERT INTO beers (brewery_id, name, description, image, abv, beer_type, gluten_free) VALUES (8, 'Los Locos', 
'A bright golden lager inspired by the warm sun and white sand beaches of the Gulf. This easy sipping beer has just a hint of malt sweetness, a dash of sea salt and a refreshing splash of  lime. It is the perfect summer after- noon in a glass.',
'https://static1.squarespace.com/static/5ecea08bff39df0155937536/t/5ef0f27335e2b301b6208b28/1592849015058/Los+Locos+Lager.pdf', 4.8, 145, false);

INSERT INTO beers (brewery_id, name, description, image, abv, beer_type, gluten_free) VALUES (8, 'Tart n Juicy Sour IPA', 
'We have combined the clean, puckering tartness of kettle souring  with an abundance of juicy, citrus-driven hops to create a beer that is the best of both worlds - Tart n Juicy Sour IPA.', 
'https://www.epicbrewing.com/s/Tart-n-Juicy-Sour-IPA.pdf', 4.5, 121, false);

INSERT INTO beers (brewery_id, name, description, image, abv, beer_type, gluten_free)
VALUES ((SELECT id FROM breweries WHERE name = 'Epic Brewing'), 'Escape to Colorado', 'This beer is unapologetically hop forward without the bitterness. The perfect companion for your next adventure.',
'https://www.epicbrewing.com/s/Escape-to-Colorado-IPA-rebrand-hw7g.pdf', 6.2, (SELECT id FROM beer_type WHERE name = 'India Pale Ale'), false);


--sandbox
INSERT INTO favorite_breweries (user_id, brewery_id) VALUES (3, 8);


SELECT * FROM favorite_breweries WHERE user_id = 3;


