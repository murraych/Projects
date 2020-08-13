package com.techelevator.auction;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class AppTest {

        App app;
        RestTemplate mockRestTemplate;
        InputStream systemInput;

        private final Auction[] auctions = { new Auction(0, "Zero", "Zero Auction", "User0", 0.0),
                        new Auction(1, "One", "One Auction", "User1", 1.1) };

        private final Auction auction = new Auction(0, "Zero", "Zero Auction", "User0", 0.0);

        /**
         * Scanner is instantiated with System.in and must be started for each test
         * individually.
         * 
         * @param input
         */
        private void initForScannerPurposes(String input) {
                System.setIn(new ByteArrayInputStream(input.getBytes()));
                app = new App();
                // Creates new scanner with test input stream
                app.init();
                mockRestTemplate = Mockito.mock(RestTemplate.class);
        }

        /**
         * reduce repeated code
         * 
         * @param url
         */
        private void mockHelper(String url) {
                Mockito.when(mockRestTemplate.getForObject(Mockito.eq(url), Mockito.eq(Auction[].class)))
                                .thenReturn(auctions);

                app.restTemplate = mockRestTemplate;
        }

        /**
         * grab System.in so it can be restored
         */
        @Before
        public void setUp() {
                systemInput = System.in;
        }

        @After
        public void tearDownInput() {
                System.setIn(systemInput);
                app = null;
        }

        @Test
        public void listAllAuctions() {
                initForScannerPurposes("1");
                mockHelper("http://localhost:3000/auctions");
                assertArrayEquals(app.listAllAuctions(), auctions);
        }

        @Test
        public void listDetailsForAuction() {
                initForScannerPurposes("1");
                String url = "http://localhost:3000/auctions/1";

                Mockito.when(mockRestTemplate.getForObject(Mockito.eq(url), Mockito.eq(Auction.class)))
                                .thenReturn(auction);
                app.restTemplate = mockRestTemplate;

                assertEquals(auction, app.listDetailsForAuction());
        }

        /*
         * Test should pass without throwing a NumberFormatException
         */
        @Test
        public void listDetailsForAuctionShouldNotThrowNumberFormatException() {
                // Arrange
                initForScannerPurposes("what");
                String url = "http://localhost:3000/auctions/what";

                Mockito.when(mockRestTemplate.getForObject(Mockito.eq(url), Mockito.eq(Auction.class)))
                                .thenThrow(new NumberFormatException());
                app.restTemplate = mockRestTemplate;

                // Act
                Auction auction = app.listDetailsForAuction();

                // Assert
                Mockito.verify(mockRestTemplate, Mockito.times(1)).getForObject(ArgumentMatchers.anyString(),
                                ArgumentMatchers.eq(Auction.class));

                assertEquals(auction, null);
        }

        @Test
        public void findAuctionsSearchTitle() {
                initForScannerPurposes("Zero");
                mockHelper("http://localhost:3000/auctions?title_like=Zero");
                assertArrayEquals(auctions, app.findAuctionsSearchTitle());
        }

        @Test
        public void findAuctionsSearchTitleShouldNotThrowHttpClientErrorException() {
                // Arrange
                initForScannerPurposes("nope");
                Mockito.when(mockRestTemplate.getForObject(Mockito.eq("http://localhost:3000/auctions?title_like=nope"),
                                Mockito.eq(Auction[].class)))
                                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));
                app.restTemplate = mockRestTemplate;

                // Act
                Auction[] auctions = app.findAuctionsSearchTitle();

                // Assert
                Mockito.verify(mockRestTemplate, Mockito.times(1)).getForObject(ArgumentMatchers.anyString(),
                                ArgumentMatchers.eq(Auction[].class));
                assertArrayEquals(auctions, null);
        }

        @Test
        public void findAuctionsSearchPrice() {
                initForScannerPurposes("23.25");
                mockHelper("http://localhost:3000/auctions?currentBid_lte=23.25");
                assertArrayEquals(app.findAuctionsSearchPrice(), auctions);
        }

        /*
         * Test should pass without throwing a NumberFormatException
         */
        @Test
        public void findAuctionsSearchPriceShouldNotThrowNumberFormatException() {
                // Arrange
                initForScannerPurposes("what");
                Mockito.when(mockRestTemplate.getForObject(
                                Mockito.eq("http://localhost:3000/auctions?currentBid_lte=what"),
                                Mockito.eq(Auction[].class))).thenThrow(new NumberFormatException());
                app.restTemplate = mockRestTemplate;

                // Act
                Auction[] auctions = app.findAuctionsSearchPrice();

                // Assert
                Mockito.verify(mockRestTemplate, Mockito.times(1)).getForObject(ArgumentMatchers.anyString(),
                                ArgumentMatchers.eq(Auction[].class));

                assertArrayEquals(auctions, null);
        }
}
