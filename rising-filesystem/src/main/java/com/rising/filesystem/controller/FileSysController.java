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


    @ResponseResult
    @PostMapping(value = "/delete")
    public int delete(@RequestBody String file) throws Exception {
        String group = file.substring(0,7);
        String fileName = file.substring(7);
        int back = fastdfsClientService.delete(group,fileName);
        return back;

    }


}
