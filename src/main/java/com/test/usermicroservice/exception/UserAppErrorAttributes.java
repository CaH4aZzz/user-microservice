package com.test.usermicroservice.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class UserAppErrorAttributes extends DefaultErrorAttributes {

    private final String currentApiVersion;

    public UserAppErrorAttributes(String currentApiVersion) {
        this.currentApiVersion = currentApiVersion;
    }

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        final Map<String, Object> defaultErrorAttributes = super.getErrorAttributes(webRequest, false);
        final AppError appError = AppError.fromDefaultAttributeMap(
                currentApiVersion, defaultErrorAttributes
        );

        return appError.toAttributeMap();
    }
}