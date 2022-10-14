package com.application.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.admin.model.User;

@Repository
public interface UserRepositary extends JpaRepository<User, Integer> {

}
