package io.github.helloworlde.zebra.dao;

import io.github.helloworlde.zebra.model.Product;

import java.util.List;

public interface ProductDao {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> getAll();

}