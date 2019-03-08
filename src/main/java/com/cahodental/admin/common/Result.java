package com.cahodental.admin.common;

/*
 * Created by renhongjiang on 2019/3/8.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author plumre
 * @version 1.0
 * @date 2019/3/8 10:27
 */
public class Result<T> {

    private T data;
    private Integer status;
    private String message;
    private String messageDate;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate() {
        this.messageDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", messageDate='" + messageDate + '\'' +
                '}';
    }
}