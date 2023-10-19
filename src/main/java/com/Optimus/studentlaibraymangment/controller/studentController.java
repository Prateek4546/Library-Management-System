package com.Optimus.studentlaibraymangment.controller;

import com.Optimus.studentlaibraymangment.DTO.requestDTO.StudentRequest;
import com.Optimus.studentlaibraymangment.DTO.responseDTO.StudentResponse;
import com.Optimus.studentlaibraymangment.entity.Student;
import com.Optimus.studentlaibraymangment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {
    @Autowired
      private StudentService studentService;

    public studentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentRequest studentRequest){
        StudentResponse studentResponse = studentService.addStudent(studentRequest);
            return new ResponseEntity(studentResponse , HttpStatus.CREATED);
    }

    @GetMapping("/get-males")
    public List<String> getAllMales(){
        List<String> males = studentService.getAllMales();
        return males;
    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){
        Student student = studentService.getStudent(regNo);
        if(student != null){
            return new ResponseEntity(student , HttpStatus.FOUND);
        }
        else{
            return  ResponseEntity.notFound().build();
        }

    }
    @GetMapping
    public  ResponseEntity getAllStudent(){
        List<StudentResponse> response = studentService.getAllStudent();
        return new ResponseEntity(response , HttpStatus.OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id){
        try{
            studentService.deleteById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

}
