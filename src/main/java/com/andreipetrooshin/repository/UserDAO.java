package com.andreipetrooshin.repository;

import com.andreipetrooshin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
