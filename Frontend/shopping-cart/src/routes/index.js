import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/components/Home';
import ShoppingCart from '@/components/ShoppingCart';
 
Vue.use(Router);
 
export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/shoppingcart',
      name: 'ShoppingCart',
      component: ShoppingCart
    }
  ]
});