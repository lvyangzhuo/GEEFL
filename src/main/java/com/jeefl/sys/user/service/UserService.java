package com.jeefl.sys.user.service;

import com.jeefl.sys.user.domain.UserEntity;
import com.jeefl.sys.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lyz on 2017-9-9.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserEntity> getUser(){
        return this.userMapper.selectAll();
    }

    public UserEntity checkUserExits(UserEntity user){
        UserEntity u = new UserEntity();
        u.setName(user.getName());
        return this.userMapper.selectOne(u);
    }
}
