package com.bakuvi.spring.rest.exception_handling;

public class EmployeeIncorrectData {
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public EmployeeIncorrectData() {
    }

    public EmployeeIncorrectData(String info) {
        this.info = info;
    }
}
