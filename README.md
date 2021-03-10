#货运中心
###项目模块说明
####rising-uaa---登录权限
####rising-common---公共工具
####rising-discovery---注册中
####rising-filesystem---fastFDS文件服务系统
####rising-gateway---网关
####freight-center---网络道路货运


##项目运行
```
1.启动注册中心模块
2.启动登录权限模块
3.启动网关模块
4.启动其他业务模块


数据库连接的阿里云服务器MySQL
```

##项目封装了jpa条件查询
```
可参考一下包源码,或者查看网络货运模块使用
-rising-common---公共工具
--src
---support
```


##项目封装了baseController,baseService
```
可参考 
-rising-common---公共工具
--src
---web
----base

备注:为了开发规范和代码维护,(baseController,baseService)使用了大量泛型
```

##项目异常处理
```
查看
-rising-common---公共工具
--src
---web
----exception

ExceptionCast.ccast方法

```

##项目异常或业务枚举
```
可以统一使用
-rising-common---公共工具
--src
---web
----result
ResultCode类或者各个模块需要自己的枚举类去实现IResultCode接口
```