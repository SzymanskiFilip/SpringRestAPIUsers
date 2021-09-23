package eu.filip.springrestapiusers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    @GetMapping("/user")
    public User user(@RequestParam(value="name", defaultValue = "unknown") String name){
        return new User(1, name, "last" + name);
    }

    @GetMapping("/users")
    public List<User> users() throws IOException {
        return JSONReader.readUsersFromFile();
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable Long id) throws IOException {
        return JSONReader.getUserFromId(id.intValue());
    }
}
