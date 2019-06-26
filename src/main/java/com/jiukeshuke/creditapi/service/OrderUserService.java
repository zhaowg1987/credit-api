package com.jiukeshuke.creditapi.service;

import com.jiukeshuke.creditapi.entity.OrderUser;
import com.jiukeshuke.creditapi.service.fallback.OrderUserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author
 * @create 2019-06-18
 **/

@FeignClient(name="application-user-service-producer-naco", fallback = OrderUserServiceFallback.class)
public interface OrderUserService {

    @GetMapping("/user-service-producer-naco/getOrderUser")
    public String getPayOrderUser(@RequestParam(value = "orderUserId") Long orderUserId);

    @PostMapping("/user-service-producer-naco/insertUser")
    public String insertOrderUser(@RequestBody OrderUser orderUser) throws Exception;

}
