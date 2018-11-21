package spring.cloud.exapmle.consumer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import spring.cloud.exapmle.consumer.configs.RibbonConfiguration;

@RestController
@RibbonClient(name = "consumer", configuration = RibbonConfiguration.class)
public class ServiceInfoController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String hello() {
        return "Hello, I am consumer.";
    }

    @RequestMapping("/getActionServicePort")
    public String getActionServicePort() {
        return restTemplate.getForObject(String.format("http://eureka-provider-clustered/getServicePort"), String.class);
    }

}
