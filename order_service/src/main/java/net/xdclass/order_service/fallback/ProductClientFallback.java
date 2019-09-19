package net.xdclass.order_service.fallback;

import net.xdclass.order_service.service.ProductClinet;
import org.springframework.stereotype.Component;

/**
 * @Auther: zst
 * @Date: 2019/9/17:17:04
 * @Description:
 */
@Component
public class ProductClientFallback implements ProductClinet {
    /**
     * 针对商品服务做降级处理
     * @param id
     * @return
     */
    @Override
    public String findById(int id) {
        System.out.println("调用商品服务异常！！！");
        return null;
    }
}
