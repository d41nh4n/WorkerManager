/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dai Nhan
 */
public class InformationSalary {
    private String code;
    private String name;
    private int age;
    private float salary;
    private String status;
    private LocalDate date;
    
    
    public InformationSalary(String code, String name, int age, float salary, String status, LocalDate date) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    public InformationSalary() {
    }
    
    
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int Age) {
        this.age = Age;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void print(){
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d/M/uuuu");
        String formattedDate = date.format(outputFormatter);
        System.out.printf("%-5s | %-15s | %-5d | %-15.2f | %-7s | %-10s%n   ", code, name, age, salary, status,formattedDate);
    }
}
