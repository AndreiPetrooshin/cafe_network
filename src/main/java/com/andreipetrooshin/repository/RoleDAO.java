package com.andreipetrooshin.repository;


import com.andreipetrooshin.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleDAO extends JpaRepository<Role, Long> {
}
