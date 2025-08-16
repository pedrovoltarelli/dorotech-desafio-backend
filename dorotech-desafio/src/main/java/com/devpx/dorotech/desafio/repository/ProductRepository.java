package com.devpx.dorotech.desafio.repository;

import com.devpx.dorotech.desafio.entity.Product;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    public default Product saveProduct(Product product){
        product.getName();
        product.getDescription();
        product.getPrice();
        product.getAmount();

        return save(product);
    }

    @NotNull
    @Contract(pure = true)
    public default Product findAll(Product product){
        return findAll(product);
    }

    public default Optional<Product> findProductById(Long id){
        return findById(String.valueOf(id));
    }

    public default void deleteProduct(Product product){
        delete(product);
    }
}
