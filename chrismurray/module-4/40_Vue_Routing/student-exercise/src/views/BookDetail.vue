<template>
  <div>
    <router-link v-bind:to="{name: 'home'}">Home</router-link>|
    <router-link v-bind:to="{name: 'myBooks'}">My Books</router-link>
    <book-details v-bind:book="findBook"/>
  </div>
</template>

<script>
import BookDetails from "@/components/BookDetails";
export default {
  components: {
    BookDetails,
  },
  computed: {
    findBook() {
      let foundBook = this.$store.state.books.find((book) => {
        return book.isbn === this.$route.params.isbn;
      });
      if (foundBook) {
        return foundBook;
      } else {
        return {
          title: "",
          author: "",
          read: false,
          isbn: "",
        };
      }
    },
  },
};
</script>

<style>
</style>