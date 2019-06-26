package com.jiukeshuke.creditapi.service;

import com.jiukeshuke.creditapi.entity.PayOrder2User;

/**
 * @Author
 * @create 2019-06-20
 **/
public interface BussinessService {


    public void insertOrderAndUser(PayOrder2User payOrder2User) throws Exception;

}
