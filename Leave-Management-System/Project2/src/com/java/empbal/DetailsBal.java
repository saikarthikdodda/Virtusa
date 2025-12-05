package com.java.empbal;

import com.java.details.Details;
import com.java.empdao.EmpDao;
import com.java.empdao.EmpDaoImpl;
import com.java.exception.DetailsException;

import java.util.Date;
import java.util.List;

import static com.java.main.Main.leave;

public class DetailsBal {
    static StringBuilder sb;
    static EmpDao employDao;

    static {
        sb = new StringBuilder();
        employDao = new EmpDaoImpl();
    }
    public static List<Details>  showLeavesBal() {
        return employDao.showLeave();
    }
    public static String addEmployBal(Details details) throws DetailsException {
        if (validateDetails(details) ) {
            return employDao.addLeave(details);
        }
        throw new DetailsException(sb.toString());
    }
    public static Details searchEmployBal(int empId) {
        return employDao.searchLeave(empId);
    }
    public static String deleteEmployBal(int empId) {
        return employDao.deleteLeave(empId);
    }
    public   static String updateEmployBal(Details details  ) throws DetailsException {
           if(validateDetails(details)==true){
               return employDao.updateLeave(details);
           }
           throw new DetailsException(sb.toString());


    }
    public static boolean validateDetails(Details details) {
        boolean isvalid = true;
        Date now=new Date();
        if(details.getLeaveStartDate()==null || details.getLeaveEndDate()==null){
            isvalid = false;
            sb.append("leave start and end date cannot be null");
        }
        if(details.getLeaveEndDate().compareTo(details.getLeaveStartDate())<0) {
            isvalid = false;
            sb.append("end date must be after start date");
        }

        if(details.getLeaveStartDate().compareTo(now)>0) {
            isvalid = false;
            sb.append("start date must be before yesterday");
        }

        return isvalid;
    }



}
