package eu.filip.springrestapiusers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User user(@RequestParam(value="name", defaultValue = "unknown") String name){
        return new User(1, name, "last" + name);
    }
}