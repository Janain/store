package com.click.store.bean;

import java.io.Serializable;

/**
 * @Author Wangjj
 * @Create 2018/2/12.
 * @Content
 */

public class BaseBean<T> implements Serializable {


    private static final int SUCCESS = 1;
    private int status;
    private String message;
    private T data;


    public boolean success() {
        return (status == SUCCESS);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
