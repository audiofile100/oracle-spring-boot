package com.synergisticit.dao;

import com.synergisticit.domain.Author;

import java.util.List;

public interface AuthorDao {

    List<Author> findAll();
}
