package com.Optimus.studentlaibraymangment.tansformer;

import com.Optimus.studentlaibraymangment.DTO.requestDTO.StudentRequest;
import com.Optimus.studentlaibraymangment.DTO.responseDTO.LibraryCardResponse;
import com.Optimus.studentlaibraymangment.DTO.responseDTO.StudentResponse;
import com.Optimus.studentlaibraymangment.entity.Student;

public class StudentTansfomer {


    public static Student StudentRequestToStudent(StudentRequest studentRequest){
        return Student.builder()
                 .name(studentRequest.getName())
                 .age(studentRequest.getAge())
                 .email(studentRequest.getEmail())
                 .gender(studentRequest.getGender())
                 .build();
    }
    public  static StudentResponse StudentToStudentResponse(Student student){
        LibraryCardResponse libraryCardResponse = LibraryCardResponse.builder()
                .cardNo(student.getLibraryCard().getCardNo())
                .cardStatus(student.getLibraryCard().getCardStatus())
                .issueDate(student.getLibraryCard().getIssueDate())
                .build();

       return StudentResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .libraryCardResponse(libraryCardResponse)
                .build();
    }
}
