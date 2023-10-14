package com.Optimus.studentlaibraymangment.DTO.responseDTO;

import com.Optimus.studentlaibraymangment.Enum.CardStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryCardResponse {
    String cardNo;

    CardStatus cardStatus;

    Date issueDate;
}
