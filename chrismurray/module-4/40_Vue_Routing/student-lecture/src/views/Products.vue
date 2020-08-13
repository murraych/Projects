<template>
  <div class = "products">
      <h1>Products</h1>
      <p>All the great stuff we sell!</p>
      <products-list />
  </div>
</template>

<script>
import ProductsList from '@/components/ProductsList'

export default {
    components: {
        ProductsList
    }
}
</script>

<style>

</style>