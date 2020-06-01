package cn.czl.service.impl;

import cn.czl.domain.User;
import cn.czl.mapper.UserMapper;
import cn.czl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    //注入Mapper接口
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String uname) {
        return userMapper.findByUname(uname);
    }

    @Override
    public Integer InsertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User findBasicById(Integer uid) {
        return userMapper.findBasicById(uid);
    }

    @Override
    public User findById(Integer uid) {
        return userMapper.findById(uid);
    }
}
