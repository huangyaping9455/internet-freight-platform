package com.rising.filesystem.controller;

import com.rising.common.web.annotation.ResponseResult;
import io.github.bluemiaomiao.service.FastdfsClientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;

@Slf4j
@RestController
@RequestMapping("/fileFastDFS")
public class FileSysController {

    @Autowired
    private FastdfsClientService fastdfsClientService;

    @ResponseResult
    @PostMapping("/upload")
    public String upload(MultipartFile multipartFile) throws Exception {
        byte[] bytes = multipartFile.getBytes();
        String[] strings = fastdfsClientService.autoUpload(bytes, multipartFile.getOriginalFilename());
        String path = StringUtils.join(strings, "/");
        log.info("path:{}", path);

        return path;

    }


}
