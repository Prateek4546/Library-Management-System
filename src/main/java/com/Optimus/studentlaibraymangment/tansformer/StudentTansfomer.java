package com.Optimus.studentlaibraymangment.tansformer;

import com.Optimus.studentlaibraymangment.DTO.requestDTO.StudentRequest;
import com.Optimus.studentlaibraymangment.DTO.responseDTO.LibraryCardResponse;
import com.Optimus.studentlaibraymangment.DTO.responseDTO.StudentResponse;
import com.Optimus.studentlaibraymangment.entity.Student;

import java.util.ArrayList;
import java.util.List;

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
    public static List<StudentResponse> entityListToResponse(List<Student> studentList){
        List<StudentResponse> responses = new ArrayList<>();
        for(Student s : studentList){
            LibraryCardResponse libraryCardResponse = LibraryCardResponse.builder()
                    .cardNo(s.getLibraryCard().getCardNo())
                    .cardStatus(s.getLibraryCard().getCardStatus())
                    .issueDate(s.getLibraryCard().getIssueDate())
                    .build();
            StudentResponse studentResponse = StudentResponse.builder()
                    .name(s.getName())
                    .email(s.getEmail())
                    .libraryCardResponse(libraryCardResponse)
                    .build();
            responses.add(studentResponse);
        }
        return responses;
    }
}
