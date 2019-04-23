package com.leone.pay.common.exception;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author leone
 * @since 2018-08-09
 **/
@Component
public class GlobalErrorAttributes implements ErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = new LinkedHashMap<>();

        Integer status = getAttribute(webRequest, "javax.servlet.error.status_code");
        if (status == null) {
            errorAttributes.put("code", 40000);
            errorAttributes.put("message", "None");
        } else {
            errorAttributes.put("code", status);
            errorAttributes.put("message", getDetail(status));
        }
        return errorAttributes;
    }

    @Override
    public Throwable getError(WebRequest webRequest) {
        return getAttribute(webRequest, "javax.servlet.error.exception");
    }


    private String getDetail(Integer status) {
        try {
            return HttpStatus.valueOf(status).getReasonPhrase();
        } catch (Exception e) {
            return status.toString();
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T getAttribute(RequestAttributes requestAttributes, String name) {
        return (T) requestAttributes.getAttribute(name, RequestAttributes.SCOPE_REQUEST);
    }

}
