import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Display from '../views/Display.vue'
import Add from '../views/Add.vue'
import Detail from '../views/Detail.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/home",
      name: "home",
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/display",
      name: "display",
      component: Display,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/display/:id",
      name: "display-detail",
      component: Detail,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/add",
      name: "add",
      component: Add,
      meta: {
        requiresAuth: false
      }
    },
  ]
})

// router.beforeEach((to, from, next) => {
//   // Determine if the route requires Authentication
//   const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

//   // If it does and they are not logged in, send the user to "/login"
//   if (requiresAuth && store.state.token === '') {
//     next("/login");
//   } else {
//     // Else let them go to their next destination
//     next();
//   }
// });

export default router;
