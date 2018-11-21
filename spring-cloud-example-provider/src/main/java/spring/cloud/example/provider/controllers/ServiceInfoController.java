package spring.cloud.example.provider.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceInfoController {

    @Autowired
    Environment environment;

    @RequestMapping("/")
    public String hello() {
        return "Hello, I am a provider.";
    }

    @RequestMapping("/getServicePort")
    public String getServicePort() {
        return "Hello, I am a provider: Port " + environment.getProperty("server.port");
    }

}
