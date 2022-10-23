package com.TTN.restfulday2.swagger;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SwaggerResource
    {


        //list
        private static List<Swagger> swaggers = new ArrayList<>();


        //setting up values
        static
        {
            swaggers.add(new Swagger("muskan", 23));
            swaggers.add(new Swagger("sofi", 22));


        }


        //returns all Employee data using List in json format
        public List<Swagger> findAll()
        {
            return swaggers;
        }


        // and return it and display in json
        public Swagger save (Swagger swagger)
        {
            swaggers.add(swagger);
            return swagger;
        }

        //method to delete
        public void delete ( int age)
        {
            //deleting by id
            swaggers.removeIf(e -> e.getAge().equals(age));

        }


}
