<template>
  <form class = "new-book-form" v-on:submit.prevent="addNewBook">
    <label for="title">Title</label><br>
    <input type="text" class="title-input" v-model="newBook.title"><br>
    <label for="author">Author</label><br>
    <input type="text" class="author-input" v-model="newBook.author"><br>
    <label for="isbn">ISBN</label><br>
    <input type="text" class="isbn-input" v-model="newBook.isbn"><br>
    <input type="submit" value="Add New Book">

  </form>
</template>

<script>
export default {
    data() {
        return {
            newBook:{
                title: '',
                author: '',
                isbn: '',
                read: false
            }
        };
    },
    methods: {
        addNewBook(){
        this.$store.commit('CREATE_NEW_BOOK', this.newBook);
    }
    }
}
</script>

<style>

</style>