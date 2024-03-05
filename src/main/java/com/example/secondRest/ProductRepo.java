package com.example.secondRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository <ProductEntity, Long> {
   // @Override
//    <S extends ProductEntity> S save(S entity);

    @Override
    <S extends ProductEntity> List<S> saveAll(Iterable<S> entities);
}
