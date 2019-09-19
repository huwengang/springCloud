package net.xdclass.order_service.domin;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: zst
 * @Date: 2019/9/17:10:06
 * @Description:商品订单实体类
 */
public class ProductOrder implements Serializable {
    private int id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 流水号
     */
    private String tradeNo;
    /**
     * 商品价格
     */
    private int price;
    private Date createTime;
    private int userId;
    /**
     * 用户名称
     */
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
