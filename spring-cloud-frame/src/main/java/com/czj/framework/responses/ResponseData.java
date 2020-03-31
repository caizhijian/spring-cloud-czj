package com.czj.framework.responses;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口响应类
 * @Author caizhijian
 * @create 2020/3/31
 */
@Data
public class ResponseData implements Serializable {
    private static final long serialVersionUID = 1L;
    String code;
    String message;
}
