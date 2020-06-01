package cn.czl.service;

import cn.czl.domain.User;

public interface UserService {
    public User findByName(String uname);
    public Integer InsertUser(User user);
    public User findBasicById(Integer uid);
    public User findById(Integer uid);
}
