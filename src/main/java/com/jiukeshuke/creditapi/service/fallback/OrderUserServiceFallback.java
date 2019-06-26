package com.jiukeshuke.creditapi.service.fallback;

import com.alibaba.fastjson.JSON;
import com.jiukeshuke.creditapi.entity.CommonRespData;
import com.jiukeshuke.creditapi.entity.OrderUser;
import com.jiukeshuke.creditapi.service.OrderUserService;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @create 2019-06-19
 **/
@Component
public class OrderUserServiceFallback implements OrderUserService {

    @Override
    public String getPayOrderUser(Long orderUserId) {
        CommonRespData commonRespData = new CommonRespData(505,"OrderUserService-Fallback-Error");
        return JSON.toJSONString(commonRespData);
    }

    @Override
    public String insertOrderUser(OrderUser orderUser) throws Exception {
        CommonRespData commonRespData = new CommonRespData(505,"OrderUserService-insertOrderUser-Fallback-Error");
        return JSON.toJSONString(commonRespData);
    }
}
