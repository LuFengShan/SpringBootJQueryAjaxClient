package com.javasampleapproach.jqueryajax.message;

/**
 * 响应消息
 */
public class Response {
    /**
     * 状态
     */
    private String status;
    /**
     * 数据
     */
    private Object data;

    public Response() {

    }

    public Response(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
