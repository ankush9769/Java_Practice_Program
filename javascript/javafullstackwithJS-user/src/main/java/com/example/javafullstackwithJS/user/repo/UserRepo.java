package com.example.javafullstackwithJS.user.repo;

import com.example.javafullstackwithJS.user.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
}
