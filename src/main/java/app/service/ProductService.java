package app.service;
import app.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    List<Product> findRelevantProducts(List<Integer> pids);
}
