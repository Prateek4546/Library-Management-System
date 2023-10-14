package com.Optimus.studentlaibraymangment.repository;

import com.Optimus.studentlaibraymangment.Enum.Gener;
import com.Optimus.studentlaibraymangment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

  //  @Query(value = "select * from book where genre = :genre and cost > :cost",nativeQuery = true)
    @Query(value = "select * from book where gener = :gener and cost > :cost" , nativeQuery = true)
   List<Book> getBooksGenerandCostGreaterThan(String gener , double cost);
}
