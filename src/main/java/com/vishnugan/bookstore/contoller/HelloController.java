package com.vishnugan.bookstore.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//Rest controller

@RestController // @RestController = @Controller + @ResponseBody
public class HelloController {
    @RequestMapping("/hello")// value = "/hello" ,method = RequestMethod.GET
    public String getHello() {
        return "Hello World";
    }
}
