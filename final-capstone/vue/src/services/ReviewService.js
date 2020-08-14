import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    list(targetId) {
        return http.get(`/breweries/reviews/${targetId}`);
    },

    add(review) {
        return http.post('/reviews', review);
    },

    delete(id) {
        return http.delete(`/deleteReview/${id}`);
    },

    deleteAll(userId) {
        return http.delete(`/reviews/${userId}/delete`);
    }
}
