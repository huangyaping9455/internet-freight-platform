package com.rising.gateway.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试",tags = "密密麻麻")
@RestController
@RequestMapping("v1")
public class TestApi {

    @ApiOperation(value = "获取")
    @GetMapping("/test")
    public String getStr(@ApiParam(required = true) String name){
        return name;
    }
}
