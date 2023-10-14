package com.Optimus.studentlaibraymangment.service;

import com.Optimus.studentlaibraymangment.DTO.responseDTO.AuthorResponse;
import com.Optimus.studentlaibraymangment.entity.Author;
import com.Optimus.studentlaibraymangment.repository.AuthorRepo;
import com.Optimus.studentlaibraymangment.tansformer.AuthorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    public AuthorResponse addAuthor(Author author){
         AuthorResponse response = AuthorTransformer.entitytoDTO(authorRepo.save(author));
        return response;
    }

    public List<AuthorResponse> getAllAuthor(){
        List<AuthorResponse> response = AuthorTransformer.EntityListToDTO(authorRepo.findAll());
        return response;
    }
}
