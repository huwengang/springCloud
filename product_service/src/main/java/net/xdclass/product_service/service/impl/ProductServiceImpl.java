package net.xdclass.product_service.service.impl;

import net.xdclass.product_service.domain.Product;
import net.xdclass.product_service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: zst
 * @Date: 2019/9/16:16:02
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static final Map<Integer,Product> daoMap=new HashMap<Integer, Product>();
    static {
        Product p1 =new Product(1,"iphone11",8000,10001);
        Product p2 =new Product(2,"冰箱",1000,10002);
        Product p3 =new Product(3,"洗衣机",800,10003);
        Product p4 =new Product(4,"电话",50,10004);
        Product p5 =new Product(5,"椅子",80,10005);
        Product p6 =new Product(6,"iphoneX",10000,10006);
        Product p7 =new Product(7,"编程思想",100,10007);
        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);
        daoMap.put(p5.getId(),p5);
        daoMap.put(p6.getId(),p6);
        daoMap.put(p7.getId(),p7);
    }
    @Override
    public List<Product> listProduct() {
        Collection<Product> values = daoMap.values();
        List<Product> list = new ArrayList<>(values);
        return list;
    }

    @Override
    public Product findById(int id) {
        return daoMap.get(id);
    }
}
