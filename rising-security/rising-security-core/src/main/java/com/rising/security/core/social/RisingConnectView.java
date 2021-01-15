package com.rising.security.core.social;

import com.alibaba.fastjson.JSON;
import com.rising.security.core.utils.ResultVOUtil;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * 描述：由于微信，QQ，微博等解绑和绑定都想用这个视图，但providerId不可能一样
 * * 所以这里不能直接用@Component注解将其写死
 * 创建时间：2020-02-01 17:37:10
 * 创建作者：李启云
 */
public class RisingConnectView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        //如果map（Model对象）里有Connection对象，则表示绑定，否则表示解绑
        if (map.get("connections") == null) {
            response.getWriter().write(JSON.toJSONString(ResultVOUtil.success("解绑成功")));
        } else {
            response.getWriter().write(JSON.toJSONString(ResultVOUtil.success("绑定成功")));
        }
    }
}
