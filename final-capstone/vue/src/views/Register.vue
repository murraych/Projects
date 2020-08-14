<template>
  <div id="register" class="text-center">
    <main-header></main-header>
    <div class="registration-form">
      <form class="form-register" @submit.prevent="register">
      <div class = "brewer-checkbox">
        <!--Not sure if v-bind is correct to set role to brewer-->
        
        <label for="checkbox">
          <input v-on:change="setRole($event)" id="checkbox" type="checkbox">  I'm a Brewer
        </label>
      </div>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <router-link :to="{ name: 'login' }" class="link">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
    </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';
import MainHeader from '../components/MainHeader';

export default {
  name: 'register',
  components: {
    MainHeader
  },
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },

    setRole(event) {
      if (event.target.checked) {
        this.user.role = 'brewer';
      } else {
        this.user.role = 'user';
      }
    },
  },
};
</script>

<style>
#register {
  min-height: 100vh;
}

.brewer-checkbox {
  padding-bottom: 20px;
}

#checkbox {
  width: 15px;
 text-align: center;
}

.registration-form {
  background-color: white;
  width: 40%;
  margin: 0 auto;
  padding: 30px;
  border-radius: 5px;
  box-shadow: 1px 2px 5px black;
  max-height: 90vh;  
}

.form-register {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

.form-register .logo {
    height: 400px;
  }

.form-register input {
    border-radius: 3px;
    border: 1px solid #25271c;
    width: 70%;
    height: 35px;
    margin-bottom: 15px;
    padding-left: 5px;
}

.form-register button {
  width: 40%;
}

@media (max-width: 800px) {
  .registration-form {
    width: 70%;
  }

  .form-register input {
    width: 70%;
  }

  button {
    width: 50%;
  }
} 

.link {
  text-decoration: none;
  padding-bottom: 10px;
  color: #25271C;
}

label {
  display: block;
  padding-left: 15px;
  text-indent: -15px;
}

#checkbox {
  padding-right: 5px;
  width: 15px;
  height: 15px;
  padding: 0;
  margin: 0;
  vertical-align: bottom;
  position: relative;
  top: -1px;
}


</style>
