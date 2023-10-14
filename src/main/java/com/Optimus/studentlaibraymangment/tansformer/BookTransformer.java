package com.Optimus.studentlaibraymangment.tansformer;

import com.Optimus.studentlaibraymangment.DTO.responseDTO.BookResponse;
import com.Optimus.studentlaibraymangment.entity.Book;

import java.util.ArrayList;
import java.util.List;

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
    public static List<BookResponse> EntityListToDTOList(List<Book> books){
        List<BookResponse> bookResponseList = new ArrayList<>();
        for(Book book : books){
            BookResponse bookResponse = BookToBookResponse(book);
            bookResponseList.add(bookResponse);
        }
        return bookResponseList;
    }
}
