package com.atguigu.dao;

import com.atguigu.entity.SysUser;

public interface SysUserDao {
    int register(SysUser sysUser);

    SysUser findByname(String username);
}
