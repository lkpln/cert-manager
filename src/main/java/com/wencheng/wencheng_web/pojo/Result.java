package com.wencheng.wencheng_web.pojo;

public class Result {
    private  Integer  code;
    private  String message;
    private  Object data;
    private  Boolean  flag;


    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message, Object data, Boolean flag) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.flag = flag;
    }

    public Result(Integer code, Boolean flag) {
        this.code = code;
        this.flag = flag;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public  Result(){

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", flag=" + flag +
                '}';
    }
}
