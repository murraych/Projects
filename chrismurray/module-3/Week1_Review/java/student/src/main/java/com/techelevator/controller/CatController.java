package com.techelevator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;

@RestController
@RequestMapping("/api/cards")
public class CatController {

    private CatCardDAO catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<CatCard> list() {
    	return catCardDao.list();
    }
    
    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public CatCard makeCatCard() {
    	CatFact fact = catFactService.getCatFact();
    	CatPic pic = catPicService.getPic();
    	CatCard card = new CatCard();
    	card.setCatFact(fact.getText());
    	card.setImgUrl(pic.getFile());
    	return card;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public CatCard saveNewCard(@RequestBody CatCard catCard) {
    	catCardDao.save(catCard); 
    	return catCard;
    }
    

/* `GET /api/cards`: Provides a list of all Cat Cards in the user's collection.
* `GET /api/cards/{id}`: Provides a Cat Card with the given ID.
* `GET /api/cards/random`: Provides a new, randomly created Cat Card containing information from the cat fact and picture services.
* `POST /api/cards`: Saves a card to the user's collection.
* `PUT /api/cards`: Updates a card in the user's collection.
* `DELETE /api/cards`: Removes a card from the user's collection.
 */   
    
}
