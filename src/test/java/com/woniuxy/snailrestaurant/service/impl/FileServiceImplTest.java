package com.woniuxy.snailrestaurant.service.impl;

import com.woniuxy.snailrestaurant.service.FileService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

import java.io.FileInputStream;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FileServiceImplTest {

    @Autowired
    FileService service;

    @Test
    void uploadFile() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\LeeYuan\\Desktop\\test\\tt.jpg");
        String key = service.uploadFile(fileInputStream, "myfile", MimeTypeUtils.IMAGE_JPEG_VALUE);
        System.out.println(key);


    }



    @Test
    void downLoad() {
    }
}
