package com.smartkid.domainlayer;

import java.util.regex.Pattern;

public class Common {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static int isNullOrEmpty(String... strings){
        for(int i = 0; i < strings.length; i++){
            if(strings[i] == null || strings[i].isEmpty()){
                return i;
            }
        }
        return -1;
    }
}
