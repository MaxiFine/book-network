package com.alibou.book.roleperms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(
            Permissions.ADMIN_READ,
            Permissions.ADMIN_DELETE,
            Permissions.ADMIN_UPDATE,
            Permissions.ADMIN_CREATE,
            Permissions.MANAGER_CREATE,
            Permissions.MANAGER_DELETE,
            Permissions.MANAGER_READ,
            Permissions.MANAGER_UPDATE,
            Permissions.USER_READ,
            Permissions.USER_CREATE,
            Permissions.USER_DELETE,
            Permissions.USER_UPDATE
    )),

    USER(Set.of(
            Permissions.USER_READ,
            Permissions.USER_CREATE,
            Permissions.USER_DELETE,
            Permissions.USER_UPDATE
    )),
    MANAGER(Set.of(
            Permissions.MANAGER_CREATE,
            Permissions.MANAGER_DELETE,
            Permissions.MANAGER_UPDATE,
            Permissions.MANAGER_READ));


    @Getter
    private final Set<Permissions> permissionsset;  // to keep only one set of appearance

    public List<SimpleGrantedAuthority> getAuthorities(){
       var authorities = getPermissionsset().stream()
                .map(permissions ->
                        new SimpleGrantedAuthority(permissions.getPermissions()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
