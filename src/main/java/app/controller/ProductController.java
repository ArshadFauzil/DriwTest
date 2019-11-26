package app.controller;
import app.controller.requestmodel.SelectedProduct;
import app.controller.responsemodel.PriceModel;
import app.model.Product;
import app.service.ProductService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductService productService;

    @GetMapping("/all-products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @CrossOrigin
    @RequestMapping("/price-breakdown")
    @ResponseBody
    public PriceModel getPriceBreakDown(@RequestBody List<SelectedProduct> selectedProductList) {
        return productService.getPriceBreakDown(selectedProductList);
    }

    @GetMapping("/")
    public String index() {
        return "This is to test the API is up";
    }

}