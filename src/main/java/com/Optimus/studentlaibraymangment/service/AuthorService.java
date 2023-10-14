package com.Optimus.studentlaibraymangment.service;

import com.Optimus.studentlaibraymangment.entity.Author;
import com.Optimus.studentlaibraymangment.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    public  String addAuthor(Author author){
         Author savedAuthor = authorRepo.save(author);
        return "Author saved!";
    }
}
