package com.example.secondRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
    @Override
    <S extends UserEntity> S save(S entity);
}
