package com.jlgale.springboot_web.models.dto;

public class ParamDto {
    private String message;
    private Integer age;
    private String firstname;
    private String lasstname;
    private boolean aux;

    public ParamDto() {
    }

    public ParamDto(String message, Integer age, String firstname, String lasstname, boolean aux) {
        this.message = message;
        this.age = age;
        this.firstname = firstname;
        this.lasstname = lasstname;
        this.aux = aux;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLasstname() {
        return lasstname;
    }

    public void setLasstname(String lasstname) {
        this.lasstname = lasstname;
    }

    public boolean isAux() {
        return aux;
    }

    public void setAux(boolean aux) {
        this.aux = aux;
    }
}
