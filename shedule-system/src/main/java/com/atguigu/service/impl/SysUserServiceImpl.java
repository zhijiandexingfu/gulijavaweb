package com.atguigu.service.impl;

import com.atguigu.dao.SysUserDao;
import com.atguigu.dao.impl.SysUserDaoImpl;
import com.atguigu.entity.SysUser;
import com.atguigu.service.SysUserService;
import com.atguigu.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {
    private SysUserDao sysUserDao = new SysUserDaoImpl();
    @Override
    public int register(SysUser sysUser) {
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        return sysUserDao.register(sysUser);
    }
}
