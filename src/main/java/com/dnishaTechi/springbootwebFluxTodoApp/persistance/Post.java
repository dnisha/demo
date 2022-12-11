package com.dnishaTechi.springbootwebFluxTodoApp.persistance;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("post")
public record Post(@Id @Column("uuid") UUID uuid,
                   @Column("content") String content) {
}