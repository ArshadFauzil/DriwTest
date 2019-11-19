package app.dao;
import app.model.Product;
import java.util.List;

public interface ProductDao {
   List<Product> findAll();
}
