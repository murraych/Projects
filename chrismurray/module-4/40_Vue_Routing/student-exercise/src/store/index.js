import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    books: [
      {
        title: "Kafka by the Shore",
        author: "Haruki Murakami",
        read: false,
        isbn: "9781400079278"
      },
      {
        title: "The Girl With All the Gifts",
        author: "M.R. Carey",
        read: true,
        isbn: "9780356500157"
      },
      {
        title: "The Old Man and the Sea",
        author: "Ernest Hemingway",
        read: true,
        isbn: "9780684830490"
      },
      {
        title: "Le Petit Prince",
        author: "Antoine de Saint-Exupéry",
        read: false,
        isbn: "9783125971400"
      }
    ],
    popularBooks: [
      {
        title: "The Testaments",
        author: "Margaret Atwood",
        bestseller: true,
        newRelease: true,
        isbn: "9780385543781"
      },
      {
        title: "Normal People",
        author: "Sally Rooney",
        bestseller: false,
        newRelease: true,
        isbn: "9781984822178"
      },
      {
        title: "Where the Forest Meets the Stars",
        author: "Glendy Vanderah",
        bestseller: false,
        newRelease: true,
        isbn: "9781542040068"
      },
      {
        title: "Talking to Strangers",
        author: "Malcolm Gladwell",
        bestseller: true,
        newRelease: false,
        isbn: "9780316478526"
      },
      {
        title: "Embrace Your Weird",
        author: "Felicia Day",
        bestseller: true,
        newRelease: false,
        isbn: "9781982113223"
      },
      {
        title: "Recursion",
        author: "Blake Crouch",
        bestseller: false,
        newRelease: true,
        isbn: "9781524759780"
      },
      {
        title: "This Is How You Lose the Time War",
        author: "Amal El-Mohtar",
        bestseller: false,
        newRelease: true,
        isbn: "9781534431003"
      },
      {
        title: "Fire & Blood",
        author: "George R.R. Martin",
        bestseller: true,
        newRelease: false,
        isbn: "9781524796280"
      },
      {
        title: "Of Blood and Bone",
        author: "Nora Roberts",
        bestseller: true,
        newRelease: false,
        isbn: "9781250122995"
      },
    ]
  },
  mutations: {
    SET_READ_STATUS(state, payload) {
      payload.book.read = payload.value;
    },
    SAVE_BOOK(state, book) {
      state.books.push(book);
    }
  },
  actions: {},
  modules: {},
  strict: true
});
