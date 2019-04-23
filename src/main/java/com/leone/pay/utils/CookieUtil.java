package com.leone.pay.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 操作cookie的工具类
 */
public class CookieUtil {

    public static void set(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }


    public static Cookie get(HttpServletRequest request, String name) {
        Map<String, Cookie> map = read(request);
        if (map.containsKey(name)) {
            return map.get(name);
        }
        return null;
    }

    private static Map<String, Cookie> read(HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();
        Map<String, Cookie> map = new HashMap<>();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                map.put(cookie.getName(), cookie);
            }
        }
        return map;
    }

}
