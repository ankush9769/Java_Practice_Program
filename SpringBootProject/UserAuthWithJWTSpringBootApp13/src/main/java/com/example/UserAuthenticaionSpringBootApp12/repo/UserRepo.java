package com.example.UserAuthenticaionSpringBootApp12.repo;

import com.example.UserAuthenticaionSpringBootApp12.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserAuth,Long> {
    public Optional<UserAuth> findByEmailIgnoreCase(String email);
    public List<UserAuth> findByRole(String role);

}
