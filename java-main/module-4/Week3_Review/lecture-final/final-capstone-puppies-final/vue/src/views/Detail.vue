<template>

    <div id='main'>
    This is the puppy you selected. <br>

    Name: {{puppy.name}} <br>
    Gender: {{puppy.gender}}<br>

    Weight:
    <input type='text' v-model='puppy.weight'/> <br>
    Paper Trained?:  
    <select id='dog-paper-trained' v-model='puppy.paperTrained'>
        <option value='true' selected>True</option>    
        <option value='false'>False</option>     
    </select> <br><br>

    <button id='update-btn' v-on:click='updatePuppy'>Update Data?</button>
    </div>

</template>


<script>

import puppyService from "../services/PuppyService";

export default {
    props: {
        pupId: Number
    },
    data() {
        return {
            puppy : {}
        }
    },
    created() {
        console.log (this.$route.params.id);
            puppyService.get(this.$route.params.id)
            .then((dogData) => {
                this.puppy = dogData.data; 
            });
        
    }, 
    methods: 
    {
        updatePuppy(){
            const newPup = {
                pupId: this.$route.params.id,
                name: this.puppy.name,
                weight: this.puppy.weight,
                gender: this.puppy.gender,
                paperTrained: this.puppy.paperTrained
            }
            puppyService.update(newPup)
            .then (response => {
                if (response.status === 200) {
                    alert('puppy updated!');
                    this.$router.push('/display');
            }
            })
            .catch(
                (err) => {console.error(err + ' problem updating doggo!'); }
            );
        

        }
    } 
}
</script>