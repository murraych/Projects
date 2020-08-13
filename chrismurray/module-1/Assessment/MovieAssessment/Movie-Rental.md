# Movie Rental

1. Create a new class that represents a *Movie Rental*.
2. Add a *title*, *format*, *is premium movie*, and *rental price* attribute/property to the Movie Rental class:
    * `title`: indicates the title of the movie.
    * `format`: indicates the format of the movie (VHS, DVD, or Blu-ray).
    * `is premium movie`: indicates if the movie is a premium movie. Premium movies cost more.
    * `rental price`: indicates the rental price (VHS $0.99, DVD $1.99, BluRay $2.99). Premium movies add an additional $1.00 to the rental price.
3. Create a constructor that accepts `title`, `format`, and `is premium movie`.
4. Instantiate an object, or objects, in `main()`/`Main()`, and use the object(s) to test your methods.
5. Create a method that determines the movie's late fee using an input parameter: `int daysLate`:
    * Return $0.00 if `daysLate` is equal to 0.
    * Return $1.99 if `daysLate` is equal to 1.
    * Return $3.99 if `daysLate` is equal to 2.
    * Return $19.99 if `daysLate` is equal to 3 or more.
6. Override the `toString()`/`ToString()` method and have it return `"MOVIE - {title} - {format} {rental price}"` where `{title}`, `{format}`, and `{rental price}` are placeholders for the actual values. The values from the object should be shown in the string where `{variable-name}` is indicated.
7. Implement unit tests to validate the functionality of:
    * The rental price calculation 
    * The late fee calculation
8. In the main program class, within the main method, read in the provided csv file `MovieInput.csv`, and use it to populate a list of *Movie Rental* objects.
9. Add up the rental price for all of the movies in the list, and print it to the screen.