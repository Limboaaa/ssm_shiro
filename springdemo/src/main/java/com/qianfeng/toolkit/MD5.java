package com.qianfeng.toolkit;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {

    public  static String encodePassword(String password){
        String md5Hex = DigestUtils.md5Hex(password);
        for (int i = 0;i<10;i++){
            md5Hex = DigestUtils.md5Hex(md5Hex.substring(15));
        }
        return md5Hex;
    }
}
