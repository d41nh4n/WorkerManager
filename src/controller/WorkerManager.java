/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import utils.Utils;
import view.Menu;

/**
 *
 * @author Dai Nhan
 */
public class WorkerManager extends Menu<String> {

    static String[] stringMenu = {" Add Worker", "Up Salary", "Down Salary", "Display Information salary", "Exit"};
    private Utils utils;

    public WorkerManager() {
        super("========== Menu Worker ==========", stringMenu);
        utils = new Utils();
    }

    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            dispplay();
            String choice = utils.getInput("Input choice: ");
            switch (choice) {
                case "1":
                    utils.getWorkers().add(utils.addWorker());
                    break;
                case "2":
                    utils.getInformationSalarys().add(utils.upSalary());
                    break;
                case "3":
                    utils.getInformationSalarys().add(utils.downSalary());
                    break;
                case "4":
                    utils.printInformationSalary();
                    break;
                case "5":
                    System.out.println("Exit...");
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
        }
    }
}
