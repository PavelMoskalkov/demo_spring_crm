package kz.pavel.crm.user;

import java.util.Set;

public class User {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String passwordConfirmation;
    private Set<Role> roles;

}
