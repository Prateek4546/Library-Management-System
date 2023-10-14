package com.Optimus.studentlaibraymangment.controller;

import com.Optimus.studentlaibraymangment.DTO.responseDTO.IssueBookResponse;
import com.Optimus.studentlaibraymangment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @PostMapping("/issue/book-id/{book-id}/student-id/{student-id}")
    public ResponseEntity issueBook(@PathVariable("book-id") int bookId,
                                    @PathVariable("student-id") int studentId){
       try{
         IssueBookResponse response=  transactionService.issueBook( bookId ,  studentId);
         return new ResponseEntity(response , HttpStatus.CREATED);
       }
       catch (Exception e){
           return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
       }
    }
    // return book api
}
