package com.mooc.common;

import java.io.UnsupportedEncodingException;

/**
 * Created by Maple on 2017/2/16.
 */
public class ChangeCode {
    public ChangeCode() {super();}

    public static String toUTF8(String param){

        String c_param = null;
        try {
            c_param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return c_param;
    }
}
