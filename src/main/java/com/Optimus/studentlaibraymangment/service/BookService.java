package com.Optimus.studentlaibraymangment.service;

import com.Optimus.studentlaibraymangment.DTO.responseDTO.BookResponse;
import com.Optimus.studentlaibraymangment.entity.Author;
import com.Optimus.studentlaibraymangment.entity.Book;
import com.Optimus.studentlaibraymangment.exception.AuthorNotFoundException;
import com.Optimus.studentlaibraymangment.repository.AuthorRepo;
import com.Optimus.studentlaibraymangment.repository.BookRepo;
import com.Optimus.studentlaibraymangment.tansformer.BookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;
    @Autowired
    AuthorRepo authorRepo;
    public String addBook(Book book) {

        Optional<Author> author = authorRepo.findById(book.getAuthor().getId());
          if(author.isEmpty()){
             throw new AuthorNotFoundException("Author is not present By Given ID!!!");
          }
          else{
              Author currAuthor = author.get();
              book.setAuthor(currAuthor);
              currAuthor.getBook().add(book);
             // bookRepo.save(book);
              authorRepo.save(currAuthor);
          }

     return "Book Save SucessFully";
    }

    public List<BookResponse> getBooksGenerandCostGreaterThan(String gener, double cost) {
        List<Book> books = bookRepo.getBooksGenerandCostGreaterThan(gener , cost);

        List<BookResponse> response = new ArrayList<>();
        for(Book book: books){
          BookResponse bookResponse = BookTransformer.BookToBookResponse(book);
          response.add(bookResponse);
        }
        return response;
    }
}
