package com.woniuxy.snailrestaurant.controller;

import com.woniuxy.snailrestaurant.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    FileService service;

    @GetMapping("/{key}")
    void downLoad(@PathVariable("key") String key, HttpServletResponse response){
        service.downLoad(response,key);
    }
}
