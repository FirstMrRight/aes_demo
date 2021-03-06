package com.ltx.aes_demo.service.impl;

import com.ltx.aes_demo.service.UserService;
import com.ltx.aes_demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Liutx
 * @date 2021/1/3 11:18
 * @Description
 */

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserById() {
        return User.builder().userName("关忆北").sex("男").age(18).build();
    }
}
