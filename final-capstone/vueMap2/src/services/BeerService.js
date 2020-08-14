import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    listBeers(breweryId) {
        return http.get(`/breweries/${breweryId}/beers`);
    },

    getById(breweryId, beerId) {
        return http.get(`/breweries/${breweryId}/beers/${beerId}`);
    },

    add(beer) {
        return http.post('/beers', beer);
    },

    delete(id) {
        return http.delete(`/beers/${id}`);
    },

    deleteBeersByBrewery(breweryId) {
        return http.delete(`/${breweryId}/beers`);
    },

    listBeerTypes() {
        return http.get('/beertypes');
    },

    update(beer) {
        return http.put('/updateBeer', beer);
    }
}