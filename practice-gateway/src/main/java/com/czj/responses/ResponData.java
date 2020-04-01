package com.czj.responses;

import lombok.Data;

import java.io.Serializable;

/**
 * 响应类数据
 * @Author:caizhijian
 * @Date:2020-04-01
 */
@Data
public class ResponData implements Serializable {
    private static final long serialVersionUID = 1L;
    String code;
    String message;
}
