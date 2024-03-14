package com.example.secondRest;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface   ProductRepo  extends JpaRepository<ProductEntity,Long> {

    @Override
    List<ProductEntity> findAll();

    @Override
    <S extends ProductEntity> List<S> saveAll(Iterable<S> entities);

    @Override
    void deleteById(Long aLong);

    @Override
    Optional<ProductEntity> findById(Long aLong);

//    List<ProductEntity> findByCategoryId(Long categoryId);

}
