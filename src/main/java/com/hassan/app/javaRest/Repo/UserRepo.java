package com.hassan.app.javaRest.Repo;
import com.hassan.app.javaRest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long>{
    Optional<User> findByEmailAddress(String emailAddress);
}
