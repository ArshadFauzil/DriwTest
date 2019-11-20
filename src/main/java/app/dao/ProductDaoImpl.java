package app.dao;
import app.model.Product;
import app.mapper.ProductRowMapper;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
public class ProductDaoImpl implements ProductDao {
    NamedParameterJdbcTemplate template;
    public ProductDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Product> findAll() {
        return template.query("SELECT * FROM Product", new ProductRowMapper());
    }

    public List<Product> findRelevantProducts(List<Integer> pids) {
        String array = listToString(pids);
        String query = "SELECT * FROM Product WHERE pid IN (" + array +") ";
        return template.query(query, new ProductRowMapper());
    }

    private String listToString(List<Integer> list)
    {
        Object[] array = list.toArray();
        StringBuilder buffer = new StringBuilder();
        buffer.append(array[0]);
        for (int i = 1; i < array.length; i++)
        {
            buffer.append(",");
            buffer.append(array[i]);
        }
        return buffer.toString();
    }
}
