<template>
  <nav class='header-nav'>
    <div class='links'>
        <router-link class='header-link' v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>
        <router-link class='header-link'  v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>  
    </div>
    <div class='header-logo'>
        <h3 class="header-title">GFBeer</h3>
        <img class="header-img" src="../assets/imageedit_3_7387992514.png" alt="">
    </div>
  </nav>
</template>

<script>
export default {
    name: 'main-header',
}
</script>

<style>
    .header-nav {
        display: flex;
        justify-content:space-between;
        margin: 0 auto;
        margin-top: 10px;
    }

    .header-logo {
        display: flex;
    }

    .header-title {
        font-size: 24px;
        text-shadow: 2px 2px 2px black;
        color: #C69A24;
    }

    .header-img {
        width: 60px;
        height: 60px;
        margin-top: 5px;
    }

    .links {
        display: flex;
        align-items: center;
        width: 10%;
        justify-content: space-between;
        padding: 10px;
    }

    .header-link {
        text-decoration: none;
        margin-right: 15px;
        text-shadow: 2px 2px 2px black;
        color: #C69A24;
        font-weight: bold;
        font-size: 1.1em;
    }

    .header-link:hover {
        text-decoration: underline;
    }
</style>