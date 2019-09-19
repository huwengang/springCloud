package net.xdclass.order_service.service;

import net.xdclass.order_service.domin.ProductOrder;

/**
 * @Auther: zst
 * @Date: 2019/9/17:10:11
 * @Description:
 */
public interface ProductOrderService {
    /**
     * 下单接口
     * @param userId
     * @param productId
     * @return
     */
    ProductOrder save(int userId,int productId);
}
