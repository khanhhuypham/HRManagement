package com.company;


import java.util.Scanner;

public class Staff {
    public String employeeID;
    public String employeeName;
    public String phoneNumber;
    public String mail;
    public int workingDaysNumber;
    public int aDaySalary;
    public String entitle;
    public String department;


    public Staff(){}
    public Staff(String employeeID, String employeeName, String phoneNumber, String mail, int workingDaysNumber,
                 int aDaySalary, String entitle,String department) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.workingDaysNumber = workingDaysNumber;
        this.aDaySalary = aDaySalary;
        this.entitle = entitle;
        this.department = department;

    }

    public String getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getWorkingDaysNumber() {
        return workingDaysNumber;
    }
    public void setWorkingDaysNumber(int workingDaysNumber) {
        this.workingDaysNumber = workingDaysNumber;
    }

    public int getADaySalary() {
        return aDaySalary;
    }
    public void setADaySalary(int aDaySalary) {
        this.aDaySalary = aDaySalary;
    }

    public String getEntitle(){return entitle;}
    public void setEntitle(String entitle){this.entitle = entitle;}

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }



    public int calculateSalary() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-20s|%-15s|%-25s|%-15d|%-12d|%-10s|%-20s|", employeeID, employeeName, phoneNumber, mail,
                workingDaysNumber, aDaySalary, entitle, department);
    }

    public void input(){
        System.out.print("Enter the ID of employee: ");
        Scanner scanner = new Scanner(System.in);
        employeeID = scanner.next();

        System.out.print("Enter employee name: ");
        employeeName = scanner.nextLine();

        System.out.print("Enter phone number of employee: ");
        phoneNumber = scanner.next();

        System.out.print("Enter phone number of employee: ");
        phoneNumber = scanner.next();

        System.out.print("Enter mail of employee: ");
        mail = scanner.next();

        System.out.print("Enter the number of working days of employee: ");
        workingDaysNumber = scanner.nextInt();

        System.out.print("Enter a day salary of employee: ");
        aDaySalary = scanner.nextInt();

        System.out.print("Enter entitle of employee: ");
        entitle = scanner.nextLine();

        System.out.print("Enter department of employee: ");
        department = scanner.nextLine();

    }



}

