import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080/api"
});

export default {
    list() {
        return http.get('/allPuppies');
    },

  get(id) {
    return http.get(`/puppy/${id}`);
  },

  create(puppy) {
    return http.post('/newPuppy', puppy);
  },

  update(puppy) {
    return http.put('/editPuppy', puppy);
  },

  delete(id) {
    return http.delete(`/removePuppy/${id}`);
  }
}
