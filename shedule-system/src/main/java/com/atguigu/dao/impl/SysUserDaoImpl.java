package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.SysUserDao;
import com.atguigu.entity.SysUser;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {

    @Override
    public int register(SysUser sysUser) {
        String sql = "INSERT INTO `sys_user` values(DEFAULT,?,?)";
        return baseUpdate(sql, sysUser.getUserName(), sysUser.getUserPwd());
    }
}
