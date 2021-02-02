package com.example.springboot.springboot.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("security")
@RestController
public class LoginController {

    @ApiOperation(value = "登陆", notes = "")
    @RequestMapping("/login")
    public String login() {
        return "redirect:main.html";
    }
}
