<template>
  <div id="login" class="text-center">
    <div class=logo-div>
      <img class='logo' src="../assets/imageedit_3_7387992514.png" alt="">
      <h1 class="title">GFBeer</h1>
    </div>
    <form class="form-signin" @submit.prevent="login">
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and/or password</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please log in.</div>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }" id="link">Need an account?</router-link>
      <button type="submit">Log In</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>

  #login {
    display: flex;
    flex-direction: column;
    width: 100%;
    align-items: center;
  }

  .logo-div {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 30%;
  }

  .logo-div .title {
    margin-top: -20px;
    font-size: 5em;
    text-align: center;
    color: #C69A24;
    font-family: Arial, Helvetica, sans-serif;
  }

  .form-signin {
    width: 70%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin-top: -20px;
  }

  .form-signin input {
    border-radius: 5px;
    width: 50%;
    height: 35px;
    margin-bottom: 15px;
    padding-left: 5px;
  }

  #link {
   color: white;
   margin-bottom: 10px;
   text-decoration: none;
   
  }

  #link:hover {
    text-decoration: underline;
  }

  button {
    height: 35px;
    border-radius: 5px;
    width: 25%;
    margin-bottom: 40px;
    background-color: #25271C;
    color: white;
    font-size: 16px;
  }

  button:hover {
    background-color: #3b3d33;
    cursor: pointer;
  }

  .alert {
    color: white;
    margin-bottom: 10px;
  }

</style>
