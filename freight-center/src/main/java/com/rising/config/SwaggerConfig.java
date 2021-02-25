package com.rising.config;

import com.fasterxml.classmate.GenericType;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * 版本：1.0.0
 * 描述：接口文档配置
 *
 * @see ApiListingScannerPlugin
 * 码农：李齐云
 * 日期：2021-02-25
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig implements ApiListingScannerPlugin {
    // swagger接口界面访问路径 ：http://localhost:9800/swagger-ui.html  IP为机器的IP，端口号为工程的端口

    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // api接口路径，即controller层路径
                .apis(RequestHandlerSelectors.basePackage("com.rising"))
                // 指定路径处理PathSelectors.any()代表所有的路径（除了被@ApiIgnore指定的请求）
                .paths(PathSelectors.any())
                .build()
                .alternateTypeRules(
                        newRule(
                                typeResolver.resolve(
                                        DeferredResult.class,
                                        typeResolver.resolve(GenericType.class, WildcardType.class)
                                ),
                                typeResolver.resolve(WildcardType.class)
                        )
                )
                // 支持的协议
                .protocols(newHashSet("https", "http"))
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("网络货运管理api")
                .description("网络货运管理接口")
                .version("2.0")
                .build();
    }

    /**
     * 码农：李齐云
     * 日期：2021-02-25
     * 描述：设置授权信息
     * <p>
     * 返回值：{@link List<ApiKey> }
     */
    private List<ApiKey> securitySchemes() {
        // 在请求头header添加一个名为Authorization的token
        return Collections.singletonList(new ApiKey(HttpHeaders.AUTHORIZATION, "Authorization", "header"));
    }

    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(
                                Collections.singletonList(new SecurityReference("Authorization",
                                        new AuthorizationScope[]{new AuthorizationScope("global", "")}
                                )))
                        // 可通过配置正则表达式去排除一些不需要携带token访问的接口 这里不做特殊处理，全部接口访问都需要携带
                        // 比如.forPaths(PathSelectors.regex("^(?!auth).*$"))  对所有包含"auth"的接口不需要使用securitySchemes
                        .forPaths(PathSelectors.any())
                        .build()
        );
    }

    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if (ts.length > 0) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }

    /**
     * 码农：李齐云
     * 日期：2021-02-25
     * 描述：实现此方法可手动添加ApiDescriptions
     * 返回值：{@link List<ApiDescription> }
     *
     * @param context 上下文
     */
    @Override
    public List<ApiDescription> apply(DocumentationContext context) {

        Operation usernamePasswordOperation = new OperationBuilder(new CachingOperationNameGenerator())
                .method(HttpMethod.POST)
                .summary("用户名密码登录")
                .notes("username/password登录")
                .consumes(Sets.newHashSet(MediaType.APPLICATION_FORM_URLENCODED_VALUE)) // 接收参数格式
                .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE)) // 返回参数格式
                .tags(Sets.newHashSet("登录授权(Authorization)"))
                .parameters(Arrays.asList(
                        new ParameterBuilder()
                                .description("用户名")
                                .type(new TypeResolver().resolve(String.class))
                                .name("username")
                                .defaultValue("admin")
                                .parameterType("query")
                                .parameterAccess("access")
                                .required(true)
                                .modelRef(new ModelRef("string"))
                                .build(),
                        new ParameterBuilder()
                                .description("密码")
                                .type(new TypeResolver().resolve(String.class))
                                .name("password")
                                .defaultValue("123456")
                                .parameterType("query")
                                .parameterAccess("access")
                                .required(true)
                                .modelRef(new ModelRef("string"))
                                .build(),
                        new ParameterBuilder()
                                .description("验证码唯一标识")
                                .type(new TypeResolver().resolve(String.class))
                                .name("deviceId")
                                .defaultValue("web")
                                .parameterType("header")
                                .parameterAccess("access")
                                .required(true)
                                .modelRef(new ModelRef("string"))
                                .build(),
                        new ParameterBuilder()
                                .description("验证码")
                                .type(new TypeResolver().resolve(String.class))
                                .name("imageCode")
                                .parameterType("query")
                                .parameterAccess("access")
                                .required(true)
                                .modelRef(new ModelRef("string"))
                                .build()
                ))
                .responseMessages(Collections.singleton(
                        new ResponseMessageBuilder().code(200).message("请求成功")
                               .build()))
                .build();

        ApiDescription loginApiDescription = new ApiDescription("认证请求","/authentication/form",  "登录接口", Arrays.asList(usernamePasswordOperation), false);

        return Arrays.asList(loginApiDescription);
    }

    /**
     * 码农：李齐云
     * 日期：2021-02-25
     * 描述：支持
     * <p>
     * 返回值：boolean
     *
     * @param documentationType 文档类型
     */
    @Override
    public boolean supports(DocumentationType documentationType) {
        return DocumentationType.SWAGGER_2.equals(documentationType);
    }

}

