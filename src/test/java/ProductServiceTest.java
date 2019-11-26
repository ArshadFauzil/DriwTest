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
/*import org.mockito.junit.jupiter.MockitoExtension;*/
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

/*@ExtendWith(MockitoExtension.class)*/
public class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductDao productDao;

    @Test
    public void testGetPriceBreakDownNull() {
        Assert.assertNull(productService.getPriceBreakDown(null));
    }

    @Test
    public void testGetPriceBreakDownEmpty() {
        Assert.assertNull(productService.getPriceBreakDown(new ArrayList<>()));
    }

    @Test
    public void testGetPriceBreakDownOneProduct() {
        List<SelectedProduct> requestBody = new ArrayList<SelectedProduct>();
        requestBody.add(new SelectedProduct(0, 34, true));
        requestBody.add(new SelectedProduct(3, 20, false));
        SelectedProductDetails responseProduct = new SelectedProductDetails("Penguin-ears", 8.75, 34, 1, 14, 334.25);
        List<SelectedProductDetails> productDetails = new ArrayList<SelectedProductDetails>();
        productDetails.add(responseProduct);
        PriceModel responseModel = new PriceModel(productDetails, 334.25);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        /*when(productDao.findRelevantProducts(any(Integer.class))).thenReturn(true);*/

        /*ResponseEntity<Object> responseEntity = priceController.getPriceBreakDown(requestBody);*/

        Assert.assertEquals(responseModel, productService.getPriceBreakDown(requestBody));
    }
}
