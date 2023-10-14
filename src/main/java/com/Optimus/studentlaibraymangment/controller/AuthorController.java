package com.Optimus.studentlaibraymangment.controller;


import com.Optimus.studentlaibraymangment.DTO.responseDTO.AuthorResponse;
import com.Optimus.studentlaibraymangment.entity.Author;
import com.Optimus.studentlaibraymangment.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){
        AuthorResponse response = authorService.addAuthor(author);
        return new ResponseEntity(response , HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity getALlAuthor(){
        List<AuthorResponse> responseList = authorService.getAllAuthor();
        return new ResponseEntity(responseList , HttpStatus.OK);
    }
}
