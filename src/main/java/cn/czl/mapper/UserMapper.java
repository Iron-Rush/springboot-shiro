package cn.czl.mapper;

import cn.czl.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    //根据用户名查找用户
//    @Select("select * from user where uname = #{uname}")
//    User findByUname(String uname);
    User findByUname(String uname);

    //插入用户
//    @Insert("insert into user(uname,upwd,ucdate,uldate) values(#{uname},#{upwd},#{ucdate},#{uldate})")
//    int insertUser(User user);
    int insertUser(User user);

    //根据id查询用户基础信息
    User findBasicById(Integer uid);
    //根据id查询用户全部信息
    User findById(Integer uid);
}
