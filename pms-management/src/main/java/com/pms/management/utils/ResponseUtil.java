/*
 * 
 */
package com.pms.management.utils;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
 
/**
 * The Class ResponseUtil.
 */

public class ResponseUtil {
 
    ResponseUtil() {
    }
 
    /**
     * Gets the response.
     *
     * @param statusCode the status code
     * @param message    the message
     * @param result     the result
     * @return the response
     */
    public static ResponseEntity<ApiResponse> getResponse(final HttpStatus statusCode, final String message,
            final Object result) {
 
        return ResponseEntity.ok().body(new ApiResponse(statusCode.value(), message, result));
    }

    public static ResponseEntity<ApiResponse> getResponse(final HttpStatus statusCode, final String message) {
 
        return getResponse(statusCode,message,null);
    }
 
    public static ResponseEntity<ApiResponse> getResponse(final int responseCode, final String message,
            final Object result) {
 
        return ResponseEntity.ok().body(new ApiResponse(responseCode, message, result));
    }
 
}