package net.dining.springboot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.dining.springboot.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}