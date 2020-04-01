package com.czj.modules.fallback;

import com.alibaba.fastjson.JSON;
import com.czj.responses.ResponData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:caizhijian
 * @Date:2020-04-01
 */
@RestController
public class FallbackController {
    @GetMapping("/fallback")
    public String fallback() {
        ResponData data = new ResponData();
        data.setCode("401");
        data.setMessage("服务器开小差了");
        return JSON.toJSONString(data);
    }
}
