package com.TTN.restfulday2.swagger;

import java.net.URI;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SwaggerControll {


    @Autowired
    private SwaggerResource swaggerResource;

    public SwaggerControll(SwaggerResource swaggerResource) {

        this.swaggerResource = swaggerResource;
    }


    //getting all the Employee
    //mapping to specific url using GET
    @GetMapping( path="/swag")
    @ApiOperation(value = "List all Users",
            notes = "List all Users using it's service method", response = Swagger.class)
    public List<Swagger> getAll()
    {

        return swaggerResource.findAll();
    }




    //DELETE
    @DeleteMapping(path="/swag/{age}")
    @ApiOperation(value = "Deletes the User",
            notes = "Deletes the user associated with the passed AGE", response = Swagger.class)
    public void delete(@PathVariable int age)
    {


        //deleting
       swaggerResource.delete(age);

    }


    //Apply validation while
    // create a new employee using POST http Request.
    // create user
    @PostMapping(path="/swag")
    @ApiOperation(value = "Creates new User",
            notes = "Creates new user using it's service method", response = Swagger.class)
    public ResponseEntity<Swagger> createUser(@RequestBody Swagger swagger)
    //requestBody for creating objects of json data
    {
        Swagger save= swaggerResource.save(swagger);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{age}")
                .buildAndExpand(save.getAge())
                .toUri();
        // to return the uri location  of the created object

        return ResponseEntity.created(location).build(); // created and return the uri
    }





}

