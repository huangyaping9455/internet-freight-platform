package com.rising.filesystem.controller;

import com.rising.common.web.annotation.ResponseResult;
import com.rising.common.web.exception.ExceptionCast;
import com.rising.common.web.result.ResultCode;
import io.github.bluemiaomiao.service.FastdfsClientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Array;

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


    /**
     * 码农：李齐云
     * 日期：2021-01-28
     * 描述：删除 例如：group1/M00/00/00/rBsQDmASX82AJ5GBABwP9pzkNr44.2.png
     * 返回值：int
     * @param groupName 组名称   group1
     * @param fileName  文件名称  M00/00/00/rBsQDmASX82AJ5GBABwP9pzkNr44.2.png
     * @throws Exception 异常
     */
    @ResponseResult
    @DeleteMapping(value = "/delete")
    public int delete(@RequestParam String groupName,@RequestParam String fileName) throws Exception {

        int back = fastdfsClientService.delete(groupName,fileName);
        System.out.println(back);
        return back;

    }


}
