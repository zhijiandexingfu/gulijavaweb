package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.SysUserDao;
import com.atguigu.entity.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {

    @Override
    public int register(SysUser sysUser) {
        String sql = "INSERT INTO `sys_user` values(DEFAULT,?,?)";
        return baseUpdate(sql, sysUser.getUserName(), sysUser.getUserPwd());
    }

    @Override
    public SysUser findByname(String username) {
        String sql = "select uid,username as userName, user_pwd as userPwd  " +
                "from sys_user where username = ?";

        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);
        return sysUserList==null||sysUserList.size()==0?null:sysUserList.get(0);
    }
}
