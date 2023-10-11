/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import model.InformationSalary;
import model.Worker;

/**
 *
 * @author Dai Nhan
 */
public class Utils {

    private ArrayList<Worker> workers;
    private ArrayList<InformationSalary> inforSalary;

    public Utils() {
        workers = new ArrayList<>();
        inforSalary = new ArrayList<>();

    }

    public String getInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public ArrayList<InformationSalary> getInformationSalarys() {
        return inforSalary;
    }
//----------------------------------------------------------------

    public Worker addWorker() {
        String id;
        do {
            id = getInput("Enter ID: ");
            if (findWorker(id) instanceof Worker) {
                System.out.println("This ID was existed");
            }
        } while (findWorker(id) instanceof Worker);
        String name = getInput("Enter Name: ");
        String ageSrc;

        do {
            ageSrc = getInput("Enter Age(16 - 70)");
            if (!checkAge(ageSrc)) {
                System.out.println("Wrong Age!");
            }
        } while (!checkAge(ageSrc));
        int age = Integer.parseInt(ageSrc);
        String salarySrc;
        do {
            salarySrc = getInput("Enter Salary: ");
            if (!checkSalary(salarySrc)) {
                System.out.println("Wrong Salary!");
            }
        } while (!checkSalary(salarySrc));
        float salary = Float.parseFloat(salarySrc);
        String workLocation = getInput("Enter Work Location: ");
        return new Worker(id, name, age, salary, workLocation);
    }
//------------------------------------------------------------------------------------ 

    public InformationSalary upSalary() {
        String id = getInput("Enter ID to up salary: ");
        Worker worker = findWorker(id);
        if (worker == null) {
            System.out.println("This ID wasn't existed");
            return null;
        } else if (worker instanceof Worker) {
            System.out.println("The Worker is founded");
            System.out.println("-------------------------");
            System.out.printf("%-5s | %-15s | %-5d | %-15.2f | %-20s%n", worker.getId(), worker.getName(), worker.getAge(),
                    worker.getSalary(), worker.getWorkLocation());
        }
        String salary;
        do {
            salary = getInput("Enter Salary: ");
            if (!checkSalary(salary)) {
                System.out.println("Wrong Salary!");
            }
        } while (!checkSalary(salary));
        float salaryNumber = Float.parseFloat(salary);
        for (Worker workerFounded : workers) {
            if (workerFounded.equals(worker)) {
                workerFounded.setSalary(workerFounded.getSalary() + salaryNumber);
               return new InformationSalary(workerFounded.getId(), workerFounded.getName(),
                        workerFounded.getAge(), workerFounded.getSalary(), "UP", LocalDate.now());
            }
        }
        return null;
    }

    public InformationSalary downSalary() {
        String id = getInput("Enter ID to up salary: ");
        Worker worker = findWorker(id);
        if (worker == null) {
            System.out.println("This ID wasn't existed");
            return null;
        } else if (worker instanceof Worker) {
            System.out.println("The Worker is founded");
            System.out.println("-------------------------");
            System.out.printf("%-5s | %-15s | %-5d | %-15.2f | %-20s%n", worker.getId(), worker.getName(), worker.getAge(),
                    worker.getSalary(), worker.getWorkLocation());
        }
        String salarySrc;
        do {
            salarySrc = getInput("Enter Salary: ");
            if (!checkSalary(salarySrc)) {
                System.out.println("Wrong Salary!");
            }
        } while (!checkSalary(salarySrc));
        float salary = Float.parseFloat(salarySrc);
        for (Worker workerFounded : workers) {
            if (workerFounded.equals(worker)) {
                workerFounded.setSalary(workerFounded.getSalary() - salary);
                return new InformationSalary(workerFounded.getId(), workerFounded.getName(),
                        workerFounded.getAge(), workerFounded.getSalary(), "DOWN", LocalDate.now());
            }
        }
        return null;
    }

    public void printInformationSalary() {
        System.out.printf("%-5s | %-15s | %-5s | %-15s | %-7s | %-10s%n", "Id", "Name", "Age", "Salary", "Status", "Date");
        for (InformationSalary inforSalary : inforSalary) {
            inforSalary.print();
        }
    }
//-------------------------------------------------------------------------------------

    public boolean checkSalary(String salaryInput) {
        try {
            float salaryOutput = Float.parseFloat(salaryInput);
            if (salaryOutput < 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkAge(String ageInput) {
        try {
            int ageOutput = Integer.parseInt(ageInput);
            if (ageOutput > 16 && ageOutput < 70) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public Worker findWorker(String id) {
        for (Worker worker : workers) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }
        return null;
    }
}
