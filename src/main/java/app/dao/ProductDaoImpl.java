package app.dao;
import app.dao.ProductDao;
import app.model.Product;
import app.mapper.ProductRowMapper;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Repository
public class ProductDaoImpl implements ProductDao {
    NamedParameterJdbcTemplate template;
    public ProductDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Product> findAll() {
        return template.query("select * from Product", new ProductRowMapper());
    }
}
