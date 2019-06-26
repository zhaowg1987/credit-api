package com.jiukeshuke.creditapi.service.impl;

import com.alibaba.fastjson.JSON;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.jiukeshuke.creditapi.entity.CommonRespData;
import com.jiukeshuke.creditapi.entity.OrderUser;
import com.jiukeshuke.creditapi.entity.PayOrder;
import com.jiukeshuke.creditapi.entity.PayOrder2User;
import com.jiukeshuke.creditapi.service.BussinessService;
import com.jiukeshuke.creditapi.service.OrderUserService;
import com.jiukeshuke.creditapi.service.SeckillOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author
 * @create 2019-06-20
 **/
@Slf4j
@Service
public class BussinessServiceImpl implements BussinessService {

    @Autowired
    private OrderUserService orderUserService;

    @Autowired
    private SeckillOrderService seckillOrderService;

    @LcnTransaction
    @Transactional
    @Override
    public void insertOrderAndUser(PayOrder2User payOrder2User) throws Exception {
        log.info("调用服务开始。");
        OrderUser orderUser = new OrderUser();
        orderUser.setReal_name(payOrder2User.getReal_name());
        orderUser.setUser_name(payOrder2User.getUser_name());
        orderUser.setUser_mobile(payOrder2User.getUser_phone());
        orderUser.setCreate_time(payOrder2User.getCreate_time());
        String s1 = orderUserService.insertOrderUser(orderUser);
        /*if("OrderUserService-insertOrderUser-Fallback-Error".equals(s1)) {
            throw new Exception("出现异常。。。");
        }*/
        CommonRespData commonRespData = JSON.parseObject(s1, CommonRespData.class);
        if(null != commonRespData && 200 == commonRespData.getStatus()) {
            log.info("操作成功。。。");
        } else {
            throw new Exception(commonRespData.getMessage());
        }
        PayOrder payOrder = new PayOrder();
        payOrder.setUser_phone(payOrder2User.getUser_phone());
        payOrder.setState(1);
        payOrder.setCreate_time(payOrder2User.getCreate_time());
        payOrder.setSeckill_id(payOrder2User.getSeckill_id());
        String s2 = seckillOrderService.insertSeckillOrder(payOrder);
        CommonRespData c2 = JSON.parseObject(s2, CommonRespData.class);
        if(null != c2 && 200 == c2.getStatus()) {
            log.info("操作成功。。。");
        } else {
            throw new Exception(c2.getMessage());
        }
        log.info("调用服务结束。");
    }
}
