<template>
    <div class="main">
        <div class="bestseller-list">
            <!-- <h1>Bestsellers</h1> -->
            <bestseller-list/>
        </div>
        <div class="new-release-list">
            <!-- <h1>New Releases</h1> -->
            <new-releases-list/>
        </div>
    </div>
   
</template>

<script>
import BestsellerList from "@/components/BestsellerList";
import NewReleasesList from "@/components/NewReleasesList";

export default {
    components: {
        BestsellerList,
        NewReleasesList
    }
};
</script>

<style>

</style>