<template>
  <tr v-bind:class="review.favorited?'fav':'not'">
    <td> {{ review.title }} </td> <!-- title -->
    <td> {{ review.reviewer }} </td> <!--reviewer -->
    <td> {{ review.review }} </td> <!-- review -->
    <td class="stars">
        <img
        src="../assets/star.png"
        v-bind:title="review.rating + ' Star Review'"

        v-for="n in review.rating"
        v-bind:key="n"
        width="20px"
      />
    </td> <!-- rating -->
    <td> {{ review.favorited }} 
        <input type="checkbox" v-bind:checked="review.favorited" v-on:change="onFavoritedChange(review)"/>
    </td> <!-- favorite -->
  </tr>
</template>

<script>
export default {
    name: "review-table-row",
    props: ["review"],
    methods: {
        onFavoritedChange(review){
            this.$store.commit("FLIP_FAVORITED", review);
        }
    }
}
</script>

<style>
    .ratingStar {
        display: flex;
    }

    .fav {
        background-color: cornflowerblue;
    }
</style>