package com.food.mapper.custom;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom {

    List getSubCategories(Integer rootCategoryId);

    List getSixNewItemLazy(@Param("paramsMap") Map<String, Object> map);

}