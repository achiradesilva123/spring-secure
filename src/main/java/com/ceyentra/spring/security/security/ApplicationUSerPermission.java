package com.ceyentra.spring.security.security;

public enum ApplicationUSerPermission {

    STUDENT_READ("student : read"),
    STUDENT_WRITE("student : write"),
    COURSE_READ("course : read"),
    COURSE_WRITE("course : write");

    private final String Permission;

    ApplicationUSerPermission(String permission) {
        Permission = permission;
    }

    public String getPermission() {
        return Permission;
    }
}
