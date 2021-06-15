package com.javarush.task.task29.task2909.human;                                                                                                    
                                                                                                    
import java.util.List;                                                                                                    
                                                                                                    
public class University  {                                                                                                    
    private List<Student> students;                                                                                                    
    private String name;                                                                                                    
    private int age;                                                                                                    
    private String university;                                                                                                    
                                                                                                    
    public University(String name, int age) {                                                                                                    
                                                                                                            
        this.age = age;                                                                                                    
        this.name = name;                                                                                                    
        students = StudentsDataBase.students;                                                                                                    
    }                                                                                                    
                                                                                                    
    public void setName(String name) {                                                                                                    
        this.name = name;                                                                                                    
    }                                                                                                    
                                                                                                    
    public void setAge(int age) {                                                                                                    
        this.age = age;                                                                                                    
    }                                                                                                    
                                                                                                    
    public String getName() {                                                                                                    
        return name;                                                                                                    
    }                                                                                                    
                                                                                                    
    public int getAge() {                                                                                                    
        return age;                                                                                                    
    }                                                                                                    
                                                                                                    
    public List<Student> getStudents() {                                                                                                    
        return students;                                                                                                    
    }                                                                                                    
                                                                                                    
    public void setStudents(List<Student> students) {                                                                                                    
        this.students = students;                                                                                                    
    }                                                                                                    
                                                                                                    
    public Student getStudentWithAverageGrade(double averageGrade) {                                                                                                    
        for(Student student: students){                                                                                                    
            double averageGradeStudent = student.getAverageGrade();                                                                                                    
            if(averageGrade == averageGradeStudent) return student;                                                                                                    
        }                                                                                                     
        return null;                                                                                                    
        //TODO:                                                                                                    
                                                                                                            
    }                                                                                                    
                                                                                                    
    public Student getStudentWithMaxAverageGrade() {                                                                                                    
        double maxAverageGrade = students.get(0).getAverageGrade();                                                                                                    
        Student studentMaxAvarage = students.get(0);                                                                                                    
                                                                                                            
        for(Student student: students){                                                                                                    
           double averageGradeStudent = student.getAverageGrade();                                                                                                    
            if(averageGradeStudent > maxAverageGrade){                                                                                                    
                maxAverageGrade = averageGradeStudent;                                                                                                    
                studentMaxAvarage = student;                                                                                                    
            }                                                                                                    
        }                                                                                                    
        return studentMaxAvarage;                                                                                                    
        //TODO:                                                                                                    
    }                                                                                                    
                                                                                                        
    public Student getStudentWithMinAverageGrade(){                                                                                                    
        double minAverageGrade = students.get(0).getAverageGrade();                                                                                                    
        Student studentMinAvarage = students.get(0);                                                                                                    
                                                                                                            
        for(Student student: students){                                                                                                    
           double averageGradeStudent = student.getAverageGrade();                                                                                                    
            if(averageGradeStudent < minAverageGrade){                                                                                                    
                minAverageGrade = averageGradeStudent;                                                                                                    
                studentMinAvarage = student;                                                                                                    
            }                                                                                                     
        }                                                                                                    
        return studentMinAvarage;                                                                                                    
    }                                                                                                    
                                                                                                        
    public void expel(Student student){                                                                                                    
        students.remove(student);                                                                                                    
    }                                                                                                    
}