package com.woniuxy.snailrestaurant.service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

public interface FileService {


    String uploadFile(InputStream inputStream, String fileName, String contentType);



    void downLoad(HttpServletResponse response, String fileKey);
}
