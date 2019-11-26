import axios from "axios";

export default {
    getAllProducts: function() {
        return axios.get("http://localhost:9090/products").then((response) => response.data);
    },
    getPriceBreakDown: function(requestBody) {
        return axios.post("http://localhost:9090/prices", requestBody).then((response) => response.data);
    }
}