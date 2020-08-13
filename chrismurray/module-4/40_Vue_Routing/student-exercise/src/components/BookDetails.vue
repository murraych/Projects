<template>
  <div>
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="book-author">{{ book.author }}</h3>
    <img
      v-if="book.isbn"
      v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'"
    />
    <p v-if="book.read">
        I have Read This Book
    </p>
    <p v-if="!book.read">
        I have Not Read This Book
    </p>
  </div>
</template>

<script>
export default {
   name: 'book-details',
   props: {
       book: Object
   }

};
</script>

<style>
</style>