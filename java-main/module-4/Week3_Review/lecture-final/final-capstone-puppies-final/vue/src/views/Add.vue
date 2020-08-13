<template>
  <div id='main'>
     <div id='input-section'> 
        <form v-on:submit.prevent="savePuppy">
            Name: <input id='dog-name' v-model='puppy.name' /> <br><br>
            Weight:  <input id='dog-weight' v-model='puppy.weight' /> <br><br>
            Gender:  <select id='dog-gender' v-model='puppy.gender'>   
                <option value='Male' selected>Male</option>    
                <option value='Female'>Female</option>              
            </select> <br> <br>
            Paper Trained? <select id='dog-paper-trained' v-model='puppy.paperTrained'>
                <option value='true' selected>True</option>    
                <option value='false'>False</option>     
            </select><br><br>    
            <button id='dog-add-btn'>Add Doggo!</button>
        </form>
      </div>
  </div>
</template>

<script>

import puppyService from "@/services/PuppyService";

export default {

    data() {
        return { 
            puppy: {
                name: '',  
                weight: '',
                gender: '',
                paperTrained: ''   
            }
        };
    },
    methods: {
        savePuppy() {
            console.log ("saving puppy")
            const newPuppy = {
                name: this.puppy.name,
                weight: this.puppy.weight,
                gender: this.puppy.gender,
                paperTrained: this.puppy.paperTrained
            }
            puppyService.create(newPuppy)
            .then (response => {
                if (response.status === 201) {
                    alert('puppy added!');
                    this.$router.push('/display');
            }
            })
            .catch(
                (err) => {console.error(err + ' problem adding doggo!'); }
            )
        }

    }
}
</script>

<style>
    #input-section {
        background-color: cornflowerblue;
        margin: 20px;
        padding: 20px;
        width: 20%;
    }
</style>