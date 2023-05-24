package com.example.homeworkspringboot.Service;


import com.example.homeworkspringboot.ApiException.ApiException;
import com.example.homeworkspringboot.Model.User;
import com.example.homeworkspringboot.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUsers(User user){
        return userRepository.save(user);
    }

    public boolean updateUsers(Integer id , User user) {
        User oldUser = userRepository.getById(id);
        if( oldUser == null) {
            return false;
        }
        oldUser.setAge(user.getAge());
        oldUser.setName(user.getName());
        oldUser.setRole(user.getRole());
        oldUser.setEmail(user.getEmail());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        userRepository.save(oldUser);
        return true;
    }

    public boolean deleteUser (Integer id){
        User deletedUser = userRepository.getById(id);
        if (deletedUser == null){
            return false;
        }
        userRepository.delete(deletedUser);
        return true;
    }
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<User> findUserByRole(String role){
        List<User>users=userRepository.findUserByRole(role);
        return users;
    }


    public List<User> findAllByAge(Integer age) {
        List<User> users=userRepository.findAllByAge(age);
        return users;
    }

    public User findAllByEmailAndPassword(String username, String password){
        User user=userRepository.findAllByEmailAndPassword(username,password);
        if(user==null)
        {
            throw new ApiException("User, Password Not there, Please Try Again");
        }
        return user;
    }
    public User JPQL(String email){
        User user=userRepository.findUserByEmail(email);
        if(email==null){
            throw new ApiException("Email Not there, Please Try Again");
        }
        return user;
    }




}
