package net.xdclass.order_service.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Auther: zst
 * @Date: 2019/9/17:14:29
 * @Description:json工具类
 */
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    /**
     * json字符串转jsonnode对象的方法
     */
    public static JsonNode str2JsonNode(String str){
        try {
            return objectMapper.readTree(str);
        } catch (IOException e) {
            return  null;
        }
    }
}
