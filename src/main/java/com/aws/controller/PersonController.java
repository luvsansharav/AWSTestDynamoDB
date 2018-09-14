package com.aws.controller;

import com.aws.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aws.service.PersonService;

/**
 * Created by Loya on 9/12/18
 */

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String savePerson() {
        try {
            Person p = new Person();
            p.setId("125");
            p.setFirstname("Uuree");
            p.setLastname("Batbileg");
            personService.savePerson(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Done";
    }
}
