import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

  getAll() {
    return http.get('/breweries');
  },

  getAllWithGlutenFree() {
    return http.get('/breweries/glutenfree');
  },

  getById(id) {
    return http.get(`/breweries/${id}`);
  },

  add(brewery) {
    return http.post('/breweries', brewery);
  },

  delete(id) {
      return http.delete(`/breweries/${id}`);
  },

  update(brewery) {
    return http.put('/updateBrewery', brewery);
  }

}
