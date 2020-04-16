package com.food.service;

import com.food.pojo.Stu;

public interface StuService {

    Stu getStuInfo(int id);

    void saveStu();

    void updateStu(int id);

    void deleteStu(int id);

}
