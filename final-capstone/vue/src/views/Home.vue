<template>
  <div class="home">
    <main-header></main-header>
    <div id="container">
    <div class="user-actions">
      <div class='user-details'>
        <img class='user-icon' src="https://img.icons8.com/material-rounded/24/000000/user.png"/>
        <p class='username'>{{$store.state.user.username}} | {{$store.state.user.authorities[0].name == 'ROLE_BREWER' ? 'Brewer' : 'User'}}</p>
      </div>
      <div class="favorites" v-if="$store.state.user.authorities[0].name == 'ROLE_USER'">
        <img class='heart' src="../assets/hearticon.png" alt="">
        <router-link class='link' :to="{name: 'favorites-list', params: {userId: $store.state.user.id}}">
        Your Favorites
        </router-link>
      </div>
      <div>
      </div>
      <div class='delete'>
        <img class='deleteimg' src="../assets/deleteimg.png" alt="">
        <a class='link delete-link' href="#" v-on:click.prevent="deleteAccount">Delete Account</a>
      </div>
      <div v-if="$store.state.user.authorities[0].name == 'ROLE_BREWER'" class='add-brewery'>
        <button class='add-brewery-btn' v-if="showForm === false" v-on:click.prevent="showForm = true">Add Brewery</button>
        <form id="brewery-form" v-on:submit.prevent="addBrewery" v-if="showForm === true">
          <div class="form-element">
            <input placeholder='Name' class='name-input' type="text" v-model="newBrewery.name"/>
        </div>
        <div class="form-element">
            <input placeholder="Address" class='street-input' type="text" v-model="newBrewery.address1"/>
        </div>
        <div class="form-element city-state-zip">
            <input type="text" class="city" placeholder="City" v-model="newBrewery.city"/>
            <input type="text" class="state" placeholder="State" v-model="newBrewery.state"/>
            <input type="text" class='zip-input' placeholder="Zipcode" v-model="newBrewery.zipCode"/>
        </div>
        <div class="form-element">
            <input class='phone-input' placeholder="555-555-5555" type="text" v-model="newBrewery.phoneNumber"/>
        </div>
        <div class='form-element'>
            <input type="text" placeholder="Website URL" class="website-input" v-model="newBrewery.website"/>
        </div>
        <div class='form-element'>
            <textarea placeholder = 'Description' v-model="newBrewery.history"></textarea>
        </div>
        <div class="buttons-div">
            <input type="submit" value="Save Brewery" class='form-btns'>
            <input type="button" value="Cancel" class='form-btns' v-on:click.prevent="resetForm">
        </div>
    </form>
    </div>
    </div>

    <div class="search">
      <input type="text" class="searchbar" placeholder='Find breweries by name, or search by city or zipcode' v-model="searchData"/>
      <span class='key'><img class='gfimage' src="../assets/gfimg.png" alt=""> This brewery offers Gluten Free beers</span>
      <div class='border-div'></div>
      <a href="#" class='link view-link' v-if="showMap===false && searchData != ''" v-on:click="showMap = true">Map View</a>
      <a href="#" class='link view-link' v-if="showMap===true && searchData != ''" v-on:click="showMap = false">List View</a>
      <div id="map-view" v-if="showMap===true && searchData != ''">
        <google-map />
      </div>
      <div class="results" v-if="showMap===false">
        <div class="brewery-result" v-show="searchData != ''" v-for="brewery in paginatedData" v-bind:key="brewery.id">
          <router-link class="link" :to="{name: 'brewery-detail', params: { id: brewery.id }}">
            {{ brewery.name }}
          </router-link>
          <span v-if="gfBreweryIds.includes(brewery.id)">
            <img class='gfimage' src="../assets/gfimg.png" alt="">
          </span>
        </div>
        <div class="page-buttons" v-show="searchData != '' && pageCount > 1">
          <button v-on:click="prevPage" v-show="pageNumber != 0">Previous</button>
          <button v-on:click="nextPage" v-show="pageNumber < pageCount - 1">Next</button>
          <span id='page-count-breweries'>{{pageNumber + 1}} / {{pageCount}}</span>
        </div>
      </div>
    </div>
    </div>

  </div>
