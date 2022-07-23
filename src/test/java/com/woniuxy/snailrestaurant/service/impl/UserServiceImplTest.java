package com.woniuxy.snailrestaurant.service.impl;

import com.woniuxy.snailrestaurant.domain.User;
import com.woniuxy.snailrestaurant.domain.geo.Geo;
import javafx.geometry.Point2D;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserServiceImpl service;
    @Test
   void plusdemon(){
       User byId = service.getById(1);


        System.out.println("");
   }

    @Test
    void geiDemon(){
        //    point( )
        Geo geo = new Geo(108.9498710632, 34.2588125935);
        System.out.println(geo.getFromedGeoString());
    }

}
