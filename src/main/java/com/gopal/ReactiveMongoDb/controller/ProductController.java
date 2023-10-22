package com.gopal.ReactiveMongoDb.controller;

import com.gopal.ReactiveMongoDb.dto.ProductDto;
import com.gopal.ReactiveMongoDb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Flux<ProductDto> getAllProducts(){
        return service.getAllProducts();
    }
    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct(@PathVariable String id){
        return service.getProdct(id);
    }

    @GetMapping("/product-range")
    public Flux<ProductDto> getProductInRange(@RequestParam double min, @RequestParam double max){
        return service.getProductInRange(min, max);
    }

    @PostMapping
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDto){
        return service.saveProduct(productDto);
    }

    @PutMapping("/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> productDtoMono, @PathVariable String id){
        return service.updateProduct(productDtoMono,id  );
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct( @PathVariable String id){
        return service.deleteProdcut(id);
    }
}