</template>

<script>
import MainHeader from '../components/MainHeader';
import breweryService from '../services/BreweryService';
import authenticationService from '../services/AuthService';
import favoriteService from '../services/FavoriteService';
import reviewService from '../services/ReviewService';
import GoogleMap from "../components/GoogleMap";
export default {
  name: "home",
  components: {
    MainHeader,
    GoogleMap
  },

  props: {
    size: {
      type: Number,
      required: false,
      default: 10
    }
  },

  data() {
    return {
      showMap: false,
      pageNumber: 0,
      breweries: [],
      breweriesWithGF: [],
      searchData: '',
      newBrewery: {
        name: '',
        address1: '',
        city: '',
        state: '',
        zipCode: '',
        country: 'USA',
        longitude: 0,
        latitude: 0,
        phoneNumber: '',
        website: '',
        history: '',
        image: '',
        active: true,
      },
      showForm: false,
    }
  },

  created() {
    this.getBreweries();

    breweryService.getAllWithGlutenFree()
    .then(response=> {
      if (response.status === 200) {
        this.breweriesWithGF = response.data;
      }
    })
    .catch(error=> {
      console.error(error);
    });
  },

  computed: {
    filteredBreweries: function() {
      const searchData = this.searchData.toUpperCase();
      return this.breweries.filter(brewery=> {
        return brewery.city.toUpperCase().includes(searchData) ||
              brewery.name.toUpperCase().includes(searchData) ||
              brewery.zipCode.includes(searchData) ||
              searchData.includes(brewery.city.toUpperCase());
      });
    },

    gfBreweryIds: function() {
      return this.breweriesWithGF.map(brewery=> {
        return brewery.id;
      });
    },

    pageCount() {
      return Math.ceil(this.filteredBreweries.length / this.size);
    },

    paginatedData() {
      const start = this.pageNumber * this.size;
      const end = start + this.size;

      return this.filteredBreweries.slice(start, end);
    }
  },

  methods: {
    nextPage() {
      this.pageNumber++;
    },

    prevPage() {
      this.pageNumber--;
    },

    getBreweries() {
      breweryService.getAll()
        .then(response=> {
          this.breweries = response.data;
        })
        .catch(e=> {
          console.error(e.statusText);
        })
    },

    deleteAccount() {
      alert("Are you sure you want to delete your account?");
      if (confirm) {
        reviewService.deleteAll(this.$store.state.user.id)
        .then(response=> {
          if (response.status === 200) {
            favoriteService.deleteAllFromUser(this.$store.state.user.id)
              .then(response=> {
                if (response.status === 200) {
                  authenticationService.delete(this.$store.state.user.id)
                    .then(response=> {
                      if (response.status === 200) {
                        this.$router.push('/login');
                      }
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
          alert("Could not delete your account");
        })
      }
      
    },

    addBrewery() {
      breweryService.add(this.newBrewery)
        .then(response=> {
          if (response.status === 201) {
             this.getBreweries();
          }
        })
        .catch(e=> {
          console.error(e.statusText);
        });

      this.resetForm();
    },

    resetForm() {
      this.newBrewery = {};
      this.showForm = false;
    }
  },

};
</script>

<style>

  .home {
    min-height: 100vh;
  }

  #container {
    margin-top: 40px;
    display: flex;
    flex-direction: column;
    width: 100%;
    justify-content: center;
    align-items: center;
  }

  .username {
    display: inline;
    margin-left: 10px;
  }

  .user-details {
    padding: 15px;
    background-color: #ceb161;
    border-bottom: 1px solid #25271c;
  }

  .user-icon {
    padding-right: 5px;
    width: 20px;
    height: 20px;
    padding: 0;
    margin: 0;
    vertical-align: bottom;
    position: relative;
    top: -1px;
  }

  #brewery-form {
    margin: 0 auto;
    margin-bottom: 10px;
    display: flex;
    flex-direction: column;
    align-items: center;
    max-height: 100vh;
  }

  .form-element {
    width: 100%;
    display: flex;
    align-items: center;
    margin-bottom: 10px;
  }
  #brewery-form input {
    width: 100%;
    height: 30px;
    border-radius: 3px;
    padding-left: 10px;
  }

  .link {
    text-decoration: none;
    color: #25271c;
  }

  .view-link {
    font-size: 14px;
    padding-top: 10px;
  }

  .add-brewery {
    margin-top: 10px;
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .add-brewery-btn {
    width: 50%;
    margin-top: 20px;
  }

  .city-state-zip {
    width: 100%;
  }

  .city, .state {
    margin-right: 10px;
  }

  textarea {
    border-radius: 3px;
    height: 60px;
    width: 71%;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 14px;
    padding-left: 10px;
    padding-top: 10px;
  }

  .buttons-div {
    display: flex;
    width: 74%;
    justify-content: space-between;
    margin-left: 3px;
  }

  .form-btns {
    margin-right: 5px;
    height: 35px;
    background-color: #25271c;
    color: white;
  }

  .form-btns:hover {
    background-color: #3b3d33;
    cursor: pointer;
  }

  .search {
    background-color: white;
    border-radius: 3px;
    box-shadow: 1px 2px 5px black;
    width: 60%;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 30px;
  }

  .searchbar {
    width: 90%;
    margin-top: 20px;
    height: 35px;
    border: 1px solid #26271c;
    border-radius: 3px;
    padding-left: 10px;
  }

  #map-view {
    width: 80%;

  }
  
  .user-actions {
    background-color: white;
    width: 60%;
    border-radius: 3px;
    box-shadow: 1px 2px 5px black;
    margin-bottom: 15px;
  }

  .user-actions .link {
    display: block;
  }
  .key {
    font-size: 12px;
    margin-top: 10px;
  }

  .gfimage {
    width: 16px;
  }

  .deleteimg {
    width: 18px;
    height: 18px;
    margin-right: 10px;
  }

  .delete {
    padding-left: 15px;
    padding-top: 15px;
    padding-bottom: 15px;
    display: flex;
  }

  .delete-link {
    display: inline-block;
  }

  .border-div {
    width: 100%;
    border-top: 1px solid lightgray;
    margin-top: 15px;
  }

  .results {
    line-height: 1.5;
    width: 100%;
  }

  .brewery-result {
    padding: 10px;
  }

  .brewery-result:nth-child(odd) {
    background-color: #ceb161;
  }

  .page-buttons {
    margin-left: 10px;
  }

  #page-count-breweries {
    font-size: 12px;
    color: #25271c;
  }

  .page-buttons button {
    height: 25px;
    width: 70px;
    font-size: 12px;
    margin-right: 5px;
    margin-top: 10px;
  }

  .link:hover {
    text-decoration: underline;
  }

  .favorites {
    padding-left: 14px;
    margin-top: 20px;
    margin-bottom: 0;
    display: flex;
  }

  .heart {
    height: 20px;
    width: 36px;
    padding: 0;
    margin: 0;
    margin-left: -7px;
    vertical-align: bottom;
    position: relative;
    top: -1px;
  }

  @media (max-width: 600px) {
    #container {
      flex-direction: column;
      justify-items: center;
      align-items: center;
    }
    
    .searchbar {
      font-size: 12px;
    }

    #brewery-form{
      width: 90%;
    }
    .user-actions {
      width: 90%;
      margin-bottom: 20px;
    }

    .search {
      width: 90%;
      margin-bottom: 20px;
    }
  }

</style>
