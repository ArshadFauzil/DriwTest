package app.controller;
import app.controller.responsemodel.PriceModel;
import app.model.Product;
import app.service.ProductService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import app.dao.ProductDao;
import java.util.List;

@RestController
@RequestMapping("/")
public class PriceController {

    @Resource
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

   /* @GetMapping("/prices")
    public PriceModel getPriceBreakDown() {

    }*/

    @GetMapping("/")
    public String index() {
        return "This is to test the API is up";
    }

}