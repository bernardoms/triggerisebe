package be.com.service;

import be.com.config.Rule;
import be.com.dao.ProductDao;
import be.com.model.Order;
import be.com.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckoutService {

    private ProductDao productDao;
    private List<Product> products = new ArrayList<>();

    public CheckoutService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void scan(String code) {
        Product product = this.productDao.find(code);
        if(product != null){
            products.add(product);
        }
    }

    public double total() {
        Order order = new Order(this.products);
        Rule.rule_two_get_one().forEach(rule -> order.calculate_rule_two_get_one(products.stream().filter(product -> product.getCode().equals(rule)).collect(Collectors.toList())));
        Rule.buy_three_get_discount().forEach(rule -> order.calculate_buy_three_get_discount(products.stream().filter(product -> product.getCode().equals(rule)).collect(Collectors.toList()), Rule.discount()));
        order.calculate_no_rule_products(products);
        return order.getTotal();
    }
}
