# Week 7 Pair Exercises: Cat Cards

## Context

Congratulations on your new job at _HazBro_. You'll be working on their latest project, *Cat Cards*. To facilitate development, the VP in charge of this project split the development staff into two teams: Database, Frontend, and Backend.  Your co-worker, Harvey, has started to work on some of the code, but has been called to another team.  It is your job to review the code and determine what has yet to be coded, fixing any problems that may occur.

The Frontend team developed their part of the application. However, they need you to provide the data so it works properly. They gave you the following API documentation:

* `GET /api/cards`: Provides a list of all Cat Cards in the user's collection.
* `GET /api/cards/{id}`: Provides a Cat Card with the given ID.
* `GET /api/cards/random`: Provides a new, randomly created Cat Card containing information from the cat fact and picture services.
* `POST /api/cards`: Saves a card to the user's collection.
* `PUT /api/cards/{id}`: Updates a card in the user's collection.
* `DELETE /api/cards/{id}`: Removes a card from the user's collection.

### Cat Card JSON object structure

Here's the JSON object structure for a Cat Card:

```
{
    "id" : an integer that represents this particular card's unique identifier,
    "imgUrl" : "A string containing the full URL to the cat image",
    "fact" : "A string containing a cat fact",
    "caption" : "A string containing the caption for this particular card"
}
```

### Cat Card collection example

Here's an example collection of Cat Cards:

```
[
    {
        "id" : 17,
        "imgUrl" : "https://purr.objects-us-east-1.dream.io/i/8M3AW.jpg",
        "fact" : "Cats sleep 70% of their lives.",
        "caption" : "Aww, this reminds me of Lefty! He slept CONSTANTLY."
    },

    {
        "id" : 38,
        "imgUrl" : "https://purr.objects-us-east-1.dream.io/i/image.jpeg",
        "fact" : "People who own cats have on average 2.1 pets per household, whereas dog owners have about 1.6.",
        "caption" : "Bartender, I'll take a Salty *Cat*"
    }
]
```

Once you provide implementation for the above endpoints and return properly formatted JSON objects in the agreed-upon schema, the application works.

> Hint: Consider starting with the controller method that provides a new card.

### Cat APIs

There are two web APIs that will provide you with sources of random cat fact and cat picture data.

You can use `https://random-cat-image.herokuapp.com/` to retrieve the URL of a random cat picture as a JSON object that looks like this:

```
{"file":"https:\/\/purr.objects-us-east-1.dream.io\/i\/VEcIJ.jpg"}
```

You should implement a `RestCatPicService` to call this endpoint and return the data as a `CatPic` object.

You can use `https://cat-fact.herokuapp.com/facts/random` to retrieve random cat facts.

You will find additional documentation for this endpoint at `https://alexwohlbruck.github.io/cat-facts/docs/endpoints/facts.html`.

You should implement a `RestCatFactService` to call this endpoint and return the data as a `CatFact` object.

### Database

The Database team has been pulled off to work another project, but they have provided the user script that sets up a catcards_owner user with the password of cheezburger. Your boss has asked you to create the database and script to store the cat card information. You may have to also provide the DAO, which will earn you brownie points with your boss. 

### Getting started

1. Create your database, create the table.

2. Launch this project by running it as a Spring Boot application and navigate to `http://localhost:8080`.

