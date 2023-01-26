package com.ssafy.test.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping
    public String getTest(){
        System.out.println("test");
       return "getTest 통신성공!";
    }

    @PostMapping
    public String postTest(@RequestParam("name") String name){
        return "postTest 통신성공! name =>" + name ;
    }
}
