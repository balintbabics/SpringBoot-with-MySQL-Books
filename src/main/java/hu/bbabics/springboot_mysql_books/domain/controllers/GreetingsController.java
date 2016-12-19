package hu.bbabics.springboot_mysql_books.domain.controllers;

import hu.bbabics.springboot_mysql_books.domain.data.GreetingsBO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class GreetingsController {

    @RequestMapping("greetings")
    @ResponseBody
    public GreetingsBO greetUser() {

        GreetingsBO greetingsBO = new GreetingsBO();
        greetingsBO.setName("Hello");
        greetingsBO.setGreeting("World!");
        return greetingsBO;
    }
}
