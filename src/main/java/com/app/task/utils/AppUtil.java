package com.app.task.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtil {
    public static String getRawFormat(Date d){
        return new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z").format(d);
    }
    public static String getReadableFormat(Date d){
        return new SimpleDateFormat("dd MMMM yyy").format(d);
    }
}
