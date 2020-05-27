package com.czj.modules.dict.controller;

import com.alibaba.fastjson.JSONObject;
import com.czj.modules.common.Constant;
import com.czj.modules.common.RedisService;
import com.czj.modules.dict.domain.entity.SDict;
import com.czj.modules.dict.service.SDictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * 字典查询
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
    public String getDictByKindCode(String kindCode, String code){
        String detail = redisService.get(Constant.DICT+kindCode+code);
        if(StringUtils.isNotEmpty(detail)){
            return detail;
        }
        //查询数据库，获取字典表
        SDict entity = SDictServiceImpl.query()
                .eq("kind_code", kindCode)
                .eq("code",code).one();
        if(entity==null){
            return detail;
        }
        detail = entity.getDetail();
        //将数据缓存起来
        redisService.set(Constant.DICT+kindCode+code,detail,60*5);
        return detail;
    }

    @PostMapping("/updateDict")
    public String updateDict(String kindCode, String code, String value){
        JSONObject result = new JSONObject();
        result.put("code","1");
        //更新redis数据
        redisService.delete(Constant.DICT+kindCode+code);
        redisService.set(Constant.DICT+kindCode+code,value,60*5);
        //更新数据库
        SDict entity = SDictServiceImpl.query()
                .eq("kind_code", kindCode)
                .eq("code",code).one();
        if(null!=entity){
            entity.setDetail(value);
            SDictServiceImpl.saveOrUpdate(entity);
            result.put("code","0");
            result.put("message","");
            return result.toString();
        }
        result.put("message","更新失败，查无此数据");
        return result.toString();
    }

}
