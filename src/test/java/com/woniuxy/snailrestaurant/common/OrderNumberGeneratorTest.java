package com.woniuxy.snailrestaurant.common;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class OrderNumberGeneratorTest {

    @Test
    void gen() {
        String subOrder = OrderNumberGenerator.substringLast("1234567899999876", 5);
        String subTimestamp = OrderNumberGenerator.substringLast(String.valueOf(System.currentTimeMillis()), 6);
        Calendar calendar = new GregorianCalendar();
        String subYear = OrderNumberGenerator.substringLast(String.valueOf(calendar.get(Calendar.YEAR)), 2);
        String subMoth = OrderNumberGenerator.substringLast(String.valueOf(calendar.get(Calendar.MONTH)), 2);
        String subDay = OrderNumberGenerator.substringLast(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), 2);
        Random random = new Random();
        String subRandom = OrderNumberGenerator.substringLast(String.valueOf(random.nextInt()), 2);

    }

    @Test
    void create() {
        String orderNumber = OrderNumberGenerator.createOrderNumber(123, 1);
        System.out.println(orderNumber);

    }
}
