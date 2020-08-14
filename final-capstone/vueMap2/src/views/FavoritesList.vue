<template>
  <div id='favorites'>
      <main-header></main-header>
      <div class='favorites-list'>
        <h1>Favorites</h1>
        <p v-if="favorites.length == 0">You haven't added any favorite breweries yet.</p>
        <div class="favorite" v-for="favorite in favorites" v-bind:key="favorite.id">
          <router-link class='link' :to="{name: 'brewery-detail', params: {id: favorite.breweryId}}">{{favorite.breweryName}}</router-link>
          <span><a href="#" v-on:click="removeFavorite(favorite.breweryId)">Remove</a></span>
        </div>
      </div>
  </div>
</template>

<script>
import MainHeader from '../components/MainHeader';
import favoriteService from '../services/FavoriteService';

export default {
    name: 'favorites-list',
    components: {
        MainHeader
    },
    
    data() {
        return {
            favorites: [],
        }
    },

    methods: {
        removeFavorite(breweryId) {
            favoriteService.delete(this.$store.state.user.id, breweryId)
                .then(response=> {
                    if (response.status === 200) {
                        window.location.reload();
                    }
                })
                .catch(error=> {
                    console.error(error);
                    alert("Could not delete brewery from favorites.");
                })
        }
    },

    created() {
        favoriteService.list(this.$store.state.user.id)
            .then(response=> {
                if (response.status === 200) {
                    this.favorites = response.data;
                }
            })
            .catch(error=> {
                console.error(error);
                alert('Could not retrieve favorite breweries');
                this.$router.push('/');
            });

    }
}
</script>

<style>
    #favorites {
        min-height: 100vh;
    }

    .favorites-list {
        background-color: white;
        border-radius: 3px;
        width: 50%;
        margin: 0 auto;
        box-shadow: 1px 2px 5px black;
    }

    .favorites-list h1 {
        text-align: center;
        padding-top: 15px;
    }

    .favorites-list p {
        text-align: center;
        padding-bottom: 20px;
    }

    .favorites-list .favorite {
        line-height: 1.5;
        padding: 10px;
    }

    .favorite:nth-child(even) {
        background-color: #ceb161;
    }

    .favorite .link {
        margin-right: 10px;
    }

    .favorite span {
        font-size: 12px;
        color: #25271c;
    }

</style>