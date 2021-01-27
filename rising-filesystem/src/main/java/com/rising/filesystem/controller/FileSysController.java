package com.rising.filesystem.controller;

import com.rising.common.web.annotation.ResponseResult;
import io.github.bluemiaomiao.service.FastdfsClientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/fileFastDFS")
public class FileSysController {

    @Autowired
    private FastdfsClientService fastdfsClientService;

    @ResponseResult
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        String name = multipartFile.getName();

        log.info("文件名称：{}", name);
        byte[] bytes = multipartFile.getBytes();
        String[] strings = fastdfsClientService.autoUpload(bytes, multipartFile.getOriginalFilename());
        String path = StringUtils.join(strings, "/");
        log.info("path:{}", path);

        return path;

    }
//删除上传文件(文件服务器里面/更新数据库)

    @ResponseResult
    @PostMapping(value = "/delete")
    public int delete(@RequestParam String groupName,@RequestParam String fileName) throws Exception {

        int back = fastdfsClientService.delete(groupName,fileName);
        return back;

    }


}
