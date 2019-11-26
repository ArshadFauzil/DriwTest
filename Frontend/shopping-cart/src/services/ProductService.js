import axios from "axios";

const baseURL = "http://localhost:9090/";
const productEndPoint = "product/";

export default {
    getAllProducts: function() {
        return axios.get(baseURL + productEndPoint + "all-products").then((response) => response.data);
    },
    getPriceBreakDown: function(requestBody) {
        return axios.post(baseURL + productEndPoint + "price-breakdown", requestBody).then((response) => response.data);
    }
}