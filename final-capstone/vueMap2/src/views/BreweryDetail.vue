<template>
  <div id="brewery-details">
      <main-header></main-header>
      <brewery-info v-bind:breweryId="$route.params.id"></brewery-info>
  </div>
</template>

<script>
import MainHeader from '../components/MainHeader';
import BreweryInfo from '../components/BreweryInfo';

export default {
    name: 'brewery-detail',
    components: {
        BreweryInfo,
        MainHeader,
    },
}
</script>

<style>
    #brewery-details {
        background-image: url('https://www.pixelstalk.net/wp-content/uploads/2016/07/Beer-Images.jpg');
        background-position: center;
        background-position-y: 1px;
        background-size: cover;
        min-height: 100vh;
    }
</style>