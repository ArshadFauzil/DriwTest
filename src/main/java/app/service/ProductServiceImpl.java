package app.service;
import app.dao.ProductDao;
import app.model.Product;
import java.util.List;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class ProductServiceImpl implements ProductService{
    @Resource
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
