package com.TTN.restfulday2.staticAndDynamicFiltering;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


//methods

//managed by spring and it is autowired in Employee resource
@Component
public class ServiceSD {


    //list
    private static List<UserDetails> userDetailsList = new ArrayList<>();


    //setting up values of Employee bean
    static {
        userDetailsList.add(new UserDetails("Muskan", 22, "3rewr"));
        userDetailsList.add(new UserDetails("Geetanjali", 32, "3sjd"));


    }


}