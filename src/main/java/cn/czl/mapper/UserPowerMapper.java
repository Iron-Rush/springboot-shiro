package cn.czl.mapper;

import cn.czl.domain.UserPower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserPowerMapper {
    //根据权限id查询权限列表
    List<UserPower> getUserPowerListById (@Param("pid") Integer pid);

}
