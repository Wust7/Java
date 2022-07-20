package com.wust.spring5.collectiontype;

public class Course {
    private String ename;

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ename='" + ename + '\'' +
                '}';
    }
}
