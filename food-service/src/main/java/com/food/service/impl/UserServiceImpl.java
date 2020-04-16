package com.food.service.impl;

import com.food.bo.UserBO;
import com.food.enums.Sex;
import com.food.mapper.UsersMapper;
import com.food.pojo.Users;
import com.food.service.UserService;
import com.food.utils.DateUtil;
import com.food.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username);
        Users users =usersMapper.selectOneByExample(userExample);
        return users != null;
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users createUserInfo(UserBO userBO) {
        Users users = new Users();
        users.setId(sid.nextShort());
        users.setUsername(userBO.getUsername());
        try {
            users.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());
        users.setBirthday(DateUtil.stringToDate("1990-01-01"));
        users.setSex(Sex.secret.type);
        int primaryKey = usersMapper.insert(users);

        if (primaryKey > 0) {
            return users;
        }
        return null;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        return null;
    }
}
