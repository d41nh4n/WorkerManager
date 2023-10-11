/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dai Nhan
 */
public class Worker {

    private String id;
    private String name;
    private int age;
    private float salary;
    private String workLocation;

    public Worker(String id, String name, int age, float salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getId() {
        return id;
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

    public String getWorkLocation() {
        return workLocation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public void print() {
        System.out.printf("%-5s | %-15s | %-5d | %-15.2f | %-20s%n", id, name, age, salary, workLocation);
    }
}
