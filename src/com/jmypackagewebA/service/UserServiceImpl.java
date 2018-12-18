package com.jmypackagewebA.service;   /*这个包是逻辑处理*/

import com.jmypackagewebA.dao.IUserDao;
import com.jmypackagewebA.dao.UserDaolmpl;
import com.jmypackagewebA.pojo.User;

public class UserServiceImpl implements IUserService {
    private IUserDao dao = new UserDaolmpl();
    @Override
    public int insert(User user) {   //去调用了一下dao层
        return dao.insert(user);
    }

    @Override
    public User getOne(String username) {
        return dao.getOne(username);
    }
}
