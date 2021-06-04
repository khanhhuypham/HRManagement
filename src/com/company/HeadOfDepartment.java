package com.company;

import java.util.Scanner;

public class HeadOfDepartment extends Staff{
    private int subordinate;

    public HeadOfDepartment(){}
    public HeadOfDepartment(String employeeID, String employeeName, String phoneNumber, String mail,
                            int workingDaysNumber, String entitle,String department,int subordinate) {
        super(employeeID, employeeName, phoneNumber, mail, workingDaysNumber, 200, "head",department);
        this.subordinate = subordinate;
    }

    public int getSubordinate(){
        return subordinate;
    }
    public void setSubordinate(int subordinate){
        this.subordinate = subordinate;
    }



    @Override
    public int calculateSalary() {
        return workingDaysNumber*aDaySalary + 100*subordinate;
    }

    public void addEmployeeNumber(int employeeNumber) {
        this.subordinate += employeeNumber;
    }

    public void minusEmployeeNumber(int employeeNumber) {
        this.subordinate -= employeeNumber;
    }

    @Override
    public void input(){
        super.input();
        Scanner scanner = new Scanner(System.in);
        aDaySalary = 200;
        System.out.print("Enter the number of employee under management of head: ");
        subordinate = scanner.nextInt();
    }


}


