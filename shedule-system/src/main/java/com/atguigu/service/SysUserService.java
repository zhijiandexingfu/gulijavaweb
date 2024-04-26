package com.atguigu.service;

import com.atguigu.entity.SysUser;

public interface SysUserService {
    int register(SysUser sysUser);

    SysUser findByname(String username);
}
