package net.xdclass.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.xdclass.order_service.service.ProductOrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zst
 * @Date: 2019/9/17:10:09
 * @Description:
 */
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private ProductOrderService productOrderService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id") int userId,@RequestParam("product_id")int productId){
        Map<String, Object> msg = new HashMap<>();
        msg.put("code",0);
        msg.put("data", productOrderService.save(userId, productId));
        return msg;
    }
    //方法签名一定要和api方法签名一致
    private Object saveOrderFail(int userId,int productId){
        //监控报警
        String saveOrderKey="save-order";
        String sentValue = redisTemplate.opsForValue().get(saveOrderKey);
        new Thread(()->{
            if(StringUtils.isBlank(sentValue)){
                System.out.println("紧急短信，用户下单失败，请立刻查找原因！！！");
                //调用http请求 广告服务商
                redisTemplate.opsForValue().set(saveOrderKey,"save-order-fail",20, TimeUnit.SECONDS);
            }else{
                System.out.println("已经发送过短信啦！20秒内不重新发送");
            }
        }).start();
        Map<String, Object> msg = new HashMap<>();
        msg.put("code",-1);
        msg.put("msg","抢购人数太多，您被挤出来了");
        return msg;
    };

}
