package io.nefeed.springdruid.controller;

import io.nefeed.springdruid.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 09:08
 */
@Controller
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(String name) {
        return helloWorldService.getHelloMessage(name);
    }
}
