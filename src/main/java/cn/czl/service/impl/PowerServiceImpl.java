package cn.czl.service.impl;

import cn.czl.domain.UserPower;
import cn.czl.mapper.UserPowerMapper;
import cn.czl.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private UserPowerMapper userPowerMapper;

    @Override
    public List<UserPower> getUpower(Integer pid) {
        return userPowerMapper.getUserPowerListById(pid);
    }
}
