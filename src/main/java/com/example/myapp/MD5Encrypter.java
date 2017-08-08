package com.example.myapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypter {

    public static String encrypt(String toEncrypt) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "no md5";
        }
        md.update(toEncrypt.getBytes());
        byte byteData[] = md.digest();
        //convert the byte to hex format
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        String encodedPassword = sb.toString();
        return encodedPassword;
    }
}
