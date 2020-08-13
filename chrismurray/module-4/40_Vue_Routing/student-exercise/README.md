# Routing Exercise

In this exercise, you'll take components from the previous exercise and turn them into a full, single page application using the Vue Router. You may need to make some small changes to some of the existing components, but most of the work is done by creating views and setting their routes.

## Step One: Show a home page with Bestsellers and New Releases

Implement a `Home` view that displays the `BestsellerList` and `NewReleasesList` components. Make this view appear when the path is `/`.

After this is done, all tests under "Step One Tests" should pass.

![Bestseller and New Releases Page at /](etc/bestseller-and-new-releases-page.png)

## Step Two: Display the Reading List

Implement a `MyBooks` view that displays the `ReadingList` component. Make this view appear when the path is `/myBooks`.

Once this is completed, all tests under "Step Two Tests" should pass.

![Page displaying at /myBooks](etc/page-at-my-books.png)

## Step Three: Implement navigation in the App component

Implement navigation in a `<nav>` element at the top of the `App` component. There should be a link to the `Home` view and a link to the `MyBooks` view.

Once that is done, all tests under "Step Three Tests" should pass.

![Top Navigation in App](etc/top-navigation.png)

## Step Four: Display the Book Form

Implement a `NewBook` view that displays the `NewBookForm` component at the path `/addBook`.

Now all tests under "Step Four Tests" should pass.

![New Book Page at /addBook](etc/new-book-page.png)

## Step Five: Integrate the New Book Form into application

Add a link to the bottom of the `MyBooks` view that links to the `NewBook` view. Also, change the submission logic of the `NewBookForm` component so that it goes back to the `MyBooks` view when a book is successfully added to the list.

Hint: You need to change the `NewBookForm` component to do that navigation using the `this.$router` object.

![Link to the new book form](etc/new-book-link.png)

Now all tests under "Step Five Tests" should pass.

## Step Six: Create a Book Detail view

Create a new component called `BookDetails` that shows all of a book's details on the screen. A basic version would be something like this:

![Book Detail Page](etc/book-detail-page.png)

Create a view and a dynamic route with the path `/book/` plus the `isbn` number on the end—for example, `/book/9781400079278`. Use that number to look up the book for the `BookDetails` component.

Finally, link the `BookCard` components in the `ReadingList` component to this new route, making sure to have the book's `isbn` as part of the link when the `BookCard` is clicked.

![Reading List with individual book links](etc/reading-list-with-links.png)

Now all tests, including "Step Six Tests" should pass.