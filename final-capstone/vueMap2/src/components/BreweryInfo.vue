<template>
  <div id='brewery-information'>
    <div class='brewery-card'>
      <img :src="brewery.image" alt="">
    <h1 class='brewery-name'> {{brewery.name}}</h1>
    <p class='brewery-desc'>{{brewery.history}}</p>
    <p class='address'>{{brewery.address1}} <br> {{brewery.city}}, {{brewery.state}} {{brewery.zipCode}}</p>
    <p class='phone'>Phone: {{brewery.phoneNumber}}</p>
    <a :href="brewery.website" target="_blank" :alt="brewery.website" class='website'>Website</a>
    <router-link class='link' :to="{ name: 'beer-list', params: {breweryId: breweryId} }" >Beer Menu</router-link>
    <a id='add-favorite' href="#" v-if="!favoriteIds.includes(brewery.id)" v-on:click.prevent="addToFavorites">Add to Favorites</a>
    <p id='is-favorited' v-else>
      <img class='heart' src="../assets/hearticon.png" alt="">
      Favorited</p>
    <div class="actions" v-if="$store.state.user.authorities[0].name == 'ROLE_BREWER'">
      <button class="edit-btn" v-if="showForm === false" v-on:click.prevent="showForm = true">Edit</button>
      <button class="delete-btn" v-if="showForm === false" v-on:click="remove">Delete</button>
    </div>
    </div>
    <div class=form-container v-if="showForm===true">
      <form id="edit-form" v-on:submit.prevent="edit" v-if="showForm === true">
        <div class="form-element">
        <input :placeholder="brewery.name" class='name-input' type="text" v-model="brewery.name"/>
      </div>
      <div class="form-element">
        <input :placeholder="brewery.address1" class='street-input' type="text" v-model="brewery.address1"/>
      </div>
      <div class="form-element city-state-zip">
        <input type="text" class="city" :placeholder="brewery.city" v-model="brewery.city"/>
        <input type="text" class="state" :placeholder="brewery.state" v-model="brewery.state"/>
        <input type="text" class='zip-input' :placeholder="brewery.zipCode" v-model="brewery.zipCode"/>
      </div>
       <div class="form-element">
        <input class='phone-input' :placeholder="brewery.phoneNumber" type="text" v-model="brewery.phoneNumber"/>
      </div>
      <div class='form-element'>
        <input type="text" :placeholder="brewery.website" class="website-input" v-model="brewery.website"/>
      </div>
      <div class='form-element'>
        <textarea :placeholder="brewery.history" v-model="brewery.history"></textarea>
      </div>
      <div class="buttons-div">
        <input type="submit" value="Update Brewery" class='form-btns'>
        <input type="button" value="Cancel" class='form-btns' v-on:click.prevent="resetForm">
      </div>
      </form>
    </div>
  </div>
</template>

<script>
import breweryService from '../services/BreweryService';
import beerService from '../services/BeerService';
import favoriteService from '../services/FavoriteService';

export default {
    name: 'brewery-info',
    props: {
      'breweryId': Number,
    },

    data() {
      return {
        favorites: [],
        favorite: {
          
        },
        brewery: {},
        showForm: false,
      }
    },

    created() {

      breweryService.getById(this.breweryId)
        .then(response=> {
          this.brewery = response.data;
        });

      favoriteService.list(this.$store.state.user.id)
        .then(response=> {
          if (response.status === 200) {
            this.favorites = response.data;
          }
        });

      this.favorite.userId = this.$store.state.user.id;
      this.favorite.breweryId = this.breweryId;
      
    },

    computed: {
      favoriteIds: function() {
       return this.favorites.map(favorite=> {
          return favorite.breweryId;
        })
      }
    },

    methods: {
      addToFavorites() {
        favoriteService.add(this.favorite)
          .then(response=> {
            if (response.status === 201) {
              alert("Added to favorites!");
              window.location.reload();
            }
          })
          .catch(error=> {
            console.error(error);
            alert("Could not add brewery to favorites.");
          })
      },

      edit() {
        breweryService.update(this.brewery)
          .then(response=> {
            if (response.status === 200) {
              this.$router.push('/' + this.breweryId);
              this.resetForm();
            }
          })
      },

      remove() {
        beerService.deleteBeersByBrewery(this.breweryId)
          .then(response=> {
            if (response.status === 200) {
                favoriteService.deleteAll(this.breweryId)
                  .then(response=> {
                    if (response.status === 200) {
                      breweryService.delete(this.breweryId)
                      .then(response=> {
                        if (response.status === 200) {
                          this.$router.push('/');
                        }
                      })
                      .catch(e=> {
                        console.error(e.statusText);
                      })
                    }
                  })
                  .catch(error=> {
                    console.error(error);
                  })
            }
          })
          .catch(error=> {
            console.error(error);
            alert("Could not delete brewery");
          })

      },

      resetForm() {
        this.showForm = false;
      }
    },
}
</script>

<style>
  #brewery-information {
    width: 80%;
    padding: 20px;
    margin: 0 auto;
    display: flex;
    justify-content: space-around;
  }

  .brewery-card {
    width: 50%;
    background-color: white;
    padding: 15px;
    border-radius: 3px;
    box-shadow: 1px 2px 5px black;
    max-height: 75vh;
  }

  .brewery-name {
    text-align: center;
  }

  .form-container {
    width: 40%;
    background-color: white;
    padding: 15px;
    border-radius: 10px;
    box-shadow: 1px 2px 5px gray;
    max-height: 75vh;
  }

  .actions {
    margin-top: 15px;
  }

  .edit-btn {
    margin-right: 10px;
  }

  .edit-btn, .delete-btn {
    height: 25px;
  }

  .form-btns {
    height: 25px;
    border-radius: 5px;
  }

  #edit-form input {
    width: 71%;
  }

  .city, .state, .zip-input {
    width: 32%;
  }
  .form-element input {
    border-radius: 5px;
  }

  .brewery-card .link {
    margin-top: 10px;
    font-weight: bold;
    display: block;
  }

  #is-favorited {
    text-align: right;
  }

  #add-favorite {
    text-decoration: none;
    color: #25271c;
  }

  #add-favorite:hover {
    text-decoration: underline;
  }

  #is-favorited .heart {
    width: 34px;
    height: 18px;
    margin-right: -6px;
  }

  @media (max-width: 800px) {
    .brewery-card {
      width: 80%;
    }
  }

</style>