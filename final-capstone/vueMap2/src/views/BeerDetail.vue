<template>
  <div id="beer-detail">
      <main-header></main-header>
      <beer-info v-bind:breweryId="$route.params.breweryId" v-bind:beerId="$route.params.beerId"></beer-info>
  </div>
</template>

<script>
import MainHeader from '../components/MainHeader';
import BeerInfo from '../components/BeerInfo';

export default {
    name: 'beer-detail',
    components: {
        MainHeader,
        BeerInfo,
    }
}
</script>

<style>
    #beer-detail {
       min-height: 100vh;
    }
</style>