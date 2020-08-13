<template>
    <div class = "main">
        <h2>Product Reviews for {{ name }}</h2>
        <p class = "description"> {{ description }}</p>
        <p>{{ reviews }} </p>
        <div class = "review" v-for="review in reviews" v-bind:key="review.id">
            <h3>{{ review.reviewer }}</h3>
            <div class="rating">
                <img src="../assets/star.png" v-bind:title="review.rating + ' Star Review'" class="rating-star" v-for="n in review.rating" v-bind:key="n"/>
            </div>
            <h4>{{ review.title}}</h4>
            <p>{{ review.review }}</p>


        </div>



    </div>

    
</template>

<script>
export default {
    name: "product-review",
    data() {
        return {
            name: "Cigar Party for Dummies",
            description: "Host and plan a perfect Cigar Party for all your squirrely friends",
            reviews: [
                {
                    reviewer: "Rowdy Randy",
                    title: "Great Read",
                    review: "Best book on cigars ever!",
                    rating: 4
                },
                                {
                    reviewer: "Mary Randy",
                    title: "Great Paper Weight",
                    review: "The whole house stinks, thanks Randy!",
                    rating: 1
                }
            ]
        }
    }
}
</script>

<style>
    div.main {
        margin: 1rem 0;
    }

    .rating-star{
        max-height: 2em;
    }
</style>