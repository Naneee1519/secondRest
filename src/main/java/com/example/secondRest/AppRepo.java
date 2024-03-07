package com.example.secondRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppRepo extends JpaRepository<AppEntity,Long> {

    List<AppEntity> findAll();

}
