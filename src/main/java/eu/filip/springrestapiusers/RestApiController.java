package eu.filip.springrestapiusers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @RequestMapping("/test")
    String testTEXT(){
        return "HELLO WORLD!";
    }
}
