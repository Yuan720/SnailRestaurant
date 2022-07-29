package com.woniuxy.snailrestaurant.common;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.models.auth.In;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class OrderNumberGenerator {

    /**
     * 截取 字符串，不够以0 补充
     *
     * @param str   字符串
     * @param start 截取开始位置(包含)
     * @param end   截取结束位置(不包含)
     * @return
     */
    public static String substring(String str, int start, int end) {
        int len = 0;
        if (StringUtils.isNotBlank(str)) {
            len = str.length();
        }

        if (len < end) {// 长度不够，补充 0
            return append(str, len, end).substring(start, end);
        } else {
            return str.substring(start, end);
        }

    }

    private static String append(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append("0");
        }
        sb.append(str);
        return sb.toString();
    }

    /**
     * 截取最后字符规定长度的字符串，不足以0补充
     *
     * @param str    字符串
     * @param subLen 截取长度
     * @return
     */
    public static String substringLast(String str, int subLen) {
        int leng = 0;
        if (StringUtils.isNotBlank(str)) {
            leng = str.length();
        }
        if (leng < subLen) {
            return append(str, leng, subLen);
        } else {
            return str.substring(leng - subLen);
        }
    }

    public static String createOrderNumber(Integer userId, Integer type) {

        String subUser = OrderNumberGenerator.substringLast(String.valueOf(userId), 5);
        String subTimestamp = OrderNumberGenerator.substringLast(String.valueOf(System.currentTimeMillis()), 6);
        Calendar calendar = new GregorianCalendar();
        String subYear = OrderNumberGenerator.substringLast(String.valueOf(calendar.get(Calendar.YEAR)), 2);
        String subMoth = OrderNumberGenerator.substringLast(String.valueOf((calendar.get(Calendar.MONTH)+1)), 2);
        String subDay = OrderNumberGenerator.substringLast(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), 2);
        Random random = new Random();
        String subRandom = OrderNumberGenerator.substringLast(String.valueOf(random.nextInt()), 2);
        StringBuffer stringBuffer = new StringBuffer();
        switch (type) {
            case 1:
                stringBuffer.append('A');
                break;
            case 2:
                stringBuffer.append('B');
                break;
            default:
                stringBuffer.append('A');
        }
        stringBuffer.append(subYear).append(subMoth).append(subDay)
                .append(subTimestamp).append(subUser).append(subRandom);
        return stringBuffer.toString();

    }
}
