package com.TTN.restfulday2.staticAndDynamicFiltering;
import com.TTN.restfulday2.internationalizationHateosCN.Service;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class FilteringController {


    @Autowired
   private Service service;

    //static filtering
    @GetMapping("/filtering")
    public UserDetails filtering(UserDetails userDetails)
    {

        return  new UserDetails("value1",12,"value3");

    }
    //dynamic filtering
    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue filteringDynamic(UserDetails userDetails)

    {
        UserDetails userDetails3= new UserDetails("value2",34,"value4");
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(userDetails3);
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("name","age");
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );

        mappingJacksonValue.setFilters(filters );

        return mappingJacksonValue;

    }

}
