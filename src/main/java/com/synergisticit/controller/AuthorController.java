package com.synergisticit.controller;

import com.synergisticit.dao.AuthorDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private AuthorDao dao;

    public AuthorController(AuthorDao dao) {
        this.dao = dao;
    }

    @GetMapping("/api/author")
    public ResponseEntity<?> getAuthors() {
        return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
    }
}
