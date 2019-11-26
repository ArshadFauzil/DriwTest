package app.service;
import app.controller.requestmodel.SelectedProduct;
import app.controller.responsemodel.PriceModel;
import app.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    PriceModel getPriceBreakDown(List<SelectedProduct> selectedProductList);
}
