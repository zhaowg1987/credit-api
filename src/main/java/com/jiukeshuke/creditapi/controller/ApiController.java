package com.jiukeshuke.creditapi.controller;

import com.jiukeshuke.creditapi.entity.CommonRespData;
import com.jiukeshuke.creditapi.entity.PayOrder2User;
import com.jiukeshuke.creditapi.service.BussinessService;
import com.jiukeshuke.creditapi.service.OrderUserService;
import com.jiukeshuke.creditapi.service.SeckillOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * @create 2019-06-18
 **/
@Slf4j
@RestController
public class ApiController {

    @Autowired
    private OrderUserService orderUserService;

    @Autowired
    private SeckillOrderService seckillOrderService;


    @Autowired
    private BussinessService bussinessService;

    @RequestMapping(value = "/getUserAndOrderIndo/{userId}", method = RequestMethod.GET)
    public String getUserAndOrderIndo(@PathVariable("userId") Long userId) {
        //
        log.info("参数userId:{}",userId);
        StringBuffer stringBuffer = new StringBuffer("");
        String orderUser = orderUserService.getPayOrderUser(userId);
        stringBuffer.append(orderUser);
        log.info("请求结果orderUser:{}",orderUser);
        String orderInfo = seckillOrderService.getPayOrder(userId);
        log.info("请求结果orderInfo:{}",orderInfo);
        stringBuffer.append(orderInfo);
        return stringBuffer.toString();
    }

    @RequestMapping(value = "/saveUserAndOrderInfo" ,method = RequestMethod.POST)
    public CommonRespData insertOrderAndUser(@RequestBody PayOrder2User payOrder2User) {
        CommonRespData commonRespData = new CommonRespData();
        try {
            bussinessService.insertOrderAndUser(payOrder2User);
            commonRespData.setStatus(200);
            commonRespData.setMessage("保存成功！");
        } catch (Exception e) {
            commonRespData.setStatus(500);
            commonRespData.setMessage(e.getMessage());
            log.error("保存出现异常。", e);
        }
        return commonRespData;
    }

}
