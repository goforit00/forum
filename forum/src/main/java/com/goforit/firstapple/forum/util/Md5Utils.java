package com.goforit.firstapple.forum.util;

import org.springframework.util.DigestUtils;

public class Md5Utils {

    
    public static String encrypt(String key, String plaintext){
        String data = key + plaintext;
        return DigestUtils.md5DigestAsHex(data.getBytes());
    }
    
    
}
