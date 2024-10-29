package com.springmvc.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtils {

    public static String toJson(Object obj) throws JsonProcessingException {
        return toJson(obj, "yyyy-MM-dd HH:mm:ss");
    }

    public static String toJson(Object obj, String format) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        mapper.setDateFormat(sdf);
        return mapper.writeValueAsString(obj);
    }

}
