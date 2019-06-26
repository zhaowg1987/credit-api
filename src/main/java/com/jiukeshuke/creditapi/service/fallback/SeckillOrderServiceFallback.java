package com.jiukeshuke.creditapi.service.fallback;

import com.alibaba.fastjson.JSON;
import com.jiukeshuke.creditapi.entity.CommonRespData;
import com.jiukeshuke.creditapi.entity.PayOrder;
import com.jiukeshuke.creditapi.service.SeckillOrderService;
import org.springframework.stereotype.Component;

/**
 * 接口断路器
 *
 * @Author
 * @create 2019-06-19
 **/
@Component
public class SeckillOrderServiceFallback implements SeckillOrderService {

    @Override
    public String getPayOrder(Long payOrderId) {
        CommonRespData commonRespData = new CommonRespData(505,"SeckillOrderService-Fallback-Error");
        return JSON.toJSONString(commonRespData);
    }

    @Override
    public String insertSeckillOrder(PayOrder payOrder) throws Exception {
        CommonRespData commonRespData = new CommonRespData(505,"SeckillOrderService-insertSeckillOrder-Fallback-Error");
        return JSON.toJSONString(commonRespData);
    }
}
