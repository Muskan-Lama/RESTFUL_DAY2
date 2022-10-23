package com.TTN.restfulday2.internationalizationHateosCN;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import com.TTN.restfulday2.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;




@RestController
public class Controller {



    private MessageSource messageSource;

    @Autowired
    private Service service;

    
    public Controller(MessageSource messageSource)
    {
        this.messageSource=messageSource;
    }




    @GetMapping("/users")
    public List<Employee> getAll()
    {

        return service.findAll();
    }

    //getting Pathvariable
    //Implement GET
    // http request using path variable top get one employee
    //HATEOS
    //content negotiation
    @GetMapping("/users/{id}")
    public EntityModel<Employee> retrieveUser(@PathVariable int id) throws IdNotFoundException {
        Employee employee = service.findOne(id);

        //throwing exception when id is not found
        if(employee==null)
            throw new IdNotFoundException("id:"+id);


        //using entity model
        // represents RepresentationModel containing only single entity and related links
        EntityModel<Employee> entityModel = EntityModel.of(employee);
        //we can use WebMvcLinkBuilder to create links pointing to controller classes and it’s methods.
        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getAll());
      // adding link
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }
    @GetMapping(path="/hello")
   public String helloNameInterNationalized()
   {
       //requestheader
       Locale locale= LocaleContextHolder.getLocale();
      return messageSource.getMessage("hello.name.message",null,"Default message",locale);
   }



   @GetMapping(path="/hello/{username}")
    public String localized(@PathVariable String username)
   {
      Locale locale2=LocaleContextHolder.getLocale();
       String name[] = new String[]{username};
      return  messageSource.getMessage("userName",name,"Default message",locale2);


   }

    //DELETE
    @DeleteMapping(path="/users/{id}")
    public void delete(@PathVariable int id )
    {


        //deleting
       service.delete(id);

    }

    //content negotiation
    //Apply validation while
    // create a new employee using POST http Request.
    // create user
    @PostMapping(path="/users"  ,produces = "application/xml ",consumes = "application/xml")
    public ResponseEntity<Employee> createUser(@RequestBody Employee employee)
    //requestBody for creating objects of json data
    {
       Employee save= service.save(employee);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{age}")
                .buildAndExpand(save.getAge())
                .toUri();
        // to return the uri location  of the created object

        return ResponseEntity.created(location).build(); // created and return the uri
    }









}

