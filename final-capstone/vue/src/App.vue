<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>

export default {
  name: 'app',
  components: {
  },
}
</script>
<style>
  #app {
    font-family: Arial, Helvetica, sans-serif;
    margin: 0 auto;
    min-height: 100vh;
    background-image: url('https://www.pixelstalk.net/wp-content/uploads/2016/07/Beer-Images.jpg');
    background-position: center;
    background-position-y: 1px;
    background-size: cover;

  }
</style>
