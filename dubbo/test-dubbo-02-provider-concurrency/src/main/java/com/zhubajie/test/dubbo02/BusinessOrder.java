package com.zhubajie.test.dubbo02;




import java.util.List;

import javax.jws.WebService;

/*import org.springframework.stereotype.Service;*/


import com.alibaba.dubbo.config.annotation.Service;
import com.zhubajie.test.dubbo02.model.OrderInfo;


@Service
public class BusinessOrder implements IBusinessOrder {
    public String SendStr(String str) {
        return str;
    }

    public List<OrderInfo> LoadOrders(List<OrderInfo> orders) {
        return orders;
    }

    public OrderInfo LoadOrder(OrderInfo order) {
        return order;
    }
}