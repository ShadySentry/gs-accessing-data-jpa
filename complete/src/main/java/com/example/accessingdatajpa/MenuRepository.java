package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu,Long> {
    List<Menu> findByDescription(String description);

    Optional<Menu> findById(Long id);
}
