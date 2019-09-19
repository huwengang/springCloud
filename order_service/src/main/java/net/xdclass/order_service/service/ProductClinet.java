package net.xdclass.order_service.service;

import net.xdclass.order_service.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: zst
 * @Date: 2019/9/17:14:16
 * @Description:
 */


@FeignClient(name="product-service",fallback = ProductClientFallback.class)
public interface ProductClinet {
    @GetMapping("api/v1/product/find")
    String findById(@RequestParam("id") int id);

}
