package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;
		System.out.println(remainingNumberOfBirds);

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;
		System.out.println(numberOfExtraBirds);

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int racoonsPlayingInWoods = 3;
		int racoonsGoHomeForDinner = 2;
		int remainingRacoonsInWoods = racoonsPlayingInWoods - racoonsGoHomeForDinner;
		System.out.println(remainingRacoonsInWoods);

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int flowers = 5;
		int bees = 3;
		int flowersThatDontHaveBees = flowers - bees;
		System.out.println(flowersThatDontHaveBees);

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int lonelyPigeonEatingBreadCrumbs = 1;
		int friendlyPigeonWantingBreadCrumbs = 1;
		int PigeonsNowEatingBreadCrumbs = lonelyPigeonEatingBreadCrumbs + friendlyPigeonWantingBreadCrumbs;
		System.out.println(PigeonsNowEatingBreadCrumbs);

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int OriginalFenceOwls = 3;
		int NewFenceOwls = 2;
		int OwlsNowOnFence = OriginalFenceOwls + NewFenceOwls;
		System.out.println(OwlsNowOnFence);

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int beaversToBuildHome = 2;
		int beaversLeftToSwim = 1;
		int beaversStuckBuildingHome = beaversToBuildHome - beaversLeftToSwim;
		System.out.println(beaversStuckBuildingHome);

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int originalToucansOnLimb = 2;
		int newcomerToucans = 1;
		int toucansNowOnLimb = originalToucansOnLimb + newcomerToucans;
		System.out.println(toucansNowOnLimb);

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrelsInTree = 4;
		int nutsInTree = 2;
		int moreSquirrelsThanNutsInTree = squirrelsInTree - nutsInTree;
		System.out.println(moreSquirrelsThanNutsInTree);

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarter = .25;
		double dime = .10;
		double nickel = .05;
		double mrsHiltFoundMoney = quarter + dime + 2 * nickel;
		System.out.printf("$%.2f\n", mrsHiltFoundMoney);

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int mrsBriersClassMuffins = 18;
		int mrsMacAdamsClassMuffins = 20;
		int mrsFlannerysClassMuffins = 17;
		int firstGradeClassMuffinsTotal = mrsBriersClassMuffins + mrsMacAdamsClassMuffins + mrsFlannerysClassMuffins;
		System.out.println(firstGradeClassMuffinsTotal);

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double yoyo = .24;
		double whistle = .14;
		double mrsHiltMoneySpentOnToys = yoyo + whistle;
		System.out.println(mrsHiltMoneySpentOnToys);

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMallows = 8;
		int miniMallows = 10;
		int riceKrispieRecipe = 5 * (largeMallows + miniMallows);
		System.out.println(riceKrispieRecipe);
		
		/*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int brecknockSnowReceived = 17;
		int mrsHiltsHouseSnowReceived = 29;
		int mrsHiltsAdditionalSnow = mrsHiltsHouseSnowReceived - brecknockSnowReceived;
		System.out.println(mrsHiltsAdditionalSnow);

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		double mrsHiltOriginalWorth = 10.00;
		double toyTruck = 3.00;
		double pencilCase = 2.00;
		double mrsHiltNewWorth = mrsHiltOriginalWorth - (toyTruck + pencilCase);
		System.out.println(mrsHiltNewWorth);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int joshStartingMarbleCollection = 16;
		int joshMarblesLost = 7;
		int joshEndingMarbleCollection = joshStartingMarbleCollection - joshMarblesLost;
		System.out.println(joshEndingMarbleCollection);

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int megansShells = 19;
		int megansShellGoal = 25;
		int megansShellsToFind = megansShellGoal - megansShells;
		System.out.println(megansShellsToFind);

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int bradsBalloons = 17;
		int bradsRedBalloons = 8;
		int bradsGreenBalloons = bradsBalloons - bradsRedBalloons;
		System.out.println(bradsGreenBalloons);

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int booksOnShelf = 38;
		int booksMartaAdded = 10;
		int booksFinalCount = booksOnShelf + booksMartaAdded;
		System.out.println(booksFinalCount);

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int legsOnBee = 6;
		int legsOn8Bees = legsOnBee * 8;
		System.out.println(legsOn8Bees);
		

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double iceCreamCone = .99;
		double twoIceCreamCones = 2 * iceCreamCone;
		System.out.println(twoIceCreamCones);

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int rocksRequired = 125;
		int rocksAcquired = 64;
		int rocksNeeded = rocksRequired - rocksAcquired;
		System.out.println(rocksNeeded);

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int mrsHiltStartingMarbles = 38;
		int mrsHiltLostMarbles = 15;
		int mrsHiltMarblesLeft = mrsHiltStartingMarbles - mrsHiltLostMarbles;
		System.out.println(mrsHiltMarblesLeft);

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int hiltMilesNeeded = 78;
		int milesDriven = 32;
		int milesLeft = hiltMilesNeeded - milesDriven;
		System.out.println(milesLeft);

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int saturdayMorningShovelTime = 90;
		int saturdayEveningShovelTime = 45;
		int totalShovelTime = saturdayMorningShovelTime + saturdayEveningShovelTime;
		System.out.println(totalShovelTime);

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int purchasedHotDogs = 6;
		double pricePerHotDog = .50;
		double totalAmountSpentOnHotDogs = purchasedHotDogs * pricePerHotDog;
		System.out.printf("%.2f\n", totalAmountSpentOnHotDogs);

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		double mrsHiltMoney = .50;
		double pencilCost = .07;
		int numberOfPencilsMrsHiltCanAfford = (int) (mrsHiltMoney / pencilCost);
		System.out.println(numberOfPencilsMrsHiltCanAfford);

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int totalButterfliesMrsHiltSaw = 33;
		int orangeButterflies = 20;
		int redButterflies = totalButterfliesMrsHiltSaw - orangeButterflies;
		System.out.println(redButterflies);

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double amountKateHandedClerk = 1.00;
		double candyCost = .54;
		double katesChange = amountKateHandedClerk - candyCost;
		System.out.printf("%.2f\n", katesChange);

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int treesInMarksBackyard = 13;
		int treesMarkWillPlant = 12;
		int treesMarkWillHavePostPlant = treesInMarksBackyard + treesMarkWillPlant;
		System.out.println(treesMarkWillHavePostPlant);

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int daysUntilJoySeesGrandma = 2;
		int hoursInOneDay = 24;
		int hoursUntilJoySeesGrandma = daysUntilJoySeesGrandma * hoursInOneDay;
		System.out.println(hoursUntilJoySeesGrandma);

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberOfCousinsKimHas = 4;
		int pieceOfGumKimWillGivePerCousin = 5;
		int totalPiecesOfGumKimWillNeed = numberOfCousinsKimHas * pieceOfGumKimWillGivePerCousin;
		System.out.println(totalPiecesOfGumKimWillNeed);

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double dansStartingCash = 3.00;
		double candyBarPrice = 1.00;
		double dansRemainingCash = dansStartingCash - candyBarPrice;
		System.out.printf("%.2f\n", dansRemainingCash);

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsInTheLake = 5;
		int passengersPerBoat = 3;
		int passengersOnLake = boatsInTheLake * passengersPerBoat;
		System.out.println(passengersOnLake);

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int ellensStartingNumberOfLegos = 380;
		int numberOfLegosEllenLost = 57;
		int numberOfRemainingLegos = ellensStartingNumberOfLegos - numberOfLegosEllenLost;
		System.out.println(numberOfRemainingLegos);

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int numberOfMuffinsArthurBaked = 35;
		int numberOfMuffinsDesired = 83;
		int numberOfMuffinsStillNeeded = numberOfMuffinsDesired - numberOfMuffinsArthurBaked;
		System.out.println(numberOfMuffinsStillNeeded);

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willysCrayonCount = 1400;
		int lucysCrayonCount = 290;
		int numberOfCrayonsWillyHasMoreThanLucy = willysCrayonCount - lucysCrayonCount;
		System.out.println(numberOfCrayonsWillyHasMoreThanLucy);

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersPerPage = 10;
		int numberOfPages = 22;
		int totalNumberOfStickers = stickersPerPage * numberOfPages;
		System.out.println(totalNumberOfStickers);

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int totalNumberOfCupcakes = 96;
		int numberOfChildren = 8;
		int cupcakesPerChild = totalNumberOfCupcakes / numberOfChildren;
		System.out.println(cupcakesPerChild);

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int totalNumberOfGingerbreadCookies = 47;
		int cookiesPerGlassJar = 6;
		int cookiesWithoutJarHome = totalNumberOfGingerbreadCookies % cookiesPerGlassJar;
		System.out.println(cookiesWithoutJarHome);

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int croissantsPrepared = 59;
		int neighborsReceivingCroissants = 8;
		int leftoverCookiesForMarian = croissantsPrepared % neighborsReceivingCroissants;
		System.out.println(leftoverCookiesForMarian);

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int totalOatmealCookiesPrepared = 276;
		int oatmealCookiesPerTray = 12;
		int numberOfTraysNeeded = (totalOatmealCookiesPrepared / oatmealCookiesPerTray);
		System.out.println(numberOfTraysNeeded);

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totalNumberOfPretzelsPrepared = 480;
		int pretzelsPerServing = 12;
		int servingsPrepared = totalNumberOfPretzelsPrepared / pretzelsPerServing;
		System.out.println(servingsPrepared);

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int numberOfCupcakesBaked = 53;
		int numberOfCupcakesLeftAtHome = 2;
		int boxesOf3CupcakesGivenAway = (numberOfCupcakesBaked - numberOfCupcakesLeftAtHome) / 3;
		System.out.println(boxesOf3CupcakesGivenAway);

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int amountOfCarrotSticksSusiesMomPrepared = 74;
		int numberOfPeopleServedCarrotSticks = 12;
		int numberOfCarrotSticksUneaten = amountOfCarrotSticksSusiesMomPrepared % numberOfPeopleServedCarrotSticks;
		System.out.println(numberOfCarrotSticksUneaten);

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int totalNumberOfTeddyBearsGathered = 98;
		int maximumNumberOfTeddyBearsPerShelf = 7;
		int numberOfShelvesFilledWithTeddyBears = totalNumberOfTeddyBearsGathered / maximumNumberOfTeddyBearsPerShelf;
		System.out.println(numberOfShelvesFilledWithTeddyBears);

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int picturesPerAlbum = 20;
		int totalNumberOfPicturesCollected = 480;
		int totalNumberOfAlbumsNeeded = totalNumberOfPicturesCollected / picturesPerAlbum;
		System.out.println(totalNumberOfAlbumsNeeded);

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int totalNumberOfTradingCardsCollected = 94;
		int numberOfTradingCardsPerFullBox = 8;
		int numberOfFullBoxesOfTradingCards = totalNumberOfTradingCardsCollected / numberOfTradingCardsPerFullBox;
		int numberOfCardsInTheUnfilledBox = totalNumberOfTradingCardsCollected % numberOfTradingCardsPerFullBox;
		System.out.println(numberOfCardsInTheUnfilledBox); System.out.println(numberOfFullBoxesOfTradingCards);

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int totalNumberOfBooks = 210;
		int totalNumberOfShelves = 10;
		int numberOfBooksPerShelf = totalNumberOfBooks / totalNumberOfShelves;
		System.out.println(numberOfBooksPerShelf);

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int croissantsCristinaBaked = 17;
		int numberOfCristinasGuests = 7;
		int croissantsPerGuest = croissantsCristinaBaked / numberOfCristinasGuests;
		System.out.println(croissantsPerGuest);

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */


	}

}
