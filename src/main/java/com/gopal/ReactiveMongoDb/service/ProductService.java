package com.gopal.ReactiveMongoDb.service;

import com.gopal.ReactiveMongoDb.dto.ProductDto;
import com.gopal.ReactiveMongoDb.repositry.ProductRepo;
import com.gopal.ReactiveMongoDb.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Flux<ProductDto> getAllProducts(){
        return repo.findAll().map(AppUtils::entityToDto);
    }

    public Mono<ProductDto> getProdct(String id){
        return repo.findById(id).map(AppUtils::entityToDto);
    }

    public Flux<ProductDto> getProductInRange(double min, double max){
        return repo.findByPriceBetween(Range.closed(min,max)).map(AppUtils::entityToDto);
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDto){
        return productDto.map(AppUtils::dtoToProduct)
                .flatMap(repo::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<ProductDto> updateProduct (Mono<ProductDto> productDto, String id){
        return repo.findById(id)
                .flatMap(p-> productDto.map(AppUtils::dtoToProduct))
                .doOnNext(e->e.setId(id))
                .flatMap(repo::save)
                .map(AppUtils::entityToDto);


    }

    public Mono<Void> deleteProdcut (String id){
        return repo.deleteById(id);
    }
}
