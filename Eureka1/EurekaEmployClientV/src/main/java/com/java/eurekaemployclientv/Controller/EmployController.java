package com.java.eurekaemployclientv.Controller;


import com.java.eurekaemployclientv.model.Employ;
import com.java.eurekaemployclientv.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployController {

    @Autowired
    EmployService employService;

    @GetMapping("/showEmploy")
    public List<Employ> showEmploy(){
        return employService.showEmploy();
    }
    @GetMapping(value="/search/{empno}")
    public Employ searchEmploy(@PathVariable int empno) {
        return employService.searchEmploy(empno);
    }
    @PostMapping("/addEmploy")
    public String addEmploy(@RequestBody Employ employ){
        return employService.addEmploy(employ);
    }
}
