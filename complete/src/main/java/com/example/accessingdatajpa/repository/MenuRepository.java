package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.model.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MenuRepository extends CrudRepository<Menu,Long> {
    List<Menu> findByDescription(String description);

    Optional<Menu> findById(Long id);
}
