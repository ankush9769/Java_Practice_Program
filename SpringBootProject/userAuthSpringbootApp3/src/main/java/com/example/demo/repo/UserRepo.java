package com.example.demo.repo;

import com.example.demo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {

    public Users findByEmailAndPassword(String name,String password);
}
