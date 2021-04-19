package com.sms.consumer.controller;

import com.sms.api.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
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

    /**
     * 文件下载
     * @param response
     * @param fileName
     * @return
     */
    @GetMapping("dowload")
    public ResponseMessage<Integer> download(HttpServletResponse response,String fileName){
        File file = new File(fileName);
        if (file.exists()) {
            try (
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis)) {
                response.setContentType("application/force-download");
                //保证下载时文件名为指定文件名，避免中文文件名乱码
                response.addHeader("Content-Disposition", "attachment;fileName="
                        + URLEncoder.encode(file.getName(), "utf-8"));
                OutputStream os = response.getOutputStream();
                StreamUtils.copy(bis, os);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                e.printStackTrace();
                return ResponseMessage.error(500,"下载失败");
            }
        }
        return ResponseMessage.success(1);
    }
}
