package org.badcoding.dao.interfaces;

import org.badcoding.hibernate.stored.User;

import java.util.List;

public interface UserDAO {
    void addUser(User User);

    void updateUser(User User);

    void removeUser(User User);

    User getUserById(int id);

    List<User> listUsers();
}
