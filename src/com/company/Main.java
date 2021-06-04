package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static List<Employee> employeeList = new ArrayList<Employee>();
    public static List<Manager> managerList = new ArrayList<Manager>();
    public static List<HeadOfDepartment> headList = new ArrayList<HeadOfDepartment>();
    public static List<Staff> staffList = new ArrayList<>();
    public static final String fileName = "C:/Users/huy/Desktop/MyWork/HRManagement/Book1.csv";
    public static Company companyInfo = new Company("Cybersoft", "SDWRF0001", 100000000);
    public static double revenueOfCompany = companyInfo.getMonthlyRevenue();


    public static void main(String[] args) {
        /*--------------------------------import data into list------------------------------------------------*/
        importData();
        mapHeadToEmployee();
        staffList.addAll(managerList);
        staffList.addAll(headList);
        staffList.addAll(employeeList);
        /*______________________________________________________________________________________________________*/


        menu();
        System.out.print("Please, enter your option to perform: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice > 0 && choice <= 10) {
            switch (choice) {
                case 1: {
                    companyInfo.exportInfo();
                    break;
                }
                case 2: {
                    System.out.print("\nWhen the program imports data table from excel file using importData() function," +
                            " it has already allocated employees for each head of department correspondingly\n");
                    printEmployee();
                    break;}
                case 3: {
                    System.out.println("\nPress 1 to enter the information of new employee \nPress 2 to delete employee from the list");
                    System.out.print("Your option is: ");
                    int option = scanner.nextInt();
                    if(option == 1){
                        addStaff();
                    }else if(option == 2){
                        System.out.print("Please, enter the ID of employee you want to delete: ");
                        String ID = scanner.next();
                        delete(ID);
                    }
                    break;
                }
				case 4: {
                    printStaffList();
                    break;
				}
                case 5: {
                    calculateSalary();
                    break;
                }
                case 6: {/*Search for employees having the highest salary in the company*/
                    List<Employee> highestSalaryList = theHighestSalary(employeeList);
                    for(int i = 0 ; i < highestSalaryList.size(); i++){
                        System.out.println(highestSalaryList.get(i).toString());
                    }
                    break;
                }
                case 7: {
                    List<HeadOfDepartment> result= theMostSubordinate(headList);
                    System.out.println(result.size());
                    for (int i = 0; i < result.size(); i++){
                        System.out.println(result.get(i).toString());
                    }
                    break;
                }
                case 8: {
                    alphabeticallySort(staffList);
                    break;}
                case 9: {
                    sortIntoDescendingSalary(staffList);
                    break;}
                case 10: {
                    System.out.print(revenueOfCompany);
                        for(int i = 0; i < managerList.size(); i++){
                            managerList.get(i).exportInfo();
                            System.out.print("\nTotal income: " +
                            ((double)managerList.get(i).calculateSalary() + managerList.get(i).getStockQuantity()*revenueOfCompany));
                        }
                    break;}

                default:
                    System.out.println("\nInvalid option");

            }
            System.out.print("\nPlease, enter your option again to perform the other function: ");
            choice = scanner.nextInt();
        }

    }

    public static void menu() {
        System.out.println("1. Enter the information of the company.");
        System.out.println("2. allocate employee to right department");
        System.out.println("3. Add, delete information of an employee.");
        System.out.println("4. Export information of all employee in the company.");
        System.out.println("5. Calculate and export the table of total salary of the entire company");
        System.out.println("6. Search for employees having the highest salary in the company");
        System.out.println("7. Search for head having the most subordinates in the company");
        System.out.println("8. Sort alphabetically employees of the entire company");
        System.out.println("9. sort employees of the entire company on the order of descending salary");
        System.out.println("10. Search for the director with the highest stocks.");
    }

    public static void importData() {
        try {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";

            line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] cell = line.split(",");
                if(cell[6].toLowerCase().equals("employee")){
                    Employee employee = new Employee(cell[0], cell[1], cell[2],
                            cell[3], Integer.parseInt(cell[4]), cell[6],cell[7],null);
                    employeeList.add(employee);

                }else if(cell[6].toLowerCase().equals("head of department")){
                    HeadOfDepartment head = new HeadOfDepartment(cell[0], cell[1], cell[2],
                            cell[3], Integer.parseInt(cell[4]), cell[6], cell[7], Integer.parseInt(cell[8]));
                    headList.add(head);

                }else if(cell[6].toLowerCase().equals("manager")){
                    Manager manager = new Manager(cell[0], cell[1], cell[2],
                            cell[3], Integer.parseInt(cell[4]), cell[6], cell[7],Integer.parseInt(cell[9]));
                    managerList.add(manager);
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mapHeadToEmployee(){
        for(int i = 0; i < employeeList.size(); i++){
            for(int j = 0; j < headList.size(); j++) {
                String departmentOfEmployee = employeeList.get(i).getDepartment();
                String departmentOfHead = headList.get(j).getDepartment();
                if (departmentOfHead.equals(departmentOfEmployee)) {
                    String headName = headList.get(j).getEmployeeName();
                    employeeList.get(i).setHeadOfDepartment(headName);
                }
            }
        }
    }

    public static void printEmployee(){
        System.out.println("\n\n-------------------------------------the list of employee------------------------------------------\n\n");
        drawLine(156);
        System.out.format("\n%-10s|%-20s|%-15s|%-25s|%-15s|%-12s|%-10s|%-20s|%-20s|\n",
                "EmployeeID", "Employee Name", "Phone Number", "Mail", "working days",
                "salary/day", "Entitle", "department", "Head of department");
        drawLine(156);
        System.out.println();
        for(int i = 0; i < employeeList.size(); i++){

            System.out.println(employeeList.get(i).toString());
        }
        drawLine(156);
    }

    public static void addStaff(){
        System.out.print("\nWhich kind of employee do you want to add (1 - normal employee, 2 - Manager, 3 - head of department): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice){
            case 1: {
                Employee newEmployee = new Employee();
                newEmployee.input();
                employeeList.add(newEmployee);
                break;
            }
            case 2: {
                Manager newManager = new Manager();
                newManager.input();
                managerList.add(newManager);
                break;
            }
            case 3: {
                HeadOfDepartment newHead = new HeadOfDepartment();
                newHead.input();
                headList.add(newHead);
                break;
            }
        }
    }

    public static void printStaffList(){
        drawLine(156);
        System.out.format("\n%-10s|%-20s|%-15s|%-25s|%-15s|%-12s|%-10s|%-20s|%-20s|\n",
                "EmployeeID", "Employee Name", "Phone Number", "Mail", "working days",
                "salary/day", "Entitle", "department", "Head of department");
        drawLine(156);
        System.out.println();
        for(int i = 0; i < staffList.size(); i++){
            System.out.println(staffList.get(i).toString());
        }
        drawLine(156);

    }

    public static Staff search(String ID){
        Staff staff = null;
        for(int i = 0; i < staffList.size(); i++){
            if(staffList.get(i).getEmployeeID().equals("")){
                System.out.println("Not found");
                System.exit(1);
            }else if(staffList.get(i).getEmployeeID().equals(ID)){
                staff = staffList.get(i);

            }
        }
        return staff;
    }

    public static void delete(String ID){
        Staff deleteStaff = search(ID);
        String entitle = deleteStaff.getEntitle();
        staffList.remove(deleteStaff);
        if(entitle.equals("Manager")){
            managerList.remove(deleteStaff);
        }
        else if(entitle.equals("Employee")){
            /*when the employee is deleted, the number of members in department will decrease*/
            String employeeName = deleteStaff.getEmployeeName();
            String employeeDepartment = deleteStaff.getDepartment();
            for(int i = 0; i < headList.size(); i++){
                if(employeeDepartment.equals(headList.get(i).getDepartment())){
                    headList.get(i).minusEmployeeNumber(1);
                }
            }
            employeeList.remove(deleteStaff);
        }
        else if(entitle.equals("head")){
            /*if the employee to be deleted is head, we have to remove that employee from headlist
            * and all employees under that employee's management will have no head.
            * */
            String headName = deleteStaff.getEmployeeName();
            headList.remove(deleteStaff);
            for(int i = 0; i < employeeList.size();i++){
                if(employeeList.get(i).getHeadOfDepartment().equals(headName)){
                    employeeList.get(i).setHeadOfDepartment(null);
                }
            }
        }

    }

    public static void calculateSalary(){
        for(int i = 0; i < staffList.size(); i++){
            int salary = staffList.get(i).calculateSalary();
            System.out.println("\n"+ staffList.get(i).toString() + "\t" + salary);
        }
    }

    public static List<Employee> theHighestSalary(List<Employee> list){
        /*initially set maxSalary to certain value
        * Note that there may be more than employee having the highest salary
        * */
        List<Employee> arrayList = new ArrayList<Employee>();
        int maxSalary = 100;
        Staff staff = null;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).calculateSalary() >= maxSalary) {
                maxSalary = list.get(i).calculateSalary();
            }
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).calculateSalary() >= maxSalary) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    public static List<HeadOfDepartment> theMostSubordinate(List<HeadOfDepartment> list){
        /*initially set maxSubordinate to certain value
         * Note that there may be more than employee having the highest salary
         * */
        List<HeadOfDepartment> arrayList = new ArrayList<HeadOfDepartment>();
        int maxSubordinate = 1;
        Staff staff = null;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getSubordinate() >= maxSubordinate) {
                maxSubordinate = list.get(i).getSubordinate();
            }
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getSubordinate() >= maxSubordinate) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    public static void alphabeticallySort(List<Staff> list){
        Collections.sort(list, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.getEmployeeName().compareTo(o2.getEmployeeName());
            }
        });
    }

    public static void sortIntoDescendingSalary(List<Staff> list){
        Collections.sort(list, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.calculateSalary() > o2.calculateSalary() ? 1: -1;
            }
        });
    }

   public static void drawLine(int n){
        for(int i = 0; i < n; i++){
            System.out.print("-");
        }

   }

    public static void employeeAllocation(Scanner sc) {
        List<Employee> unallocatedEmployeeList = new ArrayList<Employee>();

        for (Staff staff : staffList) {
            if(staff instanceof Employee) {
                Employee e = (Employee) staff;
                if(e.getHeadOfDepartment().equals("")){
                    unallocatedEmployeeList.add(e);
                }
            }
        }

        // cho người dùng phân bổ từng nhân viên
        for (Employee e : unallocatedEmployeeList) {
            System.out.println("=====--PHÂN BỔ NHÂN VIÊN--=====");
            System.out.print(e.toString());
//            drawLine(20);
            System.out.println("Chọn trưởng phòng để phân bổ: ");
            for (int i = 0; i < headList.size(); i++) {
                System.out.printf("%d. %20s %20s %5d %10s\n", i+1,
                        headList.get(i).getEmployeeID(), headList.get(i).getEmployeeName(),
                        headList.get(i).getSubordinate(),headList.get(i).getDepartment());
            }
            System.out.println("0. Không phân bổ.");
            System.out.println("-1. Thoát chức năng phân bổ.");
            System.out.print("Lựa chọn: ");

            System.out.print("\nEnter 0 to not allocating");
            System.out.print("\nEnter -1 to escape from allocating function");
            System.out.print("\nEnter the numerical order of head above to choose head correspondingly for allocation");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice == 0){continue;}
            if(choice == -1){return;}
            if(choice > 0 && choice <= headList.size()) {
                e.setHeadOfDepartment(headList.get(choice-1).getEmployeeName());
                headList.get(choice-1).addEmployeeNumber(1);
            } else {
                System.out.println("the entered number is invalid.");
            }
        }

    }

}
