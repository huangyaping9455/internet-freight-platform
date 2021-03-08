package com.rising.gateway.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

// 添加文档来源
@Component
@Primary
class DocumentationConfig implements SwaggerResourcesProvider {

    @Value("${meet.zuul.swaggerDocument}")
    private String propertySwagger;

    @Override
    public List<SwaggerResource> get() {

        return resources();
    }

    /**
     * 从阿波罗服务器中获取resources
     *
     * @return
     */
    private List<SwaggerResource> resources() {
        List resources = new ArrayList<>();
        // app-itmayiedu-order
        // 网关使用服务别名获取远程服务的SwaggerApi
        String swaggerDocJson = swaggerDocument();
        JSONArray jsonArray = JSONArray.parseArray(swaggerDocJson);
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            String name = jsonObject.getString("name");
            String location = jsonObject.getString("location");
            String version = jsonObject.getString("version");
            resources.add(swaggerResource(name, location, version));
        }
        return resources;
    }

    /**
     * 获取swaggerDocument配置
     *
     * @return
     */
    private String swaggerDocument() {
        return propertySwagger;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}
