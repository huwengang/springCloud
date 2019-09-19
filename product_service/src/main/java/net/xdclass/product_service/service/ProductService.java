package net.xdclass.product_service.service;

import net.xdclass.product_service.domain.Product;

import java.util.List;

/**
 * @Auther: zst
 * @Date: 2019/9/16:16:00
 * @Description:
 */
public interface ProductService {
    List<Product> listProduct();
    Product findById(int id);

}
