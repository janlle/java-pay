package com.andy.pay.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

import java.io.IOException;

/**
 * json转换工具类，jackson
 */
public final class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonUtils() {
    }

    /**
     * 根据对象生成json,支持map，list，bean对象
     *
     * @param object JavaBean对象
     * @return json字符串
     * @throws RuntimeException
     */
    public static String toJson(Object object) {
        try {
            MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
            return MAPPER.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String toJsonNotNull(Object object) {
        try {
            MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return MAPPER.writeValueAsString(object);
        } catch (IOException e) {
            //throw new IllegalStateException();
            e.printStackTrace();
            return "";
        }
    }

    /**
     * jsonString转化为java对象
     *
     * @param jsonString 原始json字符串数据
     * @param clazz      要转换的JavaBean类型
     * @return JavaBean对象
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        if (Strings.isNullOrEmpty(jsonString)) {
            return null;
        }
        try {
            return MAPPER.readValue(jsonString, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
