import axios from "axios";

const apiUrl = "http://localhost:9090/";

export default {
    getAllProducts: function() {
        return axios.get(apiUrl+"products").then((response) => response.data);
    },
    getPriceBreakDown: function(requestBody) {
        return axios.post(apiUrl+"prices", requestBody).then((response) => response.data);
    }
}