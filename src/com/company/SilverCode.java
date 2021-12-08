package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SilverCode extends CodeGenerator{
    @Override
    public String makeCode(String id) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            return convertToString(md.digest(("Silver-"+id).getBytes()));
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return "";
    }
}
