package com.lesliefish.webdemo.repository;

import com.lesliefish.webdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUserName(String userName);

    public User findByUserNameOrEmail(String userName, String email);

    public List<User> findAll();
}
