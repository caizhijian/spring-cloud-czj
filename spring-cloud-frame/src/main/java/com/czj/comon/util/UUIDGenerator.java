package com.czj.comon.util;

import java.util.UUID;

/**
 * @Author:caizhijian
 * @Date:2020-03-26
 */
public class UUIDGenerator {

    /**
     * 生成32位UUID，不含“-”符
     * @return
     */
    public static final String generateUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    /**
     * 生成32位UUID，不含“-”符
     * @return
     */
    public static final String generateUUID36(){
        return UUID.randomUUID().toString();
    }
}
