package com.Optimus.studentlaibraymangment.DTO.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorResponse {
    int id;
    String name;
    String email;
    Date time;
    List<BookResponse> bookResponsesList = new ArrayList<>();
}
