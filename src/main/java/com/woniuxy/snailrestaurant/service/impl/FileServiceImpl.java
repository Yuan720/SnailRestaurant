package com.woniuxy.snailrestaurant.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.woniuxy.snailrestaurant.exception.PermissionDeniedException;
import com.woniuxy.snailrestaurant.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;


@Slf4j
@Component
public class FileServiceImpl implements FileService {
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridFSBucket bucket;

    @Autowired
    ObjectMapper mapper;


    @Override
    public String uploadFile(InputStream inputStream, String fileName, String contentType) {
        ObjectId objectId = gridFsTemplate.store(inputStream, fileName, contentType);
        return objectId.toHexString();
    }


    @Override
    public void downLoad(HttpServletResponse response, String fileKey) {
        GridFSFile gfs = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileKey)));
        String filename = gfs.getFilename();
        GridFsResource resource = gridFsTemplate.getResource(gfs);
        String contentType = resource.getContentType();

        response.setContentType(contentType);
        try {
            bucket.downloadToStream(filename, response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String saveFile(MultipartFile file) {
        if (file.isEmpty()) {
            return "empty file";
        }
        String fname = file.getOriginalFilename();
        String extension = StringUtils.getFilenameExtension(fname).toLowerCase();
        String contentType = null;
        switch (extension) {
            case "jpg":
                contentType = MimeTypeUtils.IMAGE_JPEG_VALUE;
                break;
            case "jpeg":
                contentType = MimeTypeUtils.IMAGE_JPEG_VALUE;
                break;
            case "png":
                contentType = MimeTypeUtils.IMAGE_PNG_VALUE;
                break;
            case "gif":
                contentType = MimeTypeUtils.IMAGE_GIF_VALUE;
                break;
            case "pdf":
                contentType = MediaType.APPLICATION_PDF_VALUE;
                break;
            default:
                throw new RuntimeException();

        }
        if (Objects.isNull(extension)) {
            throw new RuntimeException("mimetype not suport");
        }
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String key = uploadFile(inputStream, fname, contentType);
        return key;
    }

    @Override
    public String[] saveFile(MultipartFile[] files) {

        ArrayList<String> keys = new ArrayList<>();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            String key = "upload faild";
            try {
                key = saveFile(file);
                keys.add(key);
            } catch (RuntimeException e) {
                log.error("file not suport");
                //  throw new BusinessException(CommonResultCode.FILE_TYPE_NOT_SUPORT);
                throw new PermissionDeniedException();
            }
        }

        String[] skeys = new String[keys.size()];
        return keys.toArray(skeys);
    }
}
