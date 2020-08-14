<template>
  <div id='new-beer-form-container'>
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
              <input type="text" class="beer-abv" placeholder="%ABV" v-model="newBeer.abv"/>
          </div>
          <div class="form-element">
              <input list='types'>
              <datalist id='types'>
                  <option v-for="type in types" v-bind:key="type.id" :value="type.name"></option>
              </datalist>
          </div>
        <div id="checkbox-element">
            <label for="checkbox">
              <input type="checkbox" id="beer-gf" v-on:change="setGf($event)"/>
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
    #add-beer-form {
        padding-bottom: 20px;
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    #add-beer-form .form-element {
        width: 100%;
    }

   
    #add-beer-form input {
        width: 100%;
        height: 30px;
        margin-right: 10px;
    }

     #checkbox-element input {
        width: 15px;
        vertical-align: bottom;
        margin-bottom: -5px;
    }

    #checkbox-element {
        width: 30%;
        margin-left: 8%;
        margin-bottom: 10px;
    }
    

    #add-beer-form textarea {
        width: 100%;
        margin-right: 10px;
    }

    #add-beer-form .buttons-div {
        display: flex;
        justify-content: space-around;
        width: 30%;
       
    }

    .buttons-div .form-btns {
        width: 90px;
    }


    #new-beer-form-container button {
        margin-top: 30px;
        margin-bottom: 10px;
    }

    @media(max-width: 800px) {
        
         #add-beer-form .buttons-div {
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            width: 30%;
        }

        #checkbox-element {
            width: 50%;
            margin-left: 16%;
        }

        .buttons-div .form-btns {
            margin-bottom: 5px;
        }
    }
</style>