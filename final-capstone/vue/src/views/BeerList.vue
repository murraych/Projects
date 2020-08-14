<template>
  <div id='beers-list'>
      <main-header></main-header>
      <div class='beer-container'>
          <div id="beer-menu">
           <h1>Beer Menu</h1>
    <hr>
        <p v-if="beers.length == 0">The beer menu for this brewery is not available.</p>
      <div class="beer-menu-item" v-for="beer in beers" v-bind:key="beer.id">
          <router-link class='link' :to="{name: 'beer-detail', params: {breweryId: breweryId, beerId: beer.id}}">
              {{beer.name}}
          </router-link>
          <span v-if="glutenFreeIds.includes(beer.id)">
            <img class='gfimage' src="../assets/gfimg.png" alt="">
          </span>
      </div>
      <div id="new-beer" v-if="$store.state.user.authorities[0].name == 'ROLE_BREWER'">
          <new-beer-form v-bind:breweryId="$route.params.breweryId"></new-beer-form>
      </div>
      </div>
      </div>
  </div>
</template>

<script>
    import MainHeader from '../components/MainHeader';
    import NewBeerForm from '../components/NewBeerForm';
    import beerService from '../services/BeerService';

    export default {
        name: 'beer-list',
        components: {
            MainHeader,
            NewBeerForm,
        },

        data() {
            return {
                beers: [],
                glutenFreeBeers: [],
                breweryId: parseInt(this.$route.params.breweryId),
            }
        },

        computed: {
            glutenFreeIds: function() {
                return this.glutenFreeBeers.map(beer=> {
                    return beer.id;
                })
            }
        },

        created() {
           beerService.listBeers(parseInt(this.$route.params.breweryId))
            .then(response=> {
                if (response.status === 200) {
                    this.beers = response.data;
                }
            })
            .catch(error=> {
                console.error(error);
                alert("Could not retrieve beers for this brewery.");
                this.$router.push('/' + this.$route.params.breweryId);
            });

            beerService.getGlutenFreeBeers()
            .then(response=> {
                if (response.status === 200) {
                    this.glutenFreeBeers = response.data;
                }
            })
            .catch(error=> {
                console.error(error);
            })
        },
    }
</script>

<style>
    #beers-list {
        background-image: url('https://www.pixelstalk.net/wp-content/uploads/2016/07/Beer-Images.jpg');
        background-size: cover;
        background-position: center;
        background-position-y: 1px;
        min-height: 100vh;
        
    }

    #beer-menu {
        background-color: white;
        width: 50%;
      
        border-radius: 3px;
        box-shadow: 1px 2px 5px black;

    }

    #beer-menu h1 {
        text-align: center;
        padding-top: 15px;
    }

    .beer-menu-item {
        padding: 10px;
    }

    .beer-menu-item:nth-child(even) {
        background-color: #ceb161;
    }

    #new-beer {
        margin-top: 10px;
        padding-left: 10px;
    }

    .beer-container {
        display: flex;
        justify-content: center;
        align-items: center;
        padding-bottom: 30px;
    }

    @media(max-width: 800px) {
        #beer-menu {
            width: 80%;
        }
    }
</style>