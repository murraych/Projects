<template>
  <div id='form'>
     <button v-if="showForm === false" v-on:click.prevent="showForm = true">Add Review</button>
      <form id="add-review-form" v-if="showForm===true" v-on:submit.prevent="addReview">
          <div class="form-element">
              <input type="text" class="reivew-title" placeholder="Title" v-model="review.reviewTitle"/>
          </div>
          <div class="form-element">
              <textarea class="review-body" placeholder="What did you think of this beer?" v-model="review.reviewBody"/>
          </div>
          <div class="form-element">
              <label for="review-caps">Rating:</label>
              <select name="review-caps" id="review-caps" v-model="review.reviewCaps">
                  <option value="1">1</option>
                <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
              </select>
          </div>
        <div class="buttons-div">
        <input type="submit" value="Save Review" class='form-btns'>
        <input type="button" value="Cancel" class='form-btns' v-on:click.prevent="resetForm">
      </div>
      </form>
  </div>
</template>

<script>
import reviewService from '../services/ReviewService';

export default {
    name: 'review-form',
    props: {
        targetId: Number
    },

    data() {
        return {
            showForm: false,
            review: {
                reviewTypeId: 1,
                targetId: 0,
                userId: 0,
                reviewTitle: '',
                reviewBody: '',
                reviewCaps: 1
            },
        }
    },

    methods: {
        resetForm() {
            this.showForm = false;
        },

        addReview() {
            reviewService.add(this.review)
            .then(response=> {
                if (response.status === 201) {
                    this.resetForm();
                    window.location.reload();
                }
            })
            .catch(error=> {
                console.error(error);
            })
        },
    },

    created() {
        this.review.targetId = this.targetId;
        this.review.userId = this.$store.state.user.id;
    }
}
</script>

<style>
    #form {
        width: 100%;
        margin-bottom: 20px;
        margin-right: 250px;
    }

    #form button {
        width: 100%;
    }

    #add-review-form {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    #add-review-form input, textarea {
        width: 100%;
        padding: 10px;
    }

    #add-review-form label {
        color: white;
        margin-right: 5px;
    }

    #add-review-form .buttons-div .form-btns {
        padding: 5px;
        height: 30px;
    }
</style>