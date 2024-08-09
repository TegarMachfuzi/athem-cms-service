package com.athem.cms.service.cms_service.utils;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class RestUtil {

    public static String toJson(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
