package com.Optimus.studentlaibraymangment.service;

import com.Optimus.studentlaibraymangment.DTO.requestDTO.StudentRequest;
import com.Optimus.studentlaibraymangment.DTO.responseDTO.LibraryCardResponse;
import com.Optimus.studentlaibraymangment.DTO.responseDTO.StudentResponse;
import com.Optimus.studentlaibraymangment.Enum.Gender;

import com.Optimus.studentlaibraymangment.entity.LibraryCard;
import com.Optimus.studentlaibraymangment.entity.Student;
import com.Optimus.studentlaibraymangment.Enum.CardStatus;
import com.Optimus.studentlaibraymangment.exception.StudentNotFoundException;
import com.Optimus.studentlaibraymangment.repository.StudentRepo;
import com.Optimus.studentlaibraymangment.tansformer.LibraryCardTranformer;
import com.Optimus.studentlaibraymangment.tansformer.StudentTansfomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
           private StudentRepo  studentRepo;

           public StudentResponse addStudent(StudentRequest studentRequest){
               // converting student dto to Model
               Student student = StudentTansfomer.StudentRequestToStudent(studentRequest);

               LibraryCard card = LibraryCardTranformer.PreparingLibraryCard();
               card.setStudent(student);
               student.setLibraryCard(card);
               studentRepo.save(student);

               StudentResponse studentResponse = StudentTansfomer.StudentToStudentResponse(student);

                return studentResponse;
           }

           public  Student getStudent(int regNo){
               return studentRepo.getById(regNo);
           }

    public List<String> getAllMales()
    {
    List<String> names = new ArrayList<>();
    List<Student> students = studentRepo.findByGender(Gender.Male);
    for(Student s : students){
        names.add(s.getName());
    }
    return names;
    }
    public List<StudentResponse> getAllStudent(){
               List<StudentResponse> studentResponses = StudentTansfomer.entityListToResponse(studentRepo.findAll());
               return studentResponses;
    }
    public void deleteById(int id){
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if(optionalStudent.isEmpty()){
            throw new StudentNotFoundException("Invalid Student Id");
        }
        else{
            studentRepo.deleteById(id);
        }
    }
}
