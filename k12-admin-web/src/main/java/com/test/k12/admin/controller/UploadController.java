package com.test.k12.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author lry
 */
@RestController
public class UploadController {
    @Value("${file.upload.dir}")
    private String path;

    @RequestMapping(value = "/upload.html")
    public String fileUpload1(@RequestParam("file") MultipartFile file) {
        try {
            String name = file.getOriginalFilename();//源文件名
            //拓展名
            String extName = name.substring(name.lastIndexOf("."));
            //新文件名
            String newFileName = System.currentTimeMillis() + extName;
            File newFile = new File(path + newFileName);
            file.transferTo(newFile);
            return "{\"error\":0,\"url\":\"/upload/" + newFileName + "\"}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        //上传成功返回原来页面
        return "{\"error\":1}";
    }

}
