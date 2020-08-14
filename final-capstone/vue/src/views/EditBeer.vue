<template>
  <div id="view-container">
      <div id="edit-beer-container">
          <form id="edit-form" v-on:submit.prevent="editBeer">
        <div class="form-element">
            <input :placeholder="beer.name" class='name-input' type="text" v-model="beer.name"/>
        </div>
        <div class="form-element">
            <input :placeholder="beer.description" class='description-input' type="text" v-model="beer.description"/>
        </div>
        <div class="form-element">
            <input :placeholder="beer.image" class='image-input' type="text" v-model="beer.image"/>
        </div>
        <div class="form-element">
            <input :placeholder="beer.abv" class='abv-input' type="text" v-model="beer.abv"/>
        </div>
        <div class="form-element gfcheck">
            <label for="checkbox">
              <input type="checkbox" class="beer-gf" v-on:change="setGf($event)"/>
              Gluten-Free?
            </label>
        </div>
      <div class="buttons-div">
        <input type="submit" value="Update Beer" class='form-btns'>
        <input type="button" value="Cancel" class='form-btns' v-on:click.prevent="cancel">
      </div>
      </form>
      </div>
      
  </div>
</template>

<script>
import beerService from '../services/BeerService';

export default {
    name: 'edit-beer',
    data() {
        return {
            beer: {},
        }
    },

    methods: {
        editBeer() {
            this.beer.beerTypeId = parseInt(this.beer.beerType);
            beerService.update(this.beer)
                .then(response=> {
                    if (response.status === 200) {
                        this.$router.push('/' + this.beer.breweryId + '/beers/' + this.beer.id);
                    }
                })
                .catch(error=> {
                    console.error(error);
                    alert('Could not update this beer.');
                })
        },

        cancel() {
            this.$router.push('/' + this.beer.breweryId + '/beers/' + this.beer.id);
        },

        setGf(event) {
            if (event.target.checked) {
                this.beer.glutenFree = true;
            } else {
                this.beer.glutenFree = false;
            }
        }
    },

    created() {
        beerService.getById(this.$route.params.breweryId, this.$route.params.beerId)
            .then(response=> {
                if (response.status === 200) {
                    this.beer = response.data;
                }
            })
            .catch(error=> {
                console.error(error);
            })
    }
}
</script>

<style>

    #view-container {
        display: flex;
        justify-content: center;
        padding-top: 60px;
    }
    #edit-beer-container {
        background-color: white;
        box-shadow: 1px 2px 5px black;
        border-radius: 3px;
        width: 50%;
        padding: 15px;
        display: flex;
        justify-content: center;
    }

    #edit-form {
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    #edit-form .form-element {
        display: flex;
        justify-content: center;
    }

    #edit-form input {
        height: 35px;
    }

   #edit-form .beer-gf {
        width: 15px;
        height: 15px;
    }

</style>