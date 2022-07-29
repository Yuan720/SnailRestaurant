package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.common.CommonResultCode;
import com.woniuxy.snailrestaurant.exception.BusinessException;
import com.woniuxy.snailrestaurant.exception.PermissionDeniedException;
import com.woniuxy.snailrestaurant.service.FileService;
import io.swagger.annotations.Api;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
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
    public List<String> upload(@RequestPart("file") MultipartFile[] files) {
        ArrayList<String> keys=new ArrayList<>();
            for (MultipartFile file:files){
                if (file.isEmpty()){
                    continue;
                }
                String key = "upload faild";
                try {
                    key = service.saveFile(file);
                    keys.add(key);
                } catch (RuntimeException e) {
                    log.log(Level.SEVERE, "file not suport");
                  //  throw new BusinessException(CommonResultCode.FILE_TYPE_NOT_SUPORT);
                    throw new PermissionDeniedException();
                }
            }

            return keys;
    }
    @GetMapping("/page")
    String uploadPage(){
        return "upload";
    }

    @GetMapping("/review")
    String reviewPage(){
        return "review";
    }

}
