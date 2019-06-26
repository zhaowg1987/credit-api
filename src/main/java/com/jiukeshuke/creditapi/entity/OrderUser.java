package com.jiukeshuke.creditapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 *
 * @Author
 * @create 2019-06-18
 **/
@Data
public class OrderUser implements Serializable {
    private static final long serialVersionUID = 1021096773082650654L;

    private Long id;

    private String user_name;

    private String real_name;

    private Long user_mobile;

    // 创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

}
