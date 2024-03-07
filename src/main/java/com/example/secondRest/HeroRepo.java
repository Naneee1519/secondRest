package com.example.secondRest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroRepo extends JpaRepository<HeroEntity,Long> {
    List<HeroEntity> findAll();

}
