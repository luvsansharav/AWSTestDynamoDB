package com.aws.service;

import com.aws.repository.PersonRepository;
import com.aws.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Loya on 9/12/18
 */

@Component
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        try {
            personRepository.savePerson(person);
            return person;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
