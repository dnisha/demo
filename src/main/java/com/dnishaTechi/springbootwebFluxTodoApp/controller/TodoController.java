package com.dnishaTechi.springbootwebFluxTodoApp.controller;

import com.dnishaTechi.springbootwebFluxTodoApp.model.PostRequest;
import com.dnishaTechi.springbootwebFluxTodoApp.persistance.Post;
import com.dnishaTechi.springbootwebFluxTodoApp.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
c@CrossOrigin(origins = "*")
@RequestMapping("/v1/todo")
public class TodoController {
    @Autowired
    TodoRepository repository;
    @GetMapping("/health")
    public Mono<String> health() {
        return Mono.just("Hello from service");
    }
    @PostMapping("/posts")
    public Mono<Post> createPost(@RequestBody PostRequest postRequest) {
        return repository.save(new Post(null, postRequest.getContent()))
                .log();
    }
    @GetMapping("/allPost")
    public Flux<Post> allPost() {
        return repository.findAll()
                .log();
    }
    @GetMapping("/post/{id}")
    public Mono<Void> deletePost(@PathVariable String id) {
        return repository.deleteById(UUID.fromString(id))
                .log();
    }
    @PutMapping("/post/{id}")
    public Mono<Post> updatePost(@PathVariable String id, @RequestBody PostRequest postRequest) {
        return repository.findById(UUID.fromString(id))
                .map(post -> new Post(post.uuid(), postRequest.getContent()))
                .log()
                .flatMap(post -> repository.save(post));
    }
}
