package com.czj.framework.responses;

import lombok.*;

import java.time.LocalDateTime;

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
@NoArgsConstructor
public class FailedResponse extends ApiResponses {

    private static final long serialVersionUID = 1L;
    /**
     * 错误状态码
     */
    private int errcode;
    /**
     * 错误描述
     */
    private String errmsg;
    /**
     * 异常信息
     */
    private String exception;
    /**
     * 客户端是否展示
     */
    private Boolean show;
    /**
     * 当前时间戳
     */
    private LocalDateTime time;

    private String serialNumber;

}
