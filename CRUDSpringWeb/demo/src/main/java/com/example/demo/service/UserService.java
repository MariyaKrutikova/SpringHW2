package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    //Удаление пользователя по id
     public void deleteById(int id){
        userRepository.deleteById(id);
     }

//     public void updateUser(User user){
//        userRepository.update(user);
//     }
//    public User getUserById(int id){
//        return userRepository.getById(id);
//
//    }
}
