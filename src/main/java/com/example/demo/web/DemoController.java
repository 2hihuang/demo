package com.example.demo.web;

import com.example.demo.bean.Demo;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/getDemo")
    public ModelAndView getDemo(){
        ModelAndView demos = new ModelAndView();
        demos.addObject("demos", demoService.findAll());
        demos.setViewName("demos");
        return demos;
    }

    @ResponseBody
    @RequestMapping("/show")
    public Demo showDemo(@RequestParam(name = "no", defaultValue = "1", required = true) long id) {
        return demoService.getById(id);
    }

    @ResponseBody
    @RequestMapping("/save")
    public String save() {
        demoService.save(new Demo("hz"));
        return "The data is saved.";
    }
}
