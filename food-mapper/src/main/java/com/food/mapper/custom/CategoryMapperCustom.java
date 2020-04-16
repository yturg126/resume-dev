package com.food.mapper.custom;

import java.util.List;

public interface CategoryMapperCustom {

    List getSubCategories(Integer rootCategoryId);

}