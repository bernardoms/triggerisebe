package integration;

import be.com.dao.ProductDao;
import be.com.service.CheckoutService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CheckoutServiceIntegrationTest {

    private CheckoutService checkoutService;
    private ProductDao productDao = new ProductDao();

    @Test
    public void test_buy_one_ticket_one_hoodie_one_hat(){
        checkoutService = new CheckoutService(productDao);
        checkoutService.scan("TICKET");
        checkoutService.scan("HOODIE");
        checkoutService.scan("HAT");
        Assert.assertEquals(32.50, checkoutService.total(),0.0);
    }

    @Test
    public void test_buy_two_tickets_one_hoodie(){
        checkoutService = new CheckoutService(productDao);
        checkoutService.scan("TICKET");
        checkoutService.scan("HOODIE");
        checkoutService.scan("TICKET");
        Assert.assertEquals(25.0, checkoutService.total(),0.0);
    }

    @Test
    public void test_buy_one_ticket_four_hoodie(){
        checkoutService = new CheckoutService(productDao);
        checkoutService.scan("HOODIE");
        checkoutService.scan("HOODIE");
        checkoutService.scan("HOODIE");
        checkoutService.scan("TICKET");
        checkoutService.scan("HOODIE");
        Assert.assertEquals(81.0, checkoutService.total(),0.0);
    }

    @Test
    public void test_buy_three_ticket_three_hoodie_one_hat(){
        checkoutService = new CheckoutService(productDao);
        checkoutService.scan("TICKET");
        checkoutService.scan("HOODIE");
        checkoutService.scan("TICKET");
        checkoutService.scan("TICKET");
        checkoutService.scan("HAT");
        checkoutService.scan("HOODIE");
        checkoutService.scan("HOODIE");
        Assert.assertEquals(74.50, checkoutService.total(),0.0);
    }
}
