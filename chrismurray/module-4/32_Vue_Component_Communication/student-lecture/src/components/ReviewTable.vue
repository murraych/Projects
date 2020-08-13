<template>
<div>
  <table>
    <thead>
      <tr>
        <th>Title</th>
        <th>Reviewer</th>
        <th>Review</th>
        <th>Rating</th>
        <th>Favorited</th>
      </tr>
    </thead>
    <tbody>
      <review-table-row 

        v-for="review in filteredReviews"
        v-bind:key = "review.title"
        v-bind:review = "review"
      
      />

    </tbody>

  </table>

</div>
</template>

<script>
import ReviewTableRow from "./ReviewTableRow.vue";

export default {
  name: "review-table",
  components: {
    ReviewTableRow
  },
  computed: {
    filteredReviews() {
      const reviewsFilter = this.$store.state.filter;
      const reviews = this.$store.state.reviews;
      return reviews.filter(review => {
        return reviewsFilter === 0 ? true : reviewsFilter === review.rating;
      });
    }
}
}
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
.stars {
  display: flex;
}
</style>
