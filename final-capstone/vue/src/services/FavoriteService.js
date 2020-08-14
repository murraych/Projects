import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    list(userId) {
        return http.get(`/favorite/${userId}`);
    },

    add(favorite) {
        return http.post('/favorite', favorite);
    },

    delete(userId, breweryId) {
        return http.delete(`favorite/${userId}/${breweryId}`);
    },

    deleteAll(breweryId) {
        return http.delete(`/favorite/${breweryId}`);
    },

    deleteAllFromUser(userId) {
        return http.delete(`/${userId}/favorites/delete`);
    }
}