package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.service.FileService;
import lombok.extern.java.Log;
import nonapi.io.github.classgraph.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

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
