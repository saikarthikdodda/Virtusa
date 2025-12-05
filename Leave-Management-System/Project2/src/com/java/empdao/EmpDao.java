package com.java.empdao;

import com.java.details.Details;

import java.util.List;

public interface EmpDao {
    List<Details> showLeave();
    String addLeave(Details leave);
    String updateLeave(Details leave);
    String deleteLeave(int empId);
    Details searchLeave( int empId);

}
