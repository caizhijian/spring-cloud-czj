package com.czj.modules.dict.controller;


import com.czj.modules.common.Constant;
import com.czj.modules.common.RedisService;
import com.czj.modules.dict.domain.entity.SDict;
import com.czj.modules.dict.service.SDictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author caizhijian
 * @since 2020-05-04
 */
@RestController
@RequestMapping("/dict")
public class SDictController {
    @Autowired
    private RedisService redisService;

    @Autowired
    private SDictService SDictServiceImpl;

    @RequestMapping("/getDictByKindCode")
    public String getDictByKindCode(String kindCode,String code){
        String detail = redisService.get(Constant.DICT+kindCode);
        if(StringUtils.isNotEmpty(detail)){
            return detail;
        }System.out.println(666);
        //查询数据库，获取字典表
        SDict entity = SDictServiceImpl.query()
                .eq("kind_code", kindCode)
                .eq("code",code).one();
        if(entity==null){
            return detail;
        }
        detail = entity.getDetail();
        //将数据缓存起来
        redisService.set(Constant.DICT+kindCode,detail,1);
        return detail;
    }

}
