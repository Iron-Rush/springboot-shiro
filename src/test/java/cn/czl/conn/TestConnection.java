package cn.czl.conn;

import cn.czl.domain.User;
import cn.czl.mapper.UserMapper;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConnection {

    UserMapper userMapper;
    @Test
    void TestSelect(){
//        User user = userMapper.findByUname("caren");
//        System.out.println(user);
        User user = new User("老2","66");
        user.setUcdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        user.setUldate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(userMapper.insertUser(user));
    }
}
