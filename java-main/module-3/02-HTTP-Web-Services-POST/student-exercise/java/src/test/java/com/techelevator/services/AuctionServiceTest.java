package com.techelevator.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.models.Auction;

public class AuctionServiceTest {

    AuctionService auctionService;
    String testAllUrl = "http://dummy-mock-url.com";
    String testOneUrl = "http://dummy-mock-url.com/1";
    String testTitleUrl = "http://dummy-mock-url.com?title_like=Nothing";
    String testPriceUrl = "http://dummy-mock-url.com?currentBid_lte=23.23";

    RestTemplate mockRestTemplate = null;

    Auction[] auctions = {
            new Auction(0, "Zero", "Zero Auction", "User0", 0.0),
            new Auction(1, "One", "One Auction", "User1", 1.1)};

    Auction auction = new Auction(0, "Zero", "Zero Auction", "User0", 0.0);

    @Before
    public void setUp() {
        mockRestTemplate = Mockito.mock(RestTemplate.class);
        auctionService = new AuctionService(testAllUrl);
    }

    @After
    public void tearDown() {
        auctionService = null;
        mockRestTemplate = null;
    }

    @Test
    public void add_should_return_new_auction() {
        String testAddString = "a,b,c,99.99";
        Auction fake = new Auction(3, "a", "b", "c", 99.99);
        // Need array length from getAll() - mocked with mock autions array
        when(mockRestTemplate.getForObject(
                Mockito.eq(testAllUrl),
                Mockito.eq(Auction[].class)))
                .thenReturn(auctions);
        when(mockRestTemplate.postForObject(
                Mockito.eq(testAllUrl),
                any(HttpEntity.class),
                Mockito.eq(Auction.class)))
                .thenReturn(fake);

        auctionService.restTemplate = mockRestTemplate;
        assertEquals("auctionService.add() should return a new auction",fake, auctionService.add(testAddString));
    }
    
    @Test
    public void add_should_return_null_for_failure_response_code() {
        String testAddString = "a,b,c,99.99";
        // Need array length from getAll() - mocked with mock auctions array
        when(mockRestTemplate.getForObject(
                Mockito.eq(testAllUrl),
                Mockito.eq(Auction[].class)))
                .thenReturn(auctions);
        when(mockRestTemplate.postForObject(
                Mockito.eq(testAllUrl),
                any(HttpEntity.class),
                Mockito.eq(Auction.class)))
                .thenThrow(RestClientResponseException.class);

        auctionService.restTemplate = mockRestTemplate;
        assertEquals("auctionService.add() should return null when RestTemplate throws a RestClientResponseException",null, auctionService.add(testAddString));
        verify(mockRestTemplate).postForObject(Mockito.eq(testAllUrl),
	               any(HttpEntity.class),
	               Mockito.eq(Auction.class));
    }
    
    @Test
    public void add_should_return_null_for_communication_failure() {
        String testAddString = "a,b,c,99.99";
        // Need array length from getAll() - mocked with mock auctions array
        when(mockRestTemplate.getForObject(
                Mockito.eq(testAllUrl),
                Mockito.eq(Auction[].class)))
                .thenReturn(auctions);
        when(mockRestTemplate.postForObject(
                Mockito.eq(testAllUrl),
                any(HttpEntity.class),
                Mockito.eq(Auction.class)))
                .thenThrow(ResourceAccessException.class);

        auctionService.restTemplate = mockRestTemplate;
        assertEquals("auctionService.add() should return null when RestTemplate throws a ResourceAccessException",null, auctionService.add(testAddString));
        verify(mockRestTemplate).postForObject(Mockito.eq(testAllUrl),
								               any(HttpEntity.class),
								               Mockito.eq(Auction.class));
    }

    @Test
    public void update_should_return_updated_auction() {
        String testUpdateString = "9,q,w,e,11.11";
        Auction fake = new Auction(9, "q", "w", "e", 11.11);
        Mockito.doNothing().when(mockRestTemplate).put(
                Mockito.eq(testOneUrl),
                Mockito.eq(makeEntityHelper(fake)));

        auctionService.restTemplate = mockRestTemplate;
        Auction updatedAuction = auctionService.update(testUpdateString);
        assertNotNull("auctionService.update() should return the updated auction", updatedAuction);
        assertEquals("The updated auction does not match the expected result ",fake.toString(), updatedAuction.toString());
    }
    
    @Test
    public void update_should_return_null_for_failure_response_code() {
        String testUpdateString = "9,q,w,e,11.11";
        Mockito.doThrow(RestClientResponseException.class).when(mockRestTemplate).put(
                Mockito.anyString(),
                Mockito.any());

        auctionService.restTemplate = mockRestTemplate;
        Auction updatedAuction = auctionService.update(testUpdateString);
        assertNull("auctionService.update() should return null when RestTemplate throws a RestClientResponseException", updatedAuction);
        verify(mockRestTemplate).put(Mockito.anyString(), Mockito.any());
    }
    
    @Test
    public void update_should_return_null_for_communication_failure() {
        String testUpdateString = "9,q,w,e,11.11";
        Mockito.doThrow(ResourceAccessException.class).when(mockRestTemplate).put(
                Mockito.anyString(),
                Mockito.any());

        auctionService.restTemplate = mockRestTemplate;
        Auction updatedAuction = auctionService.update(testUpdateString);
        assertNull("auctionService.update() should return null when RestTemplate throws a ResourceAccessException", updatedAuction);
        verify(mockRestTemplate).put(Mockito.anyString(), Mockito.any());
    }

    @Test
    public void delete_should_return_true_when_resource_successfully_deleted() {
    	// No need for doNothing() since it is Mockito's default behavior for void methods.
        auctionService.restTemplate = mockRestTemplate;
        boolean result = auctionService.delete(1);
        verify(mockRestTemplate).delete(testOneUrl);
        assertTrue("auctionService.delete() should return true for successful deletion.", result);
    }

    @Test
    public void delete_should_return_false_for_failure_response_code() {
    	// No need for doNothing() since it is Mockito's default behavior for void methods.
        auctionService.restTemplate = mockRestTemplate;
        doThrow(RestClientResponseException.class).when(mockRestTemplate).delete(Mockito.anyString());
        boolean result = auctionService.delete(1);
        verify(mockRestTemplate).delete(testOneUrl);
        assertFalse("auctionService.delete() should return false when a RestClientResponseException is thrown.", result);
    }
    
    @Test
    public void delete_should_return_false_for_communication_failure() {
    	// No need for doNothing() since it is Mockito's default behavior for void methods.
        auctionService.restTemplate = mockRestTemplate;
        doThrow(ResourceAccessException.class).when(mockRestTemplate).delete(Mockito.anyString());
        boolean result = auctionService.delete(1);
        verify(mockRestTemplate).delete(testOneUrl);
        assertFalse("auctionService.delete() should return false when a ResourceAccessException is thrown.", result);
    }

    private HttpEntity<Auction> makeEntityHelper(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> entity = new HttpEntity<>(auction, headers);
        return entity;
    }


}
