package com.java.eurekainnerclientv;

import com.java.eurekaemployclientv.model.Employ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/showemploy")
    public Employ[] getEmploys() {
       Employ[] employ = restTemplate.getForObject("http://EUREKAEMPLOYCLIENTV/showEmploy", Employ[].class);
       return employ;
    }
    @GetMapping("/empsearch/{empno}")
    public Employ  search(@PathVariable int empno) {
        return restTemplate.getForObject("http://EUREKAEMPLOYCLIENTV/search/"+empno, Employ .class);

    }

}
