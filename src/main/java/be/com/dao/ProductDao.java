package be.com.dao;

import be.com.config.CassandraConfig;
import be.com.model.Product;
import com.datastax.driver.mapping.Mapper;

public class ProductDao {
    private Mapper<Product> mapper;

    public ProductDao(){
        this.mapper = CassandraConfig.mappingManager().mapper(Product.class);
    }

    public Product find(String productId){
        return mapper.get(productId);
    }
}
