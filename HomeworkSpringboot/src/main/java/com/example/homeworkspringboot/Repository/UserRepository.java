package com.example.homeworkspringboot.Repository;

import com.example.homeworkspringboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    //get all user by them age
    List<User> findAllByAge(Integer age);

    // get  user by email
    User findUserByEmail(String email);

    /// Check if the username and password are correct
    User findAllByEmailAndPassword(String email, String password);

    //Get All users with specific role
    List<User> findUserByRole(String role);

    //find user by email byJPQL
    @Query("select x from User x where x.email=?1")
    User JPQL(String email);
}
