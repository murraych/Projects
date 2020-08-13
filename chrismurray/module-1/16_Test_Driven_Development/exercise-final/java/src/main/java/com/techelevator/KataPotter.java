package com.techelevator;

/* SOLUTION
 * Define all price levels per set size (e.g. 1 book costs 8.0, 2 unique books cost $15.20, etc.
 * Build a basket that represents the quantity of each book purchased
 * Iterate through the basket as necessary as long as items remain
 *  Iterate thru and check to see if there is a book 1, if yes - add to set and remove from basket
 *  Iterate thru and check to see if there is a book 2, if yes - add to set and remove from basket
 *  ...
 *  Get the cost of that set and add it to the sum
 *  except If we've got 3 books in the basket and we've got a set of 5..its cheaper to break into 2 sets of 4
 */
public class KataPotter {
    public double getCost(int[] books) {
        double sum = 0.0;
        double[] priceLevels = { 0, 8.0, 15.2, 21.6, 25.6, 30.0 };

        int[] basket = new int[5];
        for (int i = 0; i < books.length; i++) {
            basket[books[i]]++;
        }

        while (sum(basket) > 0) {
            int booksInTheSet = 0;
            for (int i = 0; i < 5; i++) {
                if (basket[i] != 0) {
                    basket[i]--;
                    booksInTheSet++;
                }
            }

            // Its cheaper to get 2 sets of 4 than a set of 5 and a set of 3
            if (booksInTheSet == 5 && sum(basket) == 3 && !contains(basket, 3)) {
                sum += priceLevels[4] * 2;
                break;
            }

            sum += priceLevels[booksInTheSet];
        }

        return sum;
    }

    private boolean contains(int[] basket, int i) {
        for (int element : basket) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    private int sum(int[] summer) {
        int sum = 0;
        for (int num : summer) {
            sum += num;
        }
        return sum;
    }
}
