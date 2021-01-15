package com.rising.security.core.validate.code.image;


import com.rising.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * 描述：图像处理器代码
 *
 * @see AbstractValidateCodeProcessor
 * 作者：李启云
 * 日期：2021-01-14
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * 创建：李启云
     * 日期：2021-01-14
     * 描述：发送图形验证码，将其写到响应中
     *
     * @param request   请求
     * @param imageCode 图片的代码
     * @return
     * @throws Exception 异常
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        assert request.getResponse() != null;
        request.getResponse().setContentType("image/jpeg");
        request.getResponse().setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }
}
