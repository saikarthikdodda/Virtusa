package com.java.main;

import com.java.details.Details;
import com.java.empbal.DetailsBal;
import com.java.empdao.EmpDao;
import com.java.empdao.EmpDaoImpl;
import com.java.exception.DetailsException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static Details leave = new Details();
    static SimpleDateFormat sdf=new SimpleDateFormat("DD-MM-YYYY");
    public static void main(String[] args) throws ParseException, DetailsException {
        int choice ;

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println( "---OPTIONS---" );
            System.out.println( "1.Show leave" );
            System.out.println( "2.Add Leave" );
            System.out.println( "3. Update Leave" );
            System.out.println( "4. Delete Leave" );
            System.out.println( "5. Search Leave" );
            System.out.println( "6. Exit" );
            choice = sc.nextInt();
            switch( choice ){
                case 1:showLeave();
                    break;
                case 2:
                    addLeave();
                    break;
                case 3:updateLeave();
                    break;
                case 4:
                    deleteLeave();
                    break;
                    case 5:
                        searchLeave();
                        break;

            }

        }while(choice!=6);
    }
    private static void showLeave() {
        List<Details> leave = DetailsBal.showLeavesBal();
        if(leave!=null && !leave.isEmpty()){
            leave.forEach(System.out::println);
        }else{
            System.out.println("No leaves found");
        }

    }
    private static void searchLeave() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter emp ID");
        int empId=sc.nextInt();
        System.out.println(DetailsBal.searchEmployBal(empId));
    }

    private static void deleteLeave() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter emp ID");
        int empId = sc.nextInt();
        System.out.println(DetailsBal.deleteEmployBal(empId));
    }


    private static void updateLeave() throws ParseException, DetailsException {

            Details leave = new Details();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Leave ID");
            leave.setLeaveId(sc.nextInt());
            System.out.println("Enter Employ Id");
            leave.setEmpId(sc.nextInt());
            System.out.println("Enter Start Date (DD-MM-YYYY)");
            leave.setLeaveStartDate(sdf.parse(sc.next()));
            System.out.println("Enter End Date (DD-MM-YYYY)");
            leave.setLeaveEndDate(sdf.parse(sc.next()));
            System.out.println("Enter Number Of Days");
            int days = sc.nextInt();
            sc.nextLine();
            leave.setNoOfDays(days);
            System.out.println("Enter Date Applied On");
            leave.setAppliedOn(sdf.parse(sc.nextLine()));
            System.out.println("Enter Leave Reason");
            leave.setLeaveReason(sc.next());
            System.out.println(DetailsBal.updateEmployBal(leave));



    }
    private static void addLeave() throws ParseException, DetailsException {

        Scanner sc = new Scanner(System.in);
        Details details = new Details();
        System.out.println("Enter leave Id");
        details.setLeaveId(sc.nextInt());
        System.out.println("Enter Employee Id");
        details.setEmpId(sc.nextInt());
        System.out.println("Enter Leave Start Date (DD-MM-YYYY)");
        details.setLeaveStartDate(sdf.parse(sc.next()));
        System.out.println("Enter Leave End Date (DD-MM-YYYY)");
        details.setLeaveEndDate(sdf.parse( sc.next() ));
        System.out.println("Enter Number Of Days");
        int days = sc.nextInt();
        sc.nextLine();
        details.setNoOfDays(days);
        System.out.println("Enter Date Applied On");
        details.setAppliedOn( sdf.parse( sc.nextLine() ));
        System.out.println("Enter Leave Reason");
        details.setLeaveReason(sc.next());
        System.out.println(DetailsBal.addEmployBal(details));

    }

}
