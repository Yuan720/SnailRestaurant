package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.service.FileService;
import io.swagger.annotations.Api;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;

@Api(tags = "文件系统")
@Log
@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    FileService service;

    @GetMapping("/{key}")
    void downLoad(@PathVariable("key") String key, HttpServletResponse response) {
        service.downLoad(response, key);
    }

    @ResponseBody
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {

        String key = "upload faild";
        try {
            key = service.saveFile(file);
        } catch (RuntimeException e) {
            log.log(Level.SEVERE, "file not suport");
            e.printStackTrace();
        }

        return key;
    }
    @GetMapping("/page")
    String uploadPage(){
        return "upload";
    }


}
