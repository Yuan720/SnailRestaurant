package com.woniuxy.snailrestaurant.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

public interface FileService {


    String uploadFile(InputStream inputStream, String fileName, String contentType);



    void downLoad(HttpServletResponse response, String fileKey);

    String saveFile(MultipartFile file);

    String[] saveFile(MultipartFile[] files);
}
