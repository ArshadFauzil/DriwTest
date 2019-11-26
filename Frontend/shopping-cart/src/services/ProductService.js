import axios from "axios";

const baseURL = "http://localhost:9090/";

export default {
    getAllProducts: function() {
        return axios.get(baseURL + "products").then((response) => response.data);
    },
    getPriceBreakDown: function(requestBody) {
        return axios.post(baseURL + "prices", requestBody).then((response) => response.data);
    }
}