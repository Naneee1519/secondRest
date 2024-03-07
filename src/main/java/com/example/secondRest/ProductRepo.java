package com.example.secondRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface   ProductRepo  extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findAll();
}
