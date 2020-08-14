<template>
  <div class='container'>
    <div class='container-item card beer'>
        <img class='beer-img' :src="beer.image" :alt="beer.name">
        <div>
            <h1 id="beer-name">{{beer.name}}</h1>
            <p>{{beer.description}}</p>
            <p>ABV: {{beer.abv}}%</p>
            <p>{{beer.glutenFree ? "Gluten-Free" : "Not Gluten-Free"}}</p>
            <div class="actions" v-if="$store.state.user.authorities[0].name == 'ROLE_BREWER'">
                <button>
                    <router-link class='edit-link' :to="{name: 'edit-beer', params: {breweryId: beer.breweryId, beerId: beer.id}}">Edit</router-link>
                </button>
            </div>
    </div>
    </div>
    <div class='container-item'>
         <!-- <h1 v-if="reviews.length != 0">Reviews</h1> -->
    <div class="reviews">
        <div class="review card" v-for="review in paginatedReviews" v-bind:key="review.id">
            <div class="review-info">
                <h2 class='title'>{{review.reviewTitle}}</h2>
                <h4 class='username'> Reviewed by: {{review.username}}</h4>
            </div>
            <img class='caps' src="../assets/beermug.png" v-for="n in review.reviewCaps" v-bind:key="n">
            <p class='body'>{{review.reviewBody}}</p>
            <a href="#" 
                v-if="review.username == $store.state.user.username"
                v-on:click.prevent="deleteReview(review.id)"
            >
                Delete
            </a>
        </div>
        <div class="page-buttons" >
          <button v-on:click="prevPage" v-show="pageNumber != 0">Previous</button>
          <button v-on:click="nextPage" v-show="pageNumber < pageTotal -1">Next</button>
          <span id='page-count' v-if="paginatedReviews.length > 2">{{pageNumber + 1}} / {{pageTotal}}</span>
        </div>
         <div v-if="$store.state.user.authorities[0].name == 'ROLE_USER'">
          <review-form v-bind:targetId="$route.params.beerId"></review-form>
      </div>
    </div>
    </div>
  </div>
</template>

<script>
import beerService from '../services/BeerService';
import reviewService from '../services/ReviewService';
import ReviewForm from './ReviewForm';

export default {
    name: 'beer-info',
    props: {
        'breweryId': Number,
        'beerId': Number,
        size: {
            type: Number,
            required: false,
            default: 2
        }
    },

    components: {
        ReviewForm
    },

    methods: {
        remove() {
            beerService.delete(this.beer.id)
                .then(response=> {
                    if (response.status === 200) {
                        this.$router.push('/' + this.breweryId + '/beers');
                    }
                })
                .catch(error=> {
                    console.error(error);
                    alert('Beer could not be deleted.');
                })
        },

        updateBeer() {

        },

        deleteReview(reviewId) {
            reviewService.delete(reviewId)
                .then(response=> {
                    if (response.status === 200) {
                        window.location.reload();
                    }
                })
                .catch(error=> {
                    alert("Could not delete this review.");
                    console.error(error);
                })
        },

        prevPage() {
            this.pageNumber--;
        },

        nextPage() {
            this.pageNumber++;
        }
    },

    computed: {
        pageTotal() {
            return Math.ceil(this.reviews.length / this.size);
        },

        paginatedReviews() {
            const start = this.pageNumber * this.size;
            const end = start + this.size;

            return this.reviews.slice(start, end);
        }
    },

    data() {
        return {
            beer: {},
            reviews: [],
            showForm: false,
            pageNumber: 0
        }
    },

    created() {
        beerService.getById(this.breweryId, this.beerId)
        .then(response=> {
            if (response.status === 200) {
                this.beer = response.data
            }
        })
        .catch(error=> {
            console.error(error);
        });

        reviewService.list(this.beerId)
            .then(response=> {
                if (response.status === 200) {
                    this.reviews = response.data
                }
            })
            .catch(error=> {
                console.error(error);
            })
    },
}
</script>

<style>

    .container {
        display: flex;
        justify-content: space-between;
        min-height: 100vh;
    }

    .beer {
        display: flex;
        justify-content: space-around;
        align-items: center;
        max-height: 60vh;
    }

    #beer-name {
        color: #25271c;
    }

    .reviews {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

   
    .review {
        width: 70%;
    }

   
    .beer-img {
        max-width: 50%;
        height: 70%;
        margin-right: 15px;
    }

    .container-item {
        width: 100%;
        margin: 10px;
    }

    .container-item h1 {
        text-align: center;
        color: #c69a24;
        margin-top: -15px;
    }

    .title {
        color: #25271c;
    }

    .caps {
        width: 24px;
        display: inline-block;
        margin-top: 10px;
    }

    .review-info {
        line-height: 0.5;
        padding: 15px;
        border-bottom: 1px solid #25271c;
        background-color: #ceb161;
        margin-top: -20px;
        margin-left: -15px;
        margin-right: -15px;
    }

    .review-info .username  {
        margin-left: 0px;
    }

    .actions button {
        width: 100%;
    }

    button .edit-link {
        width: 100%;
        padding-left: 40px;
        padding-right: 40px;
    }

    .card {
        background-color: white;
        border-radius: 3px;
        padding: 15px;
        box-shadow: 1px 2px 5px black;
        margin-bottom: 10px;
    }

    .edit-link {
        text-decoration: none;
        color: white;
    }

    .page-buttons {
        padding-bottom: 0px;
    }

    #page-count {
        color: white;
    }
    
    @media (max-width: 800px) {
        .container {
            flex-direction: column;
            
      }

        .beer {
            width: 80%;
            margin-left: 7%;
            max-height: 80vh;
            flex-direction: column;
            align-items: center;
        }

        .beer-img {
            width: 20%;
            margin-bottom: 20px;
        }

        .reviews {
            margin-right: 2%;
            margin-top: 40px;
        }

        .container-item h1 {
            display: none;
        }

    }


</style>