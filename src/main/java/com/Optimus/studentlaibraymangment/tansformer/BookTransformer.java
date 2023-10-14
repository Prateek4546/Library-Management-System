package com.Optimus.studentlaibraymangment.tansformer;

import com.Optimus.studentlaibraymangment.DTO.responseDTO.BookResponse;
import com.Optimus.studentlaibraymangment.entity.Book;

public class BookTransformer {

    public static BookResponse BookToBookResponse(Book book){

        return BookResponse.builder()
                .title(book.getTitle())
                .cost(book.getCost())
                .gener(book.getGener())
                .noOfPages(book.getNoOfPages())
                .authorName(book.getAuthor().getName())
                .build();

    }
}
