package com.harshith.chaosdemo.user_service.users.repo;

import com.harshith.chaosdemo.user_service.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
