package net.xdclass.order_service.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import net.xdclass.order_service.domin.ProductOrder;
import net.xdclass.order_service.service.ProductClinet;
import net.xdclass.order_service.service.ProductOrderService;
import net.xdclass.order_service.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: zst
 * @Date: 2019/9/17:10:11
 * @Description:
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    //ribbon
   /* @Autowired
    private RestTemplate restTemplate;*/

   @Autowired
   private ProductClinet productClinet;

    @Override
    public ProductOrder save(int userId, int productId) {
        //获取商品详情(ribbon)
       // Map<String,Object> productMap = restTemplate.getForObject("http://product-service/api/v1/product/find?id="+productId, Map.class);
        //获取商品详情（feign）
        String response = productClinet.findById(productId);
        JsonNode jsonNode = JsonUtils.str2JsonNode(response);
        //保存订单
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
      /*  productOrder.setProductName(productMap.get("name").toString());
        productOrder.setPrice(Integer.valueOf(productMap.get("price").toString()));*/

        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.valueOf(jsonNode.get("price").toString()));
        return productOrder;
    }
}
