package com.woniuxy.snailrestaurant.service.impl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.woniuxy.snailrestaurant.service.FileService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Component
public class FileServiceImpl implements FileService {
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridFSBucket bucket;



    @Override
    public String uploadFile(InputStream inputStream, String fileName, String contentType) {
        ObjectId objectId = gridFsTemplate.store(inputStream, fileName, contentType);
        return objectId.toHexString();
    }


    @Override
    public void downLoad (HttpServletResponse response, String fileKey) {
        GridFSFile gfs = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileKey)));
        String filename = gfs.getFilename();
        GridFsResource resource = gridFsTemplate.getResource(gfs);
        String contentType = resource.getContentType();

        response.setContentType(contentType);
        try {
            bucket.downloadToStream(filename,response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
