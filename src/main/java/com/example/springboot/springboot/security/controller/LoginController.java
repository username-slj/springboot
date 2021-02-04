package com.example.springboot.springboot.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://blog.csdn.net/qq_42640067/article/details/113062222
 */
@Api("security")
@RestController
@Slf4j
public class LoginController {

    @ApiOperation(value = "登陆")
    @GetMapping(value = "/login")
    public String login() {
        log.info("=============================================");
        return "redirect:main.html";
    }
}
