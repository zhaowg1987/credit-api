package com.jiukeshuke.creditapi.service;

import com.jiukeshuke.creditapi.entity.PayOrder;
import com.jiukeshuke.creditapi.service.fallback.SeckillOrderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author
 * @create 2019-06-18
 **/
@FeignClient(name="application-service-producer-nacos",fallback= SeckillOrderServiceFallback.class)
public interface SeckillOrderService {

    @GetMapping("/service-producer-nacos/getPayOrder")
    public String getPayOrder(@RequestParam(value = "payOrderId") Long payOrderId);

    @PostMapping("/service-producer-nacos/insertOrder")
    public String insertSeckillOrder(@RequestBody PayOrder payOrder) throws Exception;
}
