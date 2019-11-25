<template>
  <b-navbar toggleable="md" type="dark"  >
    <b-navbar-brand :to="{ name: 'Home' }">Home</b-navbar-brand>
    <b-navbar-nav>
      <b-nav-item :to="{ name: 'ShoppingCart' }">Shopping Cart</b-nav-item>
    </b-navbar-nav>
  </b-navbar>
</template>

<script>
export default {
  name: 'Navbar'
};
</script>

<style >
.navbar {
  background: #42b983;
  margin-bottom: 1em;
}
</style>