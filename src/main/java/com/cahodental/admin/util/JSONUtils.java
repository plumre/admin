package com.cahodental.admin.util;

/*
 * Created by renhongjiang on 2019/3/8.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.cahodental.admin.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * JSON字符串工具类
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/3/8 10:58
 */
public class JSONUtils {

    public static final Logger logger = LoggerFactory.getLogger(JSONUtils.class);

    private static ValueFilter valueFilter;

    private static ValueFilter valueFilterReplaceEmpty;

    private static SerializerFeature[] features;

    static {

        // 初始化全局日期格式：yyyy-MM-dd HH:mm:ss
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

        valueFilter = (object, name, value) -> {
            if (value == null) {
                return "";
            }
            return value;
        };

        valueFilterReplaceEmpty = (object, name, value) -> {
            // 如果该字段不为null;直接返回
            if (value != null) {
                return value;
            }

            Class<? extends Object> clazz = object.getClass();

            try {
                Method method = clazz.getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1), null);
                Class<?> klass = method.getReturnType();
                // 如果这个字节码对象是一个数组，则返回空的数组
                if (klass == String.class) {
                    return "";
                }
                // 如果这个字段的字节码对象是Collection或是其子接口,则返回空的list,序列化时会返回[]
                if (Collection.class.isAssignableFrom(klass)) {
                    return new ArrayList();
                }
                // 如果这个字段的字节码对象是 Map或是其子接口,则返回空的map,序列化时会返回{}
                if (Map.class.isAssignableFrom(klass)) {
                    return new HashMap();
                }
                // 如果这个字节码对象是一个数组，则返回空的数组
                if (klass.isArray()) {
                    return new String[0];
                }
                // 如果这个字节码对象是一个数组，则返回空的数组
                if (klass == BigDecimal.class) {
                    return new BigDecimal(0.00);
                }

                return "";

            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                e.printStackTrace();
            }
            // 既不是 Collection 也不是 Map,则一律返回"",包括Date类型,已经与张松约定
            return "";
        };

        features = new SerializerFeature[]{
//			SerializerFeature.WriteNullListAsEmpty,
//			SerializerFeature.WriteMapNullValue,
                //禁止循环引用检查
                SerializerFeature.DisableCircularReferenceDetect,
                //使用全局的日期转换器，在JSON这个类初始化时已经赋值
                SerializerFeature.WriteDateUseDateFormat
        };
    }

    public static JSON replaceNullAsEmptyToJsonObject(Object o) {
        String jsonString = JSONObject.toJSONString(o, valueFilter);
        if (jsonString.startsWith("{")) {
            return JSONObject.parseObject(jsonString);
        }
        if (jsonString.startsWith("[")) {
            return JSONArray.parseArray(jsonString);
        }
        return null;
    }


    public static void responseJson(HttpServletResponse response, Result result) throws Exception {
        response.setContentType("text/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        String jsonString = JSON.toJSONString(result, valueFilterReplaceEmpty, features);
        out.println(jsonString);
    }

}