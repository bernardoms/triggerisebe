package unit;

import be.com.config.Rule;
import be.com.model.Order;
import be.com.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Rule.class)
public class OrderUnitTest {


    @Before
    public void setup(){
        PowerMockito.mockStatic(Rule.class);
    }

    @Test
    public void test_calculate_product_without_rule(){
        Product hat = new Product();
        hat.setCode("HAT");
        hat.setPrice(7.50);

        Product hoodie = new Product();
        hoodie.setCode("HOODIE");
        hoodie.setPrice(20.00);

        when(Rule.getAllRules()).thenReturn(Collections.singletonList(""));

        List<Product> productList = Arrays.asList(hat, hoodie);
        Order order = new Order(productList);
        order.calculate_no_rule_products(productList);
        Assert.assertEquals(27.50, order.getTotal(), 0.0);
    }

    @Test
    public void test_calculate_product_two_get_one_rule(){
        Product hat = new Product();
        hat.setCode("HAT");
        hat.setPrice(7.50);

        List<Product> productList = Arrays.asList(hat, hat, hat);
        Order order = new Order(productList);
        order.calculate_rule_two_get_one(productList);

        Assert.assertEquals(15.00, order.getTotal(), 0.0);
    }

    @Test
    public void test_calculate_product_buy_three_get_discount_rule(){
        Product hoodie = new Product();
        hoodie.setCode("HOODIE");
        hoodie.setPrice(20.00);

        List<Product> productList = Arrays.asList(hoodie, hoodie, hoodie);
        Order order = new Order(productList);
        order.calculate_buy_three_get_discount(productList,0.05);

        Assert.assertEquals(57.00, order.getTotal(), 0.0);
    }
}
