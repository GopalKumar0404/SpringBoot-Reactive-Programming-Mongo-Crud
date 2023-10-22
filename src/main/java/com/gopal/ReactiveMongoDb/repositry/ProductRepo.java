package com.gopal.ReactiveMongoDb.repositry;

import com.gopal.ReactiveMongoDb.dto.ProductDto;
import com.gopal.ReactiveMongoDb.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepo extends ReactiveMongoRepository<Product,String> {



    Flux<Product> findByPriceBetween(Range<Double> priceRange);
}
