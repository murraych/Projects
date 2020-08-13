package com.techelevator.controller;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    	CatFact fact = catFactService.getFact();
    	CatPic pic = catPicService.getPic();
    	CatCard card = new CatCard();
    	card.setCatFact(fact.getText()); // get the random fact from the Web API in the CatFactService
    	card.setImgUrl(pic.getFile());   // get the random picture from the Web API in the CatPicService
    	return card;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public CatCard saveNewCard(@Valid @RequestBody CatCard catCard) {
    	catCardDao.save(catCard);
    	return catCard;
    }
    
    @RequestMapping (path = "/{id}", method = RequestMethod.GET)
    public CatCard getSingleCard(@PathVariable long id) {
    	System.out.println(id );
    	return catCardDao.get(id);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateCard(@Valid @RequestBody CatCard card, @PathVariable long id) {
    	catCardDao.update(id, card);
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteCard(@PathVariable long id) {
    	if (catCardDao.get(id) != null) {
    		catCardDao.delete(id);
    	}
    }
 /*   
    * `GET /api/cards`: Provides a list of all Cat Cards in the user's collection.  **** DONE ****
    * `GET /api/cards/{id}`: Provides a Cat Card with the given ID. *** DONE ***
    * `GET /api/cards/random`: Provides a new, randomly created Cat Card containing information from the cat fact and picture services. *** DONE ***
    * `POST /api/cards`: Saves a card to the user's collection.  *** DONE ***
    * `PUT /api/cards/{id}`: Updates a card in the user's collection.
    * `DELETE /api/cards/{id}`: Removes a card from the user's collection.
  */  

}
