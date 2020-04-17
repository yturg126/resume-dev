package com.food.controller;


import com.food.enums.YesOrNo;
import com.food.pojo.Carousel;
import com.food.pojo.Category;
import com.food.service.CarouselService;
import com.food.service.CategoryService;
import com.food.utils.JSONResult;
import com.food.vo.CategoryVO;
import com.food.vo.NewItemsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "首页功能", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "查询所有轮播图", notes = "返回可显示的轮播图内容", httpMethod = "GET")
    @GetMapping("/carousel")
    public JSONResult carouselQueryAll() {
        List<Carousel> result = carouselService.queryAll(YesOrNo.YES.type);
        return JSONResult.ok(result);
    }


    @ApiOperation(value = "查询所有一级分类", notes = "返回一级分类列表", httpMethod = "GET")
    @GetMapping("/category")
    public JSONResult queryCategoryByLevel(){
        List<Category> result = categoryService.queryRootLevelCategories();
        return JSONResult.ok(result);
    }

    @ApiOperation(value = "查询二级分类", notes = "返回一级分类列表", httpMethod = "GET")
    @GetMapping("/subCatories/{rootCatId}")
    public JSONResult subCatories(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId){

        if (rootCatId == null) {
            return JSONResult.errorMsg("no datas");
        }

        List<CategoryVO> result = categoryService.getSubCategories(rootCatId);
        return JSONResult.ok(result);
    }

    @ApiOperation(value = "查询m每个分类下的6个分类", notes = "返回一级分类列表", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public JSONResult sixNewItems (
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId){

        if (rootCatId == null) {
            return JSONResult.errorMsg("no datas");
        }

        List<NewItemsVO> result = categoryService.getSixNewItemsLazy(rootCatId);
        return JSONResult.ok(result);
    }

}
