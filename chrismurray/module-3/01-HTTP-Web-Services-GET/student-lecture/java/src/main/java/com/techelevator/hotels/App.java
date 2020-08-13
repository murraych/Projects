package com.techelevator.hotels;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import com.techelevator.city.City;

public class App {
	
	private static final String API_BASE_URL = "http://localhost:3000/";
	private static RestTemplate restTemplate = new RestTemplate();

	public static Hotel[] requestHotels() {
		return restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
		// getForObject("http://localhost:3000/hotels", return data class);
	}
	
	public static Review[] requestReviews() {
		return restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class);
	}
	
	public static Hotel requestHotelById(int id) {
		return restTemplate.getForObject(API_BASE_URL + "hotels/" + id, Hotel.class);
	}
	
	public static Review[] requestReviewsByHotelId(int hotelId) {
		return restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reviews", Review[].class);
	}
	
	public static Hotel[] requestHotelsWithRating3(int stars) {
		return restTemplate.getForObject(API_BASE_URL + "hotels?stars=" + stars, Hotel[].class);
	}
	
    public static void main(String[] args) {
        run();
    }
    
    public static City requestWithCustomQuery() {
    	return restTemplate.getForObject("https://api.teleport.org/api/cities/geonameid:5128581/", City.class);
    }

    private static void run() {
        Hotel[] hotels = null;
        Scanner scanner = new Scanner(System.in);
        int menuSelection = 999;

        printGreeting();

        while(menuSelection != 0) {
            try {
                menuSelection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Error parsing the input for menu selection.");
            }
            System.out.println("");
            if (menuSelection == 1) {
                printHotels(requestHotels());
            } else if (menuSelection == 2) {
                printReviews(requestReviews());
            } else if (menuSelection == 3) {
                printHotel(requestHotelById(1));
            } else if (menuSelection == 4) {
                printReviews(requestReviewsByHotelId(1));
            } else if (menuSelection == 5) {
               printHotels(requestHotelsWithRating3(3));
            } else if (menuSelection == 6) {
                System.out.println(requestWithCustomQuery());
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            menuSelection = 999;
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
            printGreeting();
        }
        scanner.close();
        System.exit(0);
    }

    private static void printGreeting() {
        System.out.println("");
        System.out.println("Welcome to Tech Elevator Hotels. Please make a selection: ");
        System.out.println("1: List Hotels");
        System.out.println("2: List Reviews");
        System.out.println("3: Show Details for Hotel ID 1");
        System.out.println("4: List Reviews for Hotel ID 1");
        System.out.println("5: List Hotels with star rating 3");
        System.out.println("6: Custom Query");
        System.out.println("0: Exit");
        System.out.println("");
        System.out.print("Please choose an option: ");
    }

    private static void printHotels(Hotel[] hotels) {
        System.out.println("--------------------------------------------");
        System.out.println("Hotels");
        System.out.println("--------------------------------------------");
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getId() + ": " + hotel.getName());
        }
    }

    private static void printHotel(Hotel hotel) {
        System.out.println(hotel.toString());
    }

    private static void printReviews(Review[] reviews) {
        for (Review review : reviews) {
            System.out.println(review.toString());
        }
    }

}
