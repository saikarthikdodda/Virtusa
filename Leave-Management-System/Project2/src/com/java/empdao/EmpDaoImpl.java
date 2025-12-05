package com.java.empdao;

import com.java.details.Details;

import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {

    static List<Details> leaves ;

    static {
        leaves  = new ArrayList<Details>();
    }

    @Override
    public List<Details> showLeave() {
        return  new ArrayList<>(leaves) ;
    }

    @Override
    public String addLeave(Details leave) {
        leaves.add(leave);
        return "leave added Successfully";
    }

    @Override
    public String updateLeave(Details leave) {
        Details details = searchLeave(leave.getEmpId());
        if(details!=null){
            details.setLeaveId(leave.getLeaveId());
            details.setEmpId(leave.getEmpId());
            details.setLeaveStartDate(leave.getLeaveStartDate());
            details.setLeaveEndDate(leave.getLeaveEndDate());
            details.setNoOfDays(leave.getNoOfDays());
            details.setAppliedOn(leave.getAppliedOn());
            details.setLeaveReason(leave.getLeaveReason());

            return "leave record updated successfully";

        }
        return "leave record not found";
    }

    @Override
    public String deleteLeave(int leaveId) {
        Details leaveDetails = searchLeave(leaveId);
        if(leaveDetails != null) {
            leaves.remove(leaveDetails);
            return "leave record deleted";
        }
        return  "leave record not found";
    }

    @Override
    public Details searchLeave(int empId) {
        Details emp= leaves.stream().filter(leave -> leave.getEmpId()==empId).findFirst().orElse(null);

        return emp;
    }


}
