<template>
  <div class="hello">
    <h1>Welcome to the Shopping Cart! Browse for your products here</h1>
  <div class="align-center">
     <table>
        <thead>
          <tr>
            <th v-for="(key, i) in columns" :key="i">
              {{ titleDictionary[key] }}
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(entry, j) in products" :key="j">
            <td v-for="(key, h) in columns" :key="h">
              {{entry[key]}}
            </td>
          </tr>
        </tbody>
    </table>
  </div>
    <script type="text/x-template" id="grid-template"></script>
  </div>
</template>

<script>
import axios from 'axios';
import Vue from 'vue'
import VueNumericInput from 'vue-numeric-input';
 
Vue.use(VueNumericInput)

export default {
  name: 'Home',
  data: function () {
    return {
      columns: ['name', 'price', 'cartonSize'],
      products: null,
      titleDictionary: {"name": "Name", "price": "Price per Unit", "cartonSize": "Units per Carton"},
      value: 0
    }
  },
  mounted () {
    axios
      .get('http://localhost:9090/products')
      .then(response => (this.products = response.data))
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
body {
  font-family: Helvetica Neue, Arial, sans-serif;
  font-size: 14px;
  color: #444;
}

table {
  border: 2px solid #42b983;
  border-radius: 3px;
  background-color: #fff;
}

th {
  background-color: #42b983;
  color: rgba(255,255,255,0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

td {
  background-color: #f9f9f9;
}

th, td {
  min-width: 120px;
  padding: 10px 20px;
}

th.active {
  color: #fff;
}

th.active .arrow {
  opacity: 1;
}

.arrow {
  display: inline-block;
  vertical-align: middle;
  width: 0;
  height: 0;
  margin-left: 5px;
  opacity: 0.66;
}

.arrow.asc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-bottom: 4px solid #fff;
}

.arrow.dsc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-top: 4px solid #fff;
}
.align-center{
  display: flex;
  justify-content: center;
}
</style>
