package com.company;

import java.util.Scanner;

public class Employee extends Staff{
    private String headOfDepartment;

    public Employee(){}
    public Employee(String employeeID, String employeeName, String phoneNumber, String mail,
                    int workingDaysNumber, String entitle,String department, String headOfDepartment)
    {
        super(employeeID, employeeName, phoneNumber, mail, workingDaysNumber, 100, "Employee",department);
        this.headOfDepartment = headOfDepartment;
    }

    public String getHeadOfDepartment(){
        return headOfDepartment;
    }
    public void setHeadOfDepartment(String headOfDepartment){
        this.headOfDepartment = headOfDepartment;
    }

    @Override
    public int calculateSalary() {
        return workingDaysNumber*aDaySalary;

    }

    @Override
    public void input(){
        super.input();
        Scanner scanner = new Scanner(System.in);
        aDaySalary = 100;
        System.out.print("Enter the name of  Head of Department for employee: ");
        headOfDepartment = scanner.nextLine();

    }


    @Override
    public String toString() {
        return String.format("%-10s|%-20s|%-15s|%-25s|%-15d|%-12d|%-10s|%-20s|%-20s|", employeeID, employeeName, phoneNumber, mail,
                workingDaysNumber, aDaySalary, entitle, department, headOfDepartment);
    }

}

