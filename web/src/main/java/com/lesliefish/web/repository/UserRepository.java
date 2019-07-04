package com.lesliefish.web.repository;

import com.lesliefish.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository {

    User findByUserName(String name);

    User findByUserNameOrEmail(String name, String email);
}
