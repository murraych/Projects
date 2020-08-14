<template>
  <div>
      <button v-if="showForm === false" v-on:click.prevent="showForm = true">Add Beer</button>
      <form id="add-beer-form" v-if="showForm===true" v-on:submit.prevent="addBeer">
          <div class="form-element">
              <input type="text" class="beer-name" placeholder="Name" v-model="newBeer.name"/>
          </div>
          <div class="form-element">
              <textarea class="beer-description" placeholder="Description" v-model="newBeer.description"/>
          </div>
          <div class="form-element">
              <input type="text" class="beer-img" placeholder="Image URL" v-model="newBeer.image"/>
          </div>
          <div class="form-element">
              <input type="text" class="beer-abv" placeholder="ABV" v-model="newBeer.abv"/>
          </div>
          <div class="form-element">
              <input list='types'>
              <datalist id='types'>
                  <option v-for="type in types" v-bind:key="type.id" :value="type.name"></option>
              </datalist>
          </div>
        <div class="form-element">
            <label for="checkbox">
              <input type="checkbox" class="beer-gf" v-on:change="setGf($event)"/>
              Gluten-Free?
            </label>
          </div>
        <div class="buttons-div">
        <input type="submit" value="Save Beer" class='form-btns'>
        <input type="button" value="Cancel" class='form-btns' v-on:click.prevent="resetForm">
      </div>
      </form>
  </div>
</template>

<script>
import beerService from '../services/BeerService';

export default {
    name: 'new-beer-form',
    props: {
        breweryId: Number
    },

    data() {
        return {
            showForm: false,
            types: [],
            newBeer: {
               breweryId: 0,
               name: '',
               description: '',
               image: '',
               abv: 0,
               beerType: 'Fruit Beer',
               glutenFree: true

            },
        }
    },

    methods: {
        resetForm() {
            this.showForm = false;
        },

        setGf(event) {
            if (event.target.checked) {
                this.newBeer.glutenFree = true;
            } else {
                this.newBeer.glutenFree = false;
            }
        },

        addBeer() {
            beerService.add(this.newBeer)
            .then(response=> {
                if (response.status === 201) {
                    this.resetForm();
                    window.location.reload();
                }
            })
            .catch(error=> {
                console.error(error);
            })
        }

    },

    created() {
        this.newBeer.breweryId = this.breweryId;

        beerService.listBeerTypes()
            .then(response=> {
                if (response.status === 200) {
                    this.types = response.data;
                }
            })
            .catch(error=> {
                console.error(error);
            })
    }
}
</script>

<style>

</style>