package com.gametruck.service;

import com.gametruck.mapper.ProductMapper;
import com.gametruck.vo.Category;
import com.gametruck.vo.Platform;
import com.gametruck.vo.Product;
import com.gametruck.web.form.ProductForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void registerProduct(ProductForm productForm) {
        Product product = new Product();
        BeanUtils.copyProperties(productForm, product);
        product.setCategory(Category.builder().no(productForm.getCatNo()).build());
        product.setPlatform(Platform.builder().no(productForm.getPlatformNo()).build());
        System.out.println(product);
        productMapper.registerProduct(product);
    }

    public List<Category> getAllCategories() {
        return productMapper.getAllCategories();
    };

    public List<Platform> getAllPlatforms() {
        return productMapper.getAllPlatforms();
    }
}
