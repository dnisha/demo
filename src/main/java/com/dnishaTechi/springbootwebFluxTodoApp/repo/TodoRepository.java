package com.dnishaTechi.springbootwebFluxTodoApp.repo;

import com.dnishaTechi.springbootwebFluxTodoApp.persistance.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface TodoRepository extends ReactiveCrudRepository<Post, UUID> {
}
