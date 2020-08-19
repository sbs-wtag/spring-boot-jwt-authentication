package com.practice.jwt.jwtauthentication.repository;

import com.practice.jwt.jwtauthentication.model.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

  Optional<Users> findByUsername(String username);
}
