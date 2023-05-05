package ru.dkovkov.pp_3_1_2_sptingboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dkovkov.pp_3_1_2_sptingboot.model.User;
import ru.dkovkov.pp_3_1_2_sptingboot.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUser() {
        System.out.println("список пользователей");
        System.out.println(userRepository.findAll().toString());
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUser(int id) {
        return userRepository.findById(id).orElseThrow(null);
    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {
        user.setId(id);
        userRepository.saveAndFlush(user);
    }
}
