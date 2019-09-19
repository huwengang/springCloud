package net.xdclass.product_service.controller;

import net.xdclass.product_service.domain.Product;
import net.xdclass.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


/**
 * @Auther: zst
 * @Date: 2019/9/16:15:55
 * @Description:
 */
@RestController
@RequestMapping("api/v1/product")
public class productController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private ProductService productService;

    /**
     * 获取商品所有列表
     * @return
     */
    @RequestMapping("list")
    public Object list(){
        return productService.listProduct();
    }

    /**
     * 根据商品ID获取商品
     * @param id
     * @return
     */
    @RequestMapping("find")
    public Object findById(@RequestParam("id") int id) throws InterruptedException {
        //TimeUnit.SECONDS.sleep(2);
        Product byId = productService.findById(id);
        Product product = new Product();
        BeanUtils.copyProperties(byId,product);
        product.setName(byId.getName()+"data from port="+port);
        return product;
    }
}
