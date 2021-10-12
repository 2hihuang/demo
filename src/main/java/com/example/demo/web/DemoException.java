package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class DemoException {

    @RequestMapping("/zeroException")
    public int zeroException(){
        return 100 / 0;
    }

}
