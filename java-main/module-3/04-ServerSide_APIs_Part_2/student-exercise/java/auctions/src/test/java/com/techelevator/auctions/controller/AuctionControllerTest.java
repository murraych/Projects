package com.techelevator.auctions.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;

@RunWith(SpringRunner.class)
@WebMvcTest(AuctionController.class)
public class AuctionControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    private AuctionDAO dao;

    public AuctionControllerTest() {
        dao = new MemoryAuctionDAO();
    }

    @Test
    public void createShouldAddNewAuction() throws Exception {
        Auction auction = new Auction(
                "Standing Desk",
                "Stand up desk to help you stretch your legs during the day.",
                "Johnnie34",
                350.00);

        mvc.perform(post("/auctions").contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction))).andExpect(status().isCreated()).andExpect(jsonPath("$.id").value(8));
    }

    @Test
    public void invalidAuctionShouldNotBeCreated() throws Exception {
        Auction auction = new Auction(
                "",
                "",
                "",
                0);

        mvc.perform(post("/auctions").contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction))).andExpect(status().isBadRequest());
    }

    @Test
    public void updateShouldUpdateExistingAuction() throws Exception {
        List<Auction> allAuctions = dao.list();
        Auction auction = allAuctions.get(0);
        auction.setTitle("MY_NEW_TITLE");

        mvc.perform(put("/auctions/" + auction.getId()).contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction))).andExpect(status().isOk()).andExpect(jsonPath("$.title").value("MY_NEW_TITLE"));
    }

    @Test
    public void invalidAuctionShouldNotBeUpdated() throws Exception {
        List<Auction> allAuctions = dao.list();
        Auction auction = allAuctions.get(0);
        auction.setTitle("");

        mvc.perform(put("/auctions/" + auction.getId()).contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction))).andExpect(status().isBadRequest());
    }

    @Test
    public void updateWithInvalidIdShouldReturnNotFound() throws Exception {
        List<Auction> allAuctions = dao.list();
        Auction auction = allAuctions.get(0);

        mvc.perform(put("/auctions/99").contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction))).andExpect(status().isNotFound());
    }

    @Test
    public void deleteShouldRemoveAuction() throws Exception {
        int count = dao.list().size();
        mvc.perform(delete("/auctions/5")).andExpect(status().isNoContent());
        mvc.perform(get("/auctions").accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(count-1)));
    }

    @Test
    public void deleteWithInvalidIdShouldReturnNotFound() throws Exception {
        mvc.perform(delete("/auctions/99")).andExpect(status().isNotFound());
    }

    private String toJson(Auction auction) throws JsonProcessingException {
        return mapper.writeValueAsString(auction);
    }

}