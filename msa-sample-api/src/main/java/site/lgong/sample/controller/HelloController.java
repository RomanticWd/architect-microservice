package site.lgong.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(name = "HelloService", method = RequestMethod.GET, path = "/hello")
    public String hello() {
        return "hello";
    }
}
