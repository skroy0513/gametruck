package com.gametruck.mapper;

import com.gametruck.vo.Category;
import com.gametruck.vo.Platform;
import com.gametruck.vo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    // 모든 카테고리 불러오기
    List<Category> getAllCategories();

    // 모든 플랫폼 불러오기
    List<Platform> getAllPlatforms();

    // 상품 등록하기
    void registerProduct(Product product);
}
