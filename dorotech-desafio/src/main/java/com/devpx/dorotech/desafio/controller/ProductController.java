package com.devpx.dorotech.desafio.controller;

import com.devpx.dorotech.desafio.entity.Product;
import com.devpx.dorotech.desafio.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/save")
    public Product saveNewProduct(Product product){
        System.out.println("Produto salvo com sucesso!");

        product.getName();
        product.getDescription();
        product.getPrice();
        product.getAmount();

        return repository.save(product);
    }

    @GetMapping("/findProduct")
    public Product find(Product product, Long id) {
        if (product.equals(product.getId())) {
            return (Product) repository.findAll(product);
        }

        return product;
    }

    @GetMapping("/findById")
    public Optional<Product> findId(Long id, Product product){
        if (product.equals(product.getId())){
            return Optional.of(product);
        }

        return repository.findProductById(id);
    }

    @DeleteMapping("/delete")
    public void delete(Product product){
        String resposta = "";

        System.out.println("Certeza que deseja deletar esse item? y/n");

        if (resposta.equals("yes")) {
            repository.deleteProduct(product);
        }
    }

}
