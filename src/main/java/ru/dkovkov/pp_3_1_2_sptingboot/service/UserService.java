package ru.dkovkov.pp_3_1_2_sptingboot.service;

import ru.dkovkov.pp_3_1_2_sptingboot.model.User;

import java.util.List;

public interface UserService {
    List<User> listUser();
    void saveUser(User user);
    void deleteUser(Integer id);
    User findUser(int id);
    void updateUser(int id, User user);
}
