package it.sevenbits.sixthpractice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello controller
 */
@Controller
public class HelloController {
    /**
     * Hello world function
     * @param name received name
     * @return string of hello + name
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String helloWorld(@RequestParam(value = "name") final String name) {
        return "Hello, " + name;
    }
}

