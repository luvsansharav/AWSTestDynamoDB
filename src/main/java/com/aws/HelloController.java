package com.aws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Loya on 9/12/18
 */

@RestController
public class HelloController {

//    @RequestMapping
//    public String index() {
//        return "Hello Spring Boot with Gradle!";
//    }

    @RequestMapping(value = "/getMyName", method = RequestMethod.GET)
    public String getMyName() {
        return "Luvsansharav";
    }
}
