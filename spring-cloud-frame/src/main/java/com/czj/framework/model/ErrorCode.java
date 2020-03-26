package com.czj.framework.model;

import lombok.*;

/**
 * @Author:caizhijian
 * @Date:2020-03-26
 */
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ErrorCode {

    /**
     * 错误
     */
    private int errcode;

    /**
     * 是否展示
     */
    private boolean show;
    /**
     * 错误消息
     */
    private String errmsg;


    /**
     * 用于抛出业务异常信息
     * @param errmsg
     */
    public ErrorCode(String errmsg){
        this.errcode = 400;
        this.show = true;
        this.errmsg = errmsg;
    }

}
