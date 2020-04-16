package com.food.service;

import com.food.pojo.Carousel;

import java.util.List;

public interface CarouselService {

    List<Carousel> queryAll(Integer isShow);
}
