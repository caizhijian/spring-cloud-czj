package com.czj.modules.testswagger;

import com.czj.modules.testswagger.param.AddUserParam;
import com.czj.modules.testswagger.param.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:caizhijian
 * @Date:2020-04-25
 */
@Api(description = "用户操作接口")
@Controller("user")
@RequestMapping("/user")
public class TestSwaggerController {

    @ApiOperation(value = "新增用户")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = UserDto.class) })
    @PostMapping("/user")
    public UserDto addUser(@RequestBody AddUserParam param) {
        System.err.println(param.getName());
        return new UserDto();
    }

    @ApiOperation(value = "测试Swagger")
    @RequestMapping("/test")
    @GetMapping
    public String test(String name){

        return name;
    }
}
