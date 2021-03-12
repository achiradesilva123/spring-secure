package com.ceyentra.spring.security.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.ceyentra.spring.security.security.ApplicationUSerPermission.*;

public enum ApplictaionUserRole {

    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_WRITE, STUDENT_READ)),
    ADMINTRANEE(Sets.newHashSet(COURSE_READ,STUDENT_READ));

    private final Set<ApplicationUSerPermission> permissions;

    ApplictaionUserRole(Set<ApplicationUSerPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUSerPermission> getPermissions() {
        return permissions;
    }
}
