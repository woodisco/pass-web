package com.fastcampus.pass.passweb.repository.user;

import com.fastcampus.pass.passweb.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserId(String userId);
}
