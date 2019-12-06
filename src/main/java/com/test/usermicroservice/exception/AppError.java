package com.test.usermicroservice.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AppError {
    private final String currentApiVersion;
    private final ErrorBlock error;

    public AppError(String currentApiVersion, String code, String message, String domain,
                    String reason, String errorMessage) {
        this.currentApiVersion = currentApiVersion;
        this.error = new ErrorBlock(code, message, domain, reason, errorMessage);
    }

    public static AppError fromDefaultAttributeMap(String apiVersion, Map<String, Object> defaultErrorAttributes) {
        return new AppError(
                apiVersion,
                defaultErrorAttributes.get("status").toString(),
                (String) defaultErrorAttributes.getOrDefault("message", "no message available"),
                (String) defaultErrorAttributes.getOrDefault("path", "no domain available"),
                (String) defaultErrorAttributes.getOrDefault("error", "no reason available"),
                (String) defaultErrorAttributes.get("message")
        );
    }

    public Map<String, Object> toAttributeMap() {

        Map map = new HashMap();
        map.put("apiVersion", currentApiVersion);
        map.put("error", error);
        return map;
    }

    @Getter
    private class ErrorBlock {

        private final String code;
        private final String message;
        private final List<Error> errors;

        public ErrorBlock(String code, String message, String domain,
                          String reason, String errorMessage) {
            this.code = code;
            this.message = message;
            this.errors = Arrays.asList(
                    new Error(domain, reason, errorMessage)
            );
        }
    }

    @Getter
    static final class Error {
        private final String domain;
        private final String reason;
        private final String message;

        public Error(String domain, String reason, String message) {
            this.domain = domain;
            this.reason = reason;
            this.message = message;
        }
    }
}
