<template>
  <div id="app">
    <div id="nav">
        <router-link :to="{ name: 'home' }" tag="a" exact>[   Home   ]</router-link>
        <router-link :to="{ name: 'display' }" tag="a">[   List All Puppies   ]</router-link>
        <router-link :to="{ name: 'add' }" tag="a">[   Add Puppies   ]</router-link>
    </div>
    <router-view />
  </div>
</template>
