package com.example.shoppingmall.repository;

import com.example.shoppingmall.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Boolean existsByEmail(String email);

    Users findUsersByEmail(String email);

    Users findByUid(String uid);
}
