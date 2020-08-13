### Potter Kata

Once upon a time, there was a series of five books about a very English hero called Harry. (At least when this Kata was invented, there were only five. Since then they've multiplied.) Children all over the world thought he was fantastic, and of course, so did the publisher. In a gesture of immense generosity to mankind—and to increase sales—they set up the following pricing model to take advantage of Harry’s magical powers.

One copy of any of the five books costs $8. If, however, you buy two different books from the series, you get a 5% discount on those two books. If you buy three different books, you get a 10% discount. With four different books, you get a 20% discount. If you buy all five, you get a 25% discount.

Note that if you buy, say, four books, of which three are different titles, you get a 10% discount on the three that form part of a set, but the fourth book still costs $8.

Your mission is to write a method called `getCost(int[] books)` that calculates the price of any conceivable shopping basket, giving as big a discount as possible. The array of books that is passed to the method indicates the number of copies of each book the customer is purchasing, and the method returns a `double` that represents the cost for all of the books provided.

For instance, if the customer is ordering two copies of the first book, two copies of the second book, two copies of the third book, one copy of the fourth book, and one copy of the fifth book, the method is called as follows:

``` java
getCost(new [] { 2, 2, 2, 1, 1 })
```

The result for the method call is $51.20.

**Hint**

On the surface, this Kata looks easy, but there is certainly a level of complexity. When you calculate the above basket, it isn't `5 * 8 * 0.75 + 3 * 8 * 0.9`. It is actually `4 * 8 * 0.8 + 4 * 8 * 0.8`. The trick is to write code intelligent enough to identify that two sets of four books are cheaper than a set of five and a set of three.