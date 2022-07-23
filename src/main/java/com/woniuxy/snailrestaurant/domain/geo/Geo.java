package com.woniuxy.snailrestaurant.domain.geo;

import com.sun.javafx.geom.Point2D;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Geo {
    double x, y;

    public Geo(Double x, Double y) {
        this.x = x;
        this.y = y;
    }


    public String getFromedGeoString() {
        StringBuilder fromedGeoString = new StringBuilder();
        fromedGeoString.append("point(");
        fromedGeoString.append(this.x);
        fromedGeoString.append(" ");
        fromedGeoString.append(this.y);
        fromedGeoString.append(")");
        return fromedGeoString.toString();

    }
}
