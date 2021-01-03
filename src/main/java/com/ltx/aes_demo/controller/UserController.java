package com.ltx.aes_demo.controller;

import cn.licoy.encryptbody.annotation.decrypt.AESDecryptBody;
import cn.licoy.encryptbody.annotation.encrypt.EncryptBody;
import cn.licoy.encryptbody.enums.EncryptBodyMethod;
import com.ltx.aes_demo.common.annotation.SecurityParameter;
import com.ltx.aes_demo.entity.User;
import com.ltx.aes_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Liutx
 * @date 2021/1/3 11:24
 * @Description
 */

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @SecurityParameter
    @GetMapping("getUser")
    public String getUser() {
        return userService.getUserById();
    }

    @SecurityParameter
    @PostMapping("test")
    public String test(@RequestBody User user) {
        return "hello world";
    }


    @PostMapping("/save")
    @ResponseBody
    @SecurityParameter
    public Object save(@RequestBody String info) {
        System.out.println(info);
        return info;
    }
}