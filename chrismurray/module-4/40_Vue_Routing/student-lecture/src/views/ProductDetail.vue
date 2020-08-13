<template>
<div>
    <average-summary/>
    <star-summary rating="1" />
    <star-summary rating="2" />
    <star-summary rating="3" />
    <star-summary rating="4" />
    <star-summary rating="5" />

    <review-list/>
</div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary';
import StarSummary from '@/components/StarSummary';
import AddReview from '@/components/AddReview';
import ReviewList from '@/components/ReviewList';

export default {

    name: "product-detail",
    components: {
        AverageSummary,
        StarSummary,
        AddReview,
        ReviewList
    },

    created(){
        const activeProductId = this.$route.params.id;
        this.$store.commit('SET_ACTIVE_PRODUCT', activeProductId);
    },

    computed: {
        product() {
            return this.$store.state.products.find(
            prod => prod.id == this.$store.activeProduct
            );
         }
    
    }

}

</script>

<style>

</style>