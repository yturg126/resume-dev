package com.food.service;

import com.food.bo.UserBO;
import com.food.pojo.Users;


public interface UserService {

    /**
     * 判断用户名是否存在
     */
    boolean queryUsernameIsExist(String username);

    Users createUserInfo(UserBO userBO);

    Users queryUserForLogin(String username, String password);
}
