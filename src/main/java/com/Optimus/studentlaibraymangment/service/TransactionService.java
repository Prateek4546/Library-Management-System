package com.Optimus.studentlaibraymangment.service;


import com.Optimus.studentlaibraymangment.DTO.responseDTO.IssueBookResponse;
import com.Optimus.studentlaibraymangment.Enum.TransactionStatus;
import com.Optimus.studentlaibraymangment.entity.Book;
import com.Optimus.studentlaibraymangment.entity.Student;
import com.Optimus.studentlaibraymangment.entity.Transaction;
import com.Optimus.studentlaibraymangment.exception.BookNotAvailableException;
import com.Optimus.studentlaibraymangment.exception.StudentNotFoundException;
import com.Optimus.studentlaibraymangment.repository.BookRepo;
import com.Optimus.studentlaibraymangment.repository.StudentRepo;
import com.Optimus.studentlaibraymangment.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    BookRepo bookRepo;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TransactionRepo transactionRepo;
    public IssueBookResponse issueBook(int bookId, int studentId) {
        Optional<Student> studentOptional =  studentRepo.findById(studentId);
        if(studentOptional.isEmpty()){
            throw new StudentNotFoundException("Invalid student id!!");
        }
        Optional<Book> optionalBook = bookRepo.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new BookNotAvailableException("Invalid Book Id");
        }
        Book book = optionalBook.get();
        if(book.isIssued()){
            throw new BookNotAvailableException("Book already issued");
        }
        Student student = studentOptional.get();

        // creat transaction
        Transaction transaction = Transaction.builder()
                .transactionNumber(String.valueOf(UUID.randomUUID()))
                .transactionStatus(TransactionStatus.SUCCESS)
                .book(book)
                .libraryCard(student.getLibraryCard())
                .build();
     Transaction savetransaction =  transactionRepo.save(transaction);
        // update book
        book.setIssued(true);
        book.getTransactionList().add(savetransaction);

        // card changes
        student.getLibraryCard().getTransactions().add(savetransaction);
        Book saveBook = bookRepo.save(book); // saving book and transaction
      Student savestudent =  studentRepo.save(student); // saving student and transaction

        // send an Email
        String Text = "Hi! "+student.getName()+"The below Book has been issued to you\n"+
                book.getTitle()+" \nThis is transaction number: "+savetransaction.getTransactionNumber();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(student.getEmail());
        simpleMailMessage.setFrom("springlearner84@gmail.com");
        simpleMailMessage.setSubject("Congrats !! Book Issued");
        simpleMailMessage.setText(Text);
        javaMailSender.send(simpleMailMessage);

        return IssueBookResponse.builder()
                .bookName(saveBook.getTitle())
                .transactionStatus(savetransaction.getTransactionStatus())
                .transactionTime(savetransaction.getTrancationTime())
                .transactionNumber(savetransaction.getTransactionNumber())
                .studentName(savestudent.getName())
                .authorName(saveBook.getAuthor().getName())
                .libraryCardNumber(savestudent.getLibraryCard().getCardNo())
                .build();
    }
}
