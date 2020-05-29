package com.czj.modules.dict.controller;

import com.alibaba.fastjson.JSONObject;
import com.czj.modules.common.Constant;
import com.czj.modules.common.RedisService;
import com.czj.modules.dict.domain.entity.SDict;
import com.czj.modules.dict.service.SDictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Map> getDictByKindCode(String kindCode, String code){
        Map result = new HashMap();
        String detail = redisService.get(Constant.DICT+kindCode+code);
        if(StringUtils.isNotEmpty(detail)){
            result.put("code","0");
            result.put("data",detail);
            return ResponseEntity.ok(result);
        }
        //查询数据库，获取字典表
        SDict entity = SDictServiceImpl.query()
                .eq("kind_code", kindCode)
                .eq("code",code).one();
        if(entity==null){
            return ResponseEntity.ok(result);
        }
        detail = entity.getDetail();
        //将数据缓存起来
        redisService.set(Constant.DICT+kindCode+code,detail,60*5);
        result.put("code","0");
        result.put("data",detail);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/updateDict")
    public ResponseEntity<Map> updateDict(String kindCode, String code, String value){
        Map result = new HashMap();
        result.put("code","0");
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
            return ResponseEntity.ok(result);
        }
        result.put("message","更新失败，查无此数据");
        return ResponseEntity.ok(result);
    }

}
