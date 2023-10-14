package com.Optimus.studentlaibraymangment.controller;


import com.Optimus.studentlaibraymangment.DTO.responseDTO.BookResponse;
import com.Optimus.studentlaibraymangment.entity.Book;
import com.Optimus.studentlaibraymangment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody Book book){
        String response = bookService.addBook(book);
        return new ResponseEntity(response , HttpStatus.CREATED);
    }

    @GetMapping("/get-by-gener-cost")
    public List<BookResponse> getBooksGenerandCostGreaterThan(@RequestParam("gener") String gener ,
                                                              @RequestParam("cost") double cost){
          return bookService.getBooksGenerandCostGreaterThan(gener , cost);
    }
}
