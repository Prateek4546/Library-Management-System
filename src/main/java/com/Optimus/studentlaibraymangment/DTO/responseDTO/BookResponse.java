package com.Optimus.studentlaibraymangment.DTO.responseDTO;

import com.Optimus.studentlaibraymangment.Enum.Gener;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =  AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    String title;

    int noOfPages;

    Gener gener;

    double cost;

    String authorName;

}
