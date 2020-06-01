package cn.czl.service;

import cn.czl.domain.UserPower;

import java.util.List;

public interface PowerService {
    List<UserPower> getUpower (Integer pid);
}
