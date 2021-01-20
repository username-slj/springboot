package com.example.springboot.springboot.springbootmodel.controller;

import com.example.springboot.springboot.springbootmodel.dao.SUserMapper;
import com.example.springboot.springboot.springbootmodel.model.SUser;
import com.example.springboot.springboot.springbootmodel.utils.UtilsTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@Api("用户")
@Slf4j
@RestController
@RequestMapping(value = "/mybatis", produces = "application/json")
public class SUserController {
    @Resource
    private SUserMapper sUserMapper;

    @ApiOperation(value = "hello")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        throw new RuntimeException();
    }

    @ApiOperation(value = "用户新增")
    @RequestMapping(value = "/addSUser/{id}/{username}/{password}", method = RequestMethod.GET)
    public void addSUser(@ApiParam("id") @RequestParam("id") String id,
                         @ApiParam("username") @RequestParam("username") String username,
                         @ApiParam("password") @RequestParam("password") String password){
        SUser sUser = new SUser();
        sUser.setId(id);
        sUser.setUsername(username);
        sUser.setPassword(password);
        sUserMapper.insert(sUser);
    }

    @Transactional
    @ApiOperation(value = "事务")
    @RequestMapping(value = "/addSUserTransaction/{id}/{username}/{password}", method = RequestMethod.GET)
    public void addSUserTransaction(@ApiParam("id") @RequestParam("id") String id,
                         @ApiParam("username") @RequestParam("username") String username,
                         @ApiParam("password") @RequestParam("password") String password){
        SUser sUser = new SUser();
        sUser.setId(id);
        sUser.setUsername(username);
        sUser.setPassword(password);
        sUserMapper.insert(sUser);
        int i = 10 / 0;
        SUser sUser2 = new SUser();
        sUser2.setId(UtilsTool.getCurrentTimeMillis());
        sUser2.setUsername("username");
        sUser2.setPassword("password");
        sUserMapper.insert(sUser2);
    }


}
