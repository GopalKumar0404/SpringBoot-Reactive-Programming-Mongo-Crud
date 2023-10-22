package com.gopal.ReactiveMongoDb.utils;

import com.gopal.ReactiveMongoDb.dto.ProductDto;
import com.gopal.ReactiveMongoDb.entity.Product;
import org.springframework.beans.BeanUtils;

import java.beans.Beans;

public class AppUtils {

    public static Product dtoToProduct(ProductDto productDto){
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        return product;
    }

    public static ProductDto entityToDto (Product product){
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        return productDto;
    }
}
