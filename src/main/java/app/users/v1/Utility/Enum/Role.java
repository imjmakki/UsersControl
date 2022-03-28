package app.users.v1.Utility.Enum;

import static app.users.v1.Utility.Constant.Authority.*;

public enum Role {
    USER(USER_AUTHORITIES),
    ISSUER(ISSUER_AUTHORITIES),
    MANAGER(MANAGER_AUTHORITIES),
    ADMIN(ADMIN_AUTHORITIES);

    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}
