package com.Optimus.studentlaibraymangment.tansformer;

import com.Optimus.studentlaibraymangment.DTO.responseDTO.AuthorResponse;
import com.Optimus.studentlaibraymangment.DTO.responseDTO.BookResponse;
import com.Optimus.studentlaibraymangment.entity.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorTransformer {

    public static AuthorResponse entitytoDTO(Author author){
       return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .email(author.getEmail())
                .time(author.getLastActivity())
                .bookResponsesList(BookTransformer.EntityListToDTOList(author.getBook()))
                .build();
    }
    public static List<AuthorResponse> EntityListToDTO(List<Author> authors){
        List<AuthorResponse> authorResponseList = new ArrayList<>();
        for(Author author : authors){
            AuthorResponse authorResponse = entitytoDTO(author);
            authorResponseList.add(authorResponse);
        }
        return authorResponseList;
    }

}
