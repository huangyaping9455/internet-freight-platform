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


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类，才生成接口文档
                //.apis(RequestHandlerSelectors.basePackage("io.sysssc.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(globalOperation());       // 主要关注点----每个接口调用都填写token
    }

    private List<Parameter> globalOperation(){
        //添加head参数配置start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        //第一个token为传参的key，第二个token为swagger页面显示的值
        tokenPar.name("Authorization").description("Authorization").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());

        return pars;
    }

    // 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题1
                .title("易电云平台RESTful API")
                // 描述
                .description("易电云平台").termsOfServiceUrl("http://localhost:8080/")
                // 创建人
                .contact(new Contact("Presoft", "http://www.presoft.com.cn", ""))
                // 版本号
                .version("1.0.1").build();
    }


}
