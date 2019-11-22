package app.controller;
import app.controller.requestmodel.SelectedProduct;
import app.controller.responsemodel.PriceModel;
import app.controller.responsemodel.SelectedProductDetails;
import app.model.Product;
import app.service.ProductService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class PriceController {

    private final int MINIMUM_DISCOUNTED_CARTON_COUNT = 3;
    private final double DISCOUNTED_PRICE = 0.9;
    private final double UNIT_PRICE_INCREMENT = 1.3;
    @Resource
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @RequestMapping("/prices")
    @ResponseBody
    public PriceModel getPriceBreakDown(@RequestBody List<SelectedProduct> selectedProductList) {
        List<Integer> pids = new ArrayList<Integer>();
        for (SelectedProduct selectedProduct: selectedProductList) {
            pids.add(selectedProduct.pid);
        }
        List<Product> selectedProds = productService.findRelevantProducts(pids);
        List<SelectedProductDetails> productDetails = new ArrayList<SelectedProductDetails>();
        float totalPrice = 0;
        for (final Product product: selectedProds) {
            SelectedProductDetails prod = new SelectedProductDetails();
            prod.name = product.getName();
            prod.pricePerUnit = product.getPrice();
            prod.quantity = Objects.requireNonNull(selectedProductList.stream()
                    .filter(x -> x.pid == product.getPid())
                    .findAny()
                    .orElse(null)).quantity;
            prod.cartons = prod.quantity / product.getcartonSize();
            prod.units = prod.quantity % product.getcartonSize();
            productDetails.add(prod);
            totalPrice += ((prod.cartons > MINIMUM_DISCOUNTED_CARTON_COUNT ? prod.cartons * product.getcartonSize() * prod.pricePerUnit * DISCOUNTED_PRICE :
                                                                             prod.cartons * product.getcartonSize() * prod.pricePerUnit)
                        + (prod.units * prod.pricePerUnit * UNIT_PRICE_INCREMENT));
        }
        PriceModel responseModel = new PriceModel();
        responseModel.selectedProduct = productDetails;
        responseModel.totalPrice = totalPrice;
        return responseModel;
    }

    @GetMapping("/")
    public String index() {
        return "This is to test the API is up";
    }

}