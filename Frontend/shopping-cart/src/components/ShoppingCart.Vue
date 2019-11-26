<template>
  <div class="hello">
    <h1>Shop here!</h1>
    <div class="align-center">
      <table>
        <thead>
          <tr>
            <th v-for="(key, i) in columns" :key="i">{{ titleDictionary[key] }}</th>
            <th>Quantity</th>
            <th>Purchase in Cartons</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(entry, j) in products" :key="j">
            <td v-for="(key, h) in columns" :key="h">{{entry[key]}}</td>
            <td>
              <vue-numeric-input :min="0" v-model="entry.quantity"></vue-numeric-input>
            </td>
            <td>
              <b-form-checkbox
                v-model="entry.inCartons"
                value="true"
                unchecked-value="false"
                switch
              ></b-form-checkbox>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button type="button" class="btn btn-success" v-on:click="priceChecker()">Check Price</button>
    <div v-if="response">
      <h3>Your Cart</h3>
      <div class="card-wrapper d-flex flex-wrap justify-content-center">
        <div
          v-for="(prod, j) in response.selectedProduct"
          :key="j"
          class="card align-center"
          style="width: 18rem;"
        >
          <div class="card-header">{{prod.name}}</div>
          <div class="card-body">
            <h6 class="card-text">Quantity {{prod.quantity}}</h6>
            <p class="card-text">Price per unit {{prod.pricePerUnit}}</p>
            <p class="card-text">Cartons {{prod.cartons}}</p>
            <p class="card-text">Units {{prod.units}}</p>
            <p class="card-text">Total product Price {{prod.totalProductPrice}}</p>
          </div>
        </div>
      </div>
      <h4>Total Price {{response.totalPrice}}</h4>
    </div>
    <script type="text/x-template" id="grid-template"></script>
  </div>
</template>

<script>
import Vue from "vue";
import VueNumericInput from "vue-numeric-input";
import ProductService from "../services/ProductService.js";

Vue.use(VueNumericInput);

export default {
  name: "ShoppingCart",
  data: function() {
    return {
      columns: ["name", "price", "cartonSize"],
      products: [],
      selectedProducts: [],
      titleDictionary: {
        name: "Name",
        price: "Price per Unit",
        cartonSize: "Units per Carton"
      },
      value: 0,
      response: null
    };
  },
  mounted() {
    var currentObj = this;
    ProductService.getAllProducts().then(function(response) {
      currentObj.products = response;
      if (currentObj.products.length > 0) {
        currentObj.products.forEach(element => {
          element.inCartons = true;
        });
      }
    });
  },
  methods: {
    priceChecker: function() {
      this.selectedProducts = [];
      this.products.forEach(element => {
        if (element.hasOwnProperty("quantity") && element.quantity > 0) {
          this.selectedProducts.push({
            pid: element.pid,
            quantity: element.quantity,
            inCartons: element.inCartons
          });
        }
      });
      if (this.selectedProducts.length > 0) {
        ProductService.getPriceBreakDown(this.selectedProducts).then(response => this.response = response);
      } else {
        this.response = null;
      }
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.card {
  vertical-align: middle;
}

h3 {
  margin: 40px 0 0;
}
.btn-success {
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
  color: rgba(255, 255, 255, 0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

td {
  background-color: #f9f9f9;
}

th,
td {
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
.align-center {
  display: flex;
  justify-content: center;
}

.card-wrapper {
  margin: 0 -1em;
}

.card-wrapper .card {
  margin: 1em 0.5em;
  border-color: #42b983;
}

.card-wrapper .card .card-header{
  background: #42b983;
  color: #fff;
  font-weight: 600;
}

</style>
