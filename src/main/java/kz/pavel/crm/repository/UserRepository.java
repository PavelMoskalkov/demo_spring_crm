package kz.pavel.crm.repository;

import kz.pavel.crm.user.Role;
import kz.pavel.crm.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);

    void update(User user);
    void create(User user);
    void insertUserRole(Long userId, Role role);
    void delete(Long id);


}
