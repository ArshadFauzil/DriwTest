import app.controller.requestmodel.SelectedProduct;
import app.controller.responsemodel.PriceModel;
import app.controller.responsemodel.SelectedProductDetails;
import app.dao.ProductDao;
import app.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductControllerTest {

    final String baseUrl = "http://localhost:" + 9090 + "/product";
    RestTemplate restTemplate = new RestTemplate();
    @InjectMocks
    ProductService productService;

    @Mock
    ProductDao productDao;

    @LocalServerPort
    int randomServerPort;

    /*@Test
    public void testGetPriceBreakDownNull() throws URISyntaxException {

        final String Url = baseUrl + "/price-breakdown";
        URI uri = new URI(Url);

        *//*HttpEntity<List<SelectedProduct>> request = new HttpEntity<>(null);*//*
        ResponseEntity<String> result = restTemplate.postForEntity(uri, null, String.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(null, result.getBody());
    }*/

    @Test
    public void testGetPriceBreakDownEmpty() throws URISyntaxException {

        final String Url = baseUrl + "/price-breakdown";
        URI uri = new URI(Url);

        HttpEntity<List<SelectedProduct>> request = new HttpEntity<>(new ArrayList<>());
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(null, result.getBody());
    }

    @Test
    public void testGetProducts() throws URISyntaxException {
        final String Url = baseUrl + "/all-products";
        URI uri = new URI(Url);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("Penguin-ears"));
    }

    @Test
    public void testGetPriceBreakdown() throws URISyntaxException, IOException {
        List<SelectedProduct> requestBody = new ArrayList<SelectedProduct>();
        requestBody.add(new SelectedProduct(0, 34, true));
        SelectedProductDetails responseProduct = new SelectedProductDetails("Penguin-ears", 8.75, 34, 1, 14, 334.25);
        List<SelectedProductDetails> productDetails = new ArrayList<SelectedProductDetails>();
        productDetails.add(responseProduct);
        PriceModel responseModel = new PriceModel(productDetails, 334.25);

        final String Url = baseUrl + "/price-breakdown";
        URI uri = new URI(Url);

        HttpEntity<List<SelectedProduct>> request = new HttpEntity<>(requestBody);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("Penguin-ears"));
    }


}
