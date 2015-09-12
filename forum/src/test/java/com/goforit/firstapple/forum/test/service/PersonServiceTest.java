package com.goforit.firstapple.forum.test.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;  
import org.junit.runner.RunWith;

import com.goforit.firstapple.forum.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class PersonServiceTest {
    
    @Autowired
    private PersonService personService;
    
    @Test
    public void testSpring(){
        personService.processSave();
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
    
    

}
