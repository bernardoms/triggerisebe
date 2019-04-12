package be.com.model;

import be.com.config.Rule;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private List<Product> products;
    private double total;

    public Order(List<Product> products){
        this.products = products;
        this.total = 0;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void calculate_rule_two_get_one(List<Product> products) {
        if (products.size() == 1) {
            this.total += products.get(0).getPrice();
        } else {
            int qtdProductPayed = products.size() / 2;
            this.total+= products.stream().mapToDouble(Product::getPrice).sum() - products.get(0).getPrice() * qtdProductPayed;
        }
    }

    public void calculate_buy_three_get_discount(List<Product> products, double amountDiscount) {
        double discount = 0;
        if (products.size() > 2) {
            discount = amountDiscount;
        }

        double total = products.stream().mapToDouble(Product::getPrice).sum();
        this.total+= total - discount * total;
    }

    public void calculate_no_rule_products(List<Product> products) {
        Rule.getAllRules().forEach(rule -> products.removeAll(products.stream().filter(product -> product.getCode().equals(rule)).collect(Collectors.toList())));
        this.total+= products.stream().mapToDouble(Product::getPrice).sum();
    }
}
