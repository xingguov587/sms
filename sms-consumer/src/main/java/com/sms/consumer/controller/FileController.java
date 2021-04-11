package com.sms.consumer.controller;

import com.sms.api.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

/**
 * @author chengxing
 * @date 2021/04/02
 * @decription 文件管理
 */
@Slf4j
@RequestMapping("file")
@RestController
public class FileController {

    @Value("${file.upload.path}")
    private String path;

    @PostMapping("upload")
    public ResponseMessage<String> upload(@RequestPart MultipartFile file){
        String fileName = file.getOriginalFilename();
        String filePath = path + fileName;
        try {
            File dest = new File(filePath);
            Files.copy(file.getInputStream(), dest.toPath());
            return ResponseMessage.success(dest.getAbsolutePath());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.error(500,"文件上传失败");
        }
    }
}
