package com.example.secondRest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<CategoryEntity,Long> {

    @Override
    <S extends CategoryEntity> S save(S entity);

    List<CategoryEntity> findAll();

    void deleteById(Long aLong);
}
