package com.example.domparsing;

public class model {
    private String Name;
    private String course;
    private String Mobile;

    public model() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    @Override
    public String toString() {
        return "model{" +
                "Name='" + Name + '\'' +
                ", course='" + course + '\'' +
                ", Mobile='" + Mobile + '\'' +
                '}';
    }
}
