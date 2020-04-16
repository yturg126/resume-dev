package com.food.service;

import com.food.pojo.Category;
import com.food.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    List<Category> queryRootLevelCategories();
    List<CategoryVO> getSubCategories(Integer rootCategoryId);


}
