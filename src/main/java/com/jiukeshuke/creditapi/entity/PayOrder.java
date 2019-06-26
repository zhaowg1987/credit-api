package com.jiukeshuke.creditapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author
 * @create 2019-06-18
 **/
@Data
public class PayOrder implements Serializable {

    private static final long serialVersionUID = 3713020924840715740L;
    // 秒杀商品id
    private Long seckill_id;
    // 用户手机号
    private Long user_phone;
    // 状态标示:-1:无效 0:成功 1:已付款 2:已发货
    private Integer state;
    // 创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

}
