package com.company;

import java.util.Scanner;

public class Company {
    /*properties*/
    private String companyName;
    private String taxCode;
    private double monthlyRevenue;

    public Company(){}
    public Company(String companyName, String textCode, double monthlyRevenue){
        this.companyName = companyName;
        this.taxCode = textCode;
        this.monthlyRevenue = monthlyRevenue;
    }

    public String getCompanyName(){
        return companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getTaxCode(){
        return taxCode;
    }
    public double getMonthlyRevenue(){
        return monthlyRevenue;
    }



    /*methods*/
    public void enterCompanyInfo(Scanner scanner){
        System.out.println("=====Company information======");
        System.out.print("Name: ");
        companyName = scanner.nextLine();
        System.out.print("Tax code: ");
        taxCode = scanner.nextLine();
        System.out.print("Monthly ");
        monthlyRevenue = Double.parseDouble(scanner.nextLine());
    }

    public void exportInfo(){
        System.out.printf("\n======----Company named %s--=====\n",this.companyName);
        System.out.println("Tax code: " + this.taxCode);
        System.out.println("Monthly Revenue: " + this.monthlyRevenue);
    }


}
