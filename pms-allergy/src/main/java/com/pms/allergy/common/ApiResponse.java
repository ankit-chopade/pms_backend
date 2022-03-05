package com.pms.allergy.common;


import java.io.Serializable;
 
/**
 * The ApiResponse.
 *
 * @version 1.0
 * @created 2019/07/26 15:15:38
 */
public class ApiResponse implements Serializable {
 
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The status. */
    private int status;

    /** The message. */
    private String message;

    /** The data. */
    private transient Object data;
 
    /**
     * Instantiates a new api response.
     *
     * @param status the status
     * @param message the message
     * @param data the data
     */
    public ApiResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
 
    /**
     * Gets the status.
     *
     * @return the status
     */
    public int getStatus() {
        return status;
    }
 
    /**
     * Sets the status.
     *
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
 
    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }
 
    /**
     * Sets the message.
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
 
    /**
     * Gets the result.
     *
     * @return the result
     */
    public Object getResult() {
        return data;
    }
 
    /**
     * Sets the result.
     *
     * @param result the result to set
     */
    public void setResult(Object result) {
        this.data = result;
    }
 
}