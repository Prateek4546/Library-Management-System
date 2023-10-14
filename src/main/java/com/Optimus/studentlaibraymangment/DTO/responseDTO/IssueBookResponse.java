package com.Optimus.studentlaibraymangment.DTO.responseDTO;

import com.Optimus.studentlaibraymangment.Enum.TransactionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssueBookResponse {
    String transactionNumber;
    Date transactionTime;
    TransactionStatus transactionStatus;
    String bookName;
    String authorName;
    String studentName;
    String libraryCardNumber;
}
