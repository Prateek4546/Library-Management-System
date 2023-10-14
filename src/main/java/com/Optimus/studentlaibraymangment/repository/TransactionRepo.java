package com.Optimus.studentlaibraymangment.repository;

import com.Optimus.studentlaibraymangment.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction , Integer> {
}
