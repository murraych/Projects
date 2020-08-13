<template>
<section>
    <h2>Bestsellers</h2>
  <div class="bestseller-list">
    <book-card v-for="book in books" v-bind:book="book" v-bind:key="book.isbn" enable-add="true" />
  </div>
  </section>
</template>

<script>
import BookCard from '@/components/BookCard.vue';

export default {
  name: "bestseller-list",
  computed: {
    books() {
      return this.$store.state.popularBooks.filter((book) => {
        return book.bestseller === true;
      });
    }
  },
  components: {
    BookCard
  }
}
</script>

<style>
.bestseller-list {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>