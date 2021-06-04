package com.company;

import java.util.Scanner;

public class Manager extends Staff{
    private int stockQuantity;

    public Manager(){}
    public Manager(String employeeID, String employeeName, String phoneNumber, String mail,
                   int workingDaysNumber, String entitle,String department,int stockQuantity) {
        super(employeeID, employeeName, phoneNumber, mail, workingDaysNumber, 300, "Manager",department);
        this.stockQuantity = stockQuantity;
    }

    public int getStockQuantity(){
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity){
        this.stockQuantity = stockQuantity;
    }




    @Override
    public int calculateSalary() {
        return workingDaysNumber*aDaySalary;
    }

    @Override
    public void input(){
        super.input();
        Scanner scanner = new Scanner(System.in);
        aDaySalary = 300;
        System.out.print("Enter the stock quantity that the manager will own: ");
        stockQuantity = scanner.nextInt();
    }

    public void exportInfo(){
        System.out.print("\nID: " + this.employeeID);
        System.out.print("\nName: " + this.employeeName);
        System.out.print("\nSalary: " + calculateSalary());
    }

}



