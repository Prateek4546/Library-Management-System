package com.Optimus.studentlaibraymangment.entity;

import com.Optimus.studentlaibraymangment.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Student {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     int regId;
     String name;
     @Enumerated
     Gender gender;

     int age;

     String email;
     @OneToOne(mappedBy = "student" , cascade = CascadeType.ALL)
     LibraryCard libraryCard;
}
