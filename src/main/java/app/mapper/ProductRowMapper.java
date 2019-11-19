package app.mapper;
import app.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Product>{
    @Override
    public Product mapRow(ResultSet rs, int arg1) throws SQLException {
        Product prod = new Product();
        prod.setPid(rs.getInt("pid"));
        prod.setName(rs.getString("name"));
        prod.setPrice(rs.getFloat("unitprice"));
        prod.setCartonSize(rs.getInt("units_per_carton"));
        return prod;
    }
}
