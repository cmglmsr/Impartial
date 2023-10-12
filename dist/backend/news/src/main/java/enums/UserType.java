package enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserType implements GrantedAuthority {
    ROLE_USER,
    ROLE_VISITOR,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
