package com.wencheng.wencheng_web.pojo;

public class Config {
    private  Integer id;
    private  String cron;


    public  Config(){

    }
    public Config(Integer id, String cron) {
        this.id = id;
        this.cron = cron;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", cron='" + cron + '\'' +
                '}';
    }
}
