package com.czj.framework.responses;

import lombok.*;

/**
 * @Author:caizhijian
 * @Date:2020-03-26
 */
@Getter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponses<T> extends ApiResponses<T> {

    private static final long serialVersionUID = 1L;
    /**
     * 错误码
     */
    private Integer errcode;
    /**
     * 结果集返回
     */
    private T result;

}
