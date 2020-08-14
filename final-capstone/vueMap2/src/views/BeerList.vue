<template>
  <div id='beers-list'>
      <main-header></main-header>
      <h1>Beer Menu</h1>
      <div v-for="beer in beers" v-bind:key="beer.id">
          <router-link :to="{name: 'beer-detail', params: {breweryId: breweryId, beerId: beer.id}}">
              {{beer.name}}
          </router-link>
      </div>
      <div v-if="$store.state.user.authorities[0].name == 'ROLE_BREWER'">
          <new-beer-form v-bind:breweryId="$route.params.breweryId"></new-beer-form>
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
                breweryId: parseInt(this.$route.params.breweryId),
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
</style>