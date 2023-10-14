package com.Optimus.studentlaibraymangment.DTO.requestDTO;


import com.Optimus.studentlaibraymangment.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    String name;

    int age;

    String email;

    Gender gender;
}
